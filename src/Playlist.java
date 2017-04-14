/**
 * Created by jgoodson2 on 4/10/17.
 */

import java.util.Scanner;

public class Playlist {

    private String title;
    private SongEntry head;
    private static String stringPlaylistEmpty = "Playlist is empty";

    private void changePosition(Scanner scan) {

        int inputCurrPosition;
        int inputNewPosition;
        SongEntry se;
        SongEntry currPrevSe;
        SongEntry currNextSe;
        SongEntry newPrevSe;
        SongEntry newNextSe;

        System.out.println("\nCHANGE POSITION OF SONG");

        System.out.println("Enter song's current position:");
        inputCurrPosition = scan.nextInt();
        scan.nextLine();//clear the scanner
        if (inputCurrPosition > this.getLength()) {
            System.out.println("Error: invalid position. Playlist " + this.getTitle()
                    + " consists of " + this.getLength() + " song entries.");
            return;
        }

        System.out.println("Enter new position for song:");
        inputNewPosition = scan.nextInt();
        scan.nextLine();//clear the scanner
        if (inputNewPosition > this.getLength()) {
            inputNewPosition = this.getLength();
        }

        //If the user enters a new position that is less than 1, move the node to the position 1 (the head).
//        if (inputNewPosition < 1 && inputCurrPosition > 1/*if the node is already the head, no need to do anything*/) {
        if (
            //nothing needs to be done if head node is to changed to head position
            // or tail node is to be changed to tail position
            // or current position is the same as new position
                !((inputNewPosition < 2 && inputCurrPosition == 1)
                        || (inputNewPosition >= this.getLength()) && inputCurrPosition == this.getLength())
                        || (inputCurrPosition != inputNewPosition)
                ) {
            se = getEntryAtIndex(inputCurrPosition);
            currPrevSe = (getEntryAtIndex(inputCurrPosition - 1) == null) ? null : getEntryAtIndex(inputCurrPosition - 1);
            currNextSe = (getEntryAtIndex(inputCurrPosition + 1) == null) ? null : getEntryAtIndex(inputCurrPosition + 1);

            //take node out cleanly
            if (inputCurrPosition == 1) {
                this.setHead(currNextSe);
            } else if (inputCurrPosition == this.getLength()) {
                currPrevSe.setNext(null);
            } else {
                currPrevSe.setNext(currNextSe);
            }

            newPrevSe = (getEntryAtIndex(inputNewPosition - 1) == null) ? null : getEntryAtIndex(inputNewPosition - 1);
            newNextSe = (getEntryAtIndex(inputNewPosition) == null) ? null : getEntryAtIndex(inputNewPosition);

            //add node at new position
            if (inputNewPosition == 1) {
                this.setHead(se);
                se.setNext(newNextSe);
            } else if (inputNewPosition == this.getLength() + 1) {
                se.setNext(null);
                newPrevSe.setNext(se);
            } else {
                newPrevSe.setNext(se);
                se.setNext(newNextSe);
            }
        }
    }

    private SongEntry getEntryAtIndex(int inputCurrPosition) {
        if (inputCurrPosition == 0) return null;

        SongEntry se = this.getHead();
        for (int i = 0; i < inputCurrPosition - 1; ++i) {
            se = se.getNext();
        }
        return se;
    }


    private void removeSong(Scanner scan) {

        String inputUid;
        SongEntry prevSE;

        System.out.println("\nREMOVE SONG");
        if (this.getHead() == null) {
            System.out.println(stringPlaylistEmpty);
        } else {
            System.out.println("Enter song's unique ID:");
            inputUid = scan.nextLine();

            //removing HEAD is a little special
            if (inputUid.equals(this.getHead().getID())) {
                if (this.getHead().getNext() == null) {
                    this.setHead(null);
                } else {
                    this.setHead(this.getHead().getNext());
                }
            } else {
                prevSE = getEntryB4Match(inputUid);
                if (prevSE == null) {
                    System.out.println("Entry does not exist.");
                } else /*entry exists*/ if (prevSE.getNext().getNext() != null) {
                    prevSE.setNext(prevSE.getNext().getNext());
                } else /*remove last entry*/ {
                    prevSE.setNext(null);
                }
            }
        }
    }

    private SongEntry getEntryB4Match(String inputUid) {
        SongEntry prevSE = this.getHead();
        while (prevSE.getNext() != null) {
            if (prevSE.getNext().getID().equals(inputUid)) {
                return prevSE;
            }
            prevSE = prevSE.getNext();
        }
        return null;
    }

    private void outputFullPlaylist() {

        int count = 0;
        SongEntry currSong = this.getHead();

        System.out.println(this.getTitle() + " - OUTPUT FULL PLAYLIST");

        if (this.getHead() == null) {
            System.out.println(stringPlaylistEmpty);
        } else {
            System.out.println(++count + ".");
            this.getHead().printPlaylistSongs();

            while (currSong.getNext() != null) {
                currSong = currSong.getNext();
                System.out.println(++count + ".");
                currSong.printPlaylistSongs();
            }
        }
    }

    private SongEntry getTail() {

        SongEntry tail;
        SongEntry currSE;

        if (this.getHead() == null) {
            tail = null;
        } else if (this.getHead().getNext() == null) {
            tail = this.getHead();
        } else {
            currSE = this.getHead().getNext();
            while (currSE.getNext() != null) {
                currSE = currSE.getNext();
            }
            tail = currSE;
        }
        return tail;
    }

    public Playlist(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public SongEntry getHead() {
        return head;
    }

    public void setHead(SongEntry head) {
        this.head = head;
    }

    public int getLength() {

        int length = 0;
        SongEntry currSE;

        if (this.getHead() != null) {
            length++;
            currSE = this.getHead();

            while (currSE.getNext() != null) {
                length++;
                currSE = currSE.getNext();
            }
        }

        return length;
    }

    private void processOption(String inputOption, Scanner scan) {

        switch (inputOption) {
            case "a":
                addSong(scan);
                break;
            case "d":
                removeSong(scan);
                break;
            case "c":
                changePosition(scan);
                break;
            case "s":
                outputArtistSongs(scan);
                break;
            case "t":
                System.out.println("selected 't' - Output total time of playlist (in seconds)");
                break;
            case "o":
                outputFullPlaylist();
                break;
            //only for testing; remove for deliverable
            case "gl":
                System.out.println("length = " + this.getLength());
                break;
            //END OF only for testing; remove for deliverable
            case "q":
                break;
            default:
                System.out.println("Invalid option entered.  Please enter valid menu option.");

        }
    }

    private void outputArtistSongs(Scanner scan) {

        System.out.println("OUTPUT SONGS BY SPECIFIC ARTIST");
        System.out.println("Enter artist's name:");
        String artist = scan.nextLine().replaceAll("\\s", "").toLowerCase();

        int count = 1;
        SongEntry currSong;


        if (this.getHead() == null) {
            System.out.println(stringPlaylistEmpty);
        } else {
            currSong = this.getHead();
//            System.out.println(++count + ".");
            if (currSong.getArtistName().replaceAll("\\s", "").toLowerCase().equals(artist)) {
                System.out.println(++count + ".");
                currSong.printPlaylistSongs();
            }

            while (currSong.getNext() != null) {
                if (currSong.getArtistName().replaceAll("\\s", "").toLowerCase().equals(artist)) {
                    currSong = currSong.getNext();
                    System.out.println(++count + ".");
                    currSong.printPlaylistSongs();
                }
            }
        }
    }


    private void addSong(Scanner scan) {
        String inputUid;
        String inputSongTitle;
        String inputArtistName;
        int inputLength;

        System.out.println("\nADD SONG");

        //uncomment for deliverable
        System.out.println("Enter song's unique ID:");
        inputUid = scan.nextLine();
        System.out.println("Enter song's name:");
        inputSongTitle = scan.nextLine();
        System.out.println("Enter artist's name:");
        inputArtistName = scan.nextLine();
        System.out.println("Enter song's length (in seconds):");
        inputLength = scan.nextInt();
        scan.nextLine();//clear the scanner

        SongEntry se = new SongEntry(inputUid, inputSongTitle, inputArtistName, inputLength, null);

        if (this.getHead() == null) {
            this.setHead(se);
        } else {
            se.insertAfter(this.getTail());
        }
        //END OF uncomment for deliverable


        //FOR TESTING ONLY - autopopulate songs
//        for (int i = 1; i <= 7; ++i) {
//            SongEntry se2 = new SongEntry(Integer.toString(i), Integer.toString(i), Integer.toString(i), i, null);
//
//            if (this.getHead() == null) {
//                this.setHead(se2);
//            } else {
//                se2.insertAfter(this.getTail());
//            }
//        }
        //end of FOR TESTING ONLY
    }

    private void printMenu() {
        System.out.println(this.getTitle().toUpperCase() + " PLAYLIST MENU\n" +
                "a - Add song\n" +
                "d - Remove song\n" +
                "c - Change position of song\n" +
                "s - Output songs by specific artist\n" +
                "t - Output total time of playlist (in seconds)\n" +
                "o - Output full playlist\n" +
                "gl - Get playlist length\n" +
                "q - Quit\n" +
                "\n" +
                "Choose an option:");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input_title;
        String inputOption;

        System.out.println("Enter playlist's title:");
        input_title = scan.nextLine().toUpperCase();

        Playlist pl = new Playlist(input_title);

        do {
            System.out.println();
            pl.printMenu();
            inputOption = scan.next().toLowerCase();
            scan.nextLine();//clear the scanner
            pl.processOption(inputOption, scan);
        } while (!inputOption.equals("q"));
    }
}
