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

        System.out.println("Enter playlist's title:");
        input_title = scan.nextLine();

        Playlist pl = new Playlist(input_title);


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

    public Playlist(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
