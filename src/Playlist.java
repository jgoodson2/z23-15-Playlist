/**
 * Created by jgoodson2 on 4/10/17.
 */

import java.util.Scanner;

public class Playlist {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input_title;
        String input_option;

        System.out.println("Enter playlist's title:");
        input_title = scan.nextLine().toUpperCase();

        Playlist pl = new Playlist(input_title);

        do {
            System.out.println();
            printMenu(pl);

            input_option = scan.next().toLowerCase();
            scan.nextLine();//clear the scanner

            processOption(input_option, pl, scan);
        } while (!input_option.equals("q"));

    }

    private String title;
    private SongEntry head;
    private static String stringPlaylistEmpty = "Playlist is empty";

    private static void processOption(String input_option, Playlist pl, Scanner scan) {

        switch (input_option) {
            case "a":
                addSong(pl, scan);
                break;
            case "d":
                removeSong(pl, scan);
                break;
            case "c":
                System.out.println("selected 'c' - Change position of song");
                break;
            case "s":
                System.out.println("selected 's' - Output songs by specific artist");
                break;
            case "t":
                System.out.println("selected 't' - Output total time of playlist (in seconds)");
                break;
            case "o":
                outputFullPlaylist(pl);
                break;
            case "q":
                break;
            default:
                System.out.println("Invalid option entered.  Please enter valid menu option.");

        }

    }

    private static void removeSong(Playlist pl, Scanner scan) {

        String inputUid;
        SongEntry prevSE;

        System.out.println("\nREMOVE SONG");
        if (pl.getHead() == null) {
            System.out.println(stringPlaylistEmpty);
        } else {
            System.out.println("Enter song's unique ID:");
            inputUid = scan.nextLine();

            //removing HEAD is a little special
            if (inputUid.equals(pl.getHead().getID())) {

                if (pl.getHead().getNext() == null) {

                    pl.setHead(null);
                } else {

                    pl.setHead(pl.getHead().getNext());
                }
            } else {

                prevSE = getEntryB4Match(pl, inputUid);
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

    private static SongEntry getEntryB4Match(Playlist pl, String inputUid) {
        SongEntry prevSE = pl.getHead();
        while (prevSE.getNext() != null) {
            if (prevSE.getNext().getID().equals(inputUid)) {
                return prevSE;
            }
            prevSE = prevSE.getNext();
        }
        return null;
    }


    private static void addSong(Playlist pl, Scanner scan) {

        String inputUid;
        String inputSongTitle;
        String inputArtistName;
        int inputLength;
        SongEntry tail = pl.getTail();

        System.out.println("\nADD SONG");
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

        if (pl.getHead() == null) pl.setHead(se);
        if (tail != null) se.insertAfter(tail);
    }

    private static void printMenu(Playlist pl) {
        System.out.println(pl.getTitle().toUpperCase() + " PLAYLIST MENU\n" +
                "a - Add song\n" +
                "d - Remove song\n" +
                "c - Change position of song\n" +
                "s - Output songs by specific artist\n" +
                "t - Output total time of playlist (in seconds)\n" +
                "o - Output full playlist\n" +
                "q - Quit\n" +
                "\n" +
                "Choose an option:");
    }

    private static void outputFullPlaylist(Playlist pl) {

        int count = 0;
        SongEntry currSong = pl.getHead();

        System.out.println(pl.getTitle() + " - OUTPUT FULL PLAYLIST");

        if (pl.getHead() == null) {
            System.out.println(stringPlaylistEmpty);
        } else {
            System.out.println(++count + ".");
            pl.getHead().printPlaylistSongs();

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
}
