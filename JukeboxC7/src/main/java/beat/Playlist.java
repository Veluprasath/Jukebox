package beat;
public class Playlist {
    private String playlistName;
    private String songsId;

    public Playlist(int anInt, String playlistName, String songsId) {
        //this.playlistId = playlistId;
        this.playlistName = playlistName;
        this.songsId = songsId;
    }

    //public int getPlaylistId() {
       // return playlistId;
    //}

    //public void setPlaylistId(int playlistId) {
      //  this.playlistId = playlistId;
    //}

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public String getSongsId() {
        return songsId;
    }

    public void setSongsId(String songsId) {
        this.songsId = songsId;
    }

}
