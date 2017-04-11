/**
 * Created by jgoodson2 on 4/10/17.
 */
public class SongEntry {

    private String uniqueID;
    private String songName;
    private String artistName;
    private int songLength;
    private SongEntry nextNode;

    public SongEntry() {
        this.uniqueID = "none";
        this.songName = "none";
        this.artistName = "none";
        this.songLength = 0;
        this.nextNode = null;
    }

    public SongEntry(String uniqueID, String songName, String artistName, int songLength, SongEntry nextNode) {
        this.uniqueID = uniqueID;
        this.songName = songName;
        this.artistName = artistName;
        this.songLength = songLength;
        this.nextNode = nextNode;
    }

    //    Public member methods
    public void insertAfter(SongEntry currNode) {
        currNode.setNext(this);
    }

    public void setNext(SongEntry nextNode) {
        this.nextNode = nextNode;
    }

    public String getID() {
        return uniqueID;
    }

    public String getSongName() {
        return songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public int getSongLength() {
        return songLength;
    }

    public SongEntry getNext() {
        return nextNode;
    }

    public void printPlaylistSongs() {
        System.out.println("Unique ID: " + uniqueID);
        System.out.println("Song Name: " + songName);
        System.out.println("Artist Name: " + artistName);
        System.out.println("Song Length (in seconds): " + songLength + "\n");
    }

}
