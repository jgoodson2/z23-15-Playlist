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
        //TODO: finish
        System.out.println("call to void insertAfter(SongEntry currNode)");
    }

    public void setNext(SongEntry nextNode) {
        //TODO: finish
        System.out.println("call to void setNext(SongEntry nextNode)");
    }

    public String getID() {
        return uniqueID;
    }

    public String getSongName() {
        //TODO: finish
        return "need to implement String getSongName()";
    }

    public String getArtistName() {
        //TODO: finish
        return "need to implement String getArtistName()";
    }

    public int getSongLength() {
        //TODO: finish
        return -1;
    }

    public SongEntry getNext() {
        //TODO: finish
        return null;
    }

    public void printPlaylistSongs() {
        //TODO: finish
        System.out.println("call to void printPlaylistSongs()");
    }

}
