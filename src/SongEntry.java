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
}
