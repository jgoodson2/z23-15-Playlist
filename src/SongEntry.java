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
    void insertAfter(SongEntry currNode) {
        //TODO: finish
        System.out.println("call to void insertAfter(SongEntry currNode)");
    }

    void setNext(SongEntry nextNode) {
        //TODO: finish
        System.out.println("call to void setNext(SongEntry nextNode)");
    }

    String getID() {
        //TODO: finish
        return "need to implement String getID()";
    }

    String getSongName() {
        //TODO: finish
        return "need to implement String getSongName()";
    }

    String getArtistName() {
        //TODO: finish
        return "need to implement String getArtistName()";
    }

    int getSongLength() {
        //TODO: finish
        return -1;
    }

    SongEntry getNext() {
        //TODO: finish
        return null;
    }

    void printPlaylistSongs() {
        //TODO: finish
        System.out.println("call to void printPlaylistSongs()");
    }

}
