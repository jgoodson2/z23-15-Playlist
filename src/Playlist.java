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

    private static void processOption(String input_option, Playlist pl, Scanner scan) {

        switch (input_option) {
            case "a":
                addSong(pl, scan);
                break;
            case "d":
                System.out.println("selected 'd' - Remove song");
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
                System.out.println("selected 'q' - Quit");
                break;
            default:
                System.out.println("Invalid option entered.  Please enter valid menu option.");

        }

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
            System.out.println("Playlist is empty");
        } else {
            pl.getHead().printPlaylistSongs();

            while (currSong.getNext() != null) {
                currSong = currSong.getNext();
                currSong.printPlaylistSongs();
            }
        }
    }

    private static void addSong(Playlist pl, Scanner scan) {

        String inputUid;
        String inputSongTitle;
        String inputArtistName;
        int inputLength;
        SongEntry tail = pl.getTail();

        System.out.println("ADD SONG");
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
