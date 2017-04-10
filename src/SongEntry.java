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
}
