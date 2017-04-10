/**
 * Created by jgoodson2 on 4/10/17.
 */

import java.util.Scanner;

public class Playlist {

    private String title;
    private SongEntry head;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input_title;
        String input_option;

        System.out.println("Enter playlist's title:");
        input_title = scan.nextLine();

        Playlist pl = new Playlist(input_title);

        pl.printMenu();
        input_option = scan.next();

        //clear the scanner
        scan.nextLine();


    }

    void outputFullPlaylist() {

        int count = 0;
        SongEntry currSong = this.getHead();

        System.out.println(this.getTitle() + " - OUTPUT FULL PLAYLIST");

        if (this.getHead() == null) {
            System.out.println("Playlist is empty");
        } else {
            this.getHead().printPlaylistSongs();

            while (currSong.getNext() != null) {
                currSong = currSong.getNext();
                currSong.printPlaylistSongs();
            }
        }
    }

    void printMenu() {
        System.out.println(this.getTitle() + " PLAYLIST MENU\n" +
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

    void addSong() {

        String inputUid;
        String inputSongTitle;
        String inputartistName;
        int inputLength;
        SongEntry tail = this.getTail();

        SongEntry se = new SongEntry();
        se.insertAfter(tail);
    }

    private SongEntry getTail() {
        //TODO finish this
        return new SongEntry();
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
}
