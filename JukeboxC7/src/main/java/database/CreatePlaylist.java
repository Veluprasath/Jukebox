package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreatePlaylist {
    public static void createSongs(String playlistname, int songId) {
        Connection con = GetConnection.getConnection();

        try {
            Statement st = con.createStatement();
            st.executeUpdate("insert into playlist(playlistname,songsId) values('"+playlistname+"',"+songId+");");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

