package music;

import beat.Playlist;
import beat.Song;
import beat.user;
import database.GetConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MusicDetails {

    public static ArrayList<Song> songs() {
        GetConnection con = new GetConnection();
        Connection connection = con.getConnection();
        ArrayList<Song> list = new ArrayList<>();
        Song song = null;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from songs");
            while (rs.next()) {
                song = new Song(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getFloat(6), rs.getString(7));
                list.add(song);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public static ArrayList<Song> Searchsong(String Song) {
        GetConnection con = new GetConnection();
        Connection connection = con.getConnection();
        ArrayList<Song> search = new ArrayList<>();
        Song song = null;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from songs where songName='" + Song + "';");
            while (rs.next()) {
                song = new Song(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getFloat(6), rs.getString(7));
                search.add(song);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return search;
    }

    public static ArrayList<Song> SearchByGenre(String Song) {
        GetConnection con = new GetConnection();
        Connection connection = con.getConnection();
        ArrayList<Song> search = new ArrayList<>();
        Song song = null;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from songs where genre='" + Song + "';");
            while (rs.next()) {
                song = new Song(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getFloat(6), rs.getString(7));
                search.add(song);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return search;
    }

    public static ArrayList<Song> SearchByArtist(String Song) {
        GetConnection con = new GetConnection();
        Connection connection = con.getConnection();
        ArrayList<Song> search = new ArrayList<>();
        Song song = null;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from songs where artistName='" + Song + "';");
            while (rs.next()) {
                song = new Song(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getFloat(6), rs.getString(7));
                search.add(song);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return search;
    }
    public static ArrayList<Playlist> viewAllPlaylist() {
        GetConnection con = new GetConnection();
        Connection connection = con.getConnection();
        ArrayList<Playlist> list = new ArrayList<>();
        Playlist playlist = null;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from playlist");
            while (rs.next()) {
                playlist = new Playlist(rs.getInt(1), rs.getString(2),rs.getString(3));
                list.add(playlist);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    public static void viewPlaylist() {
        String playlistName="";
        GetConnection con=new GetConnection();
        Connection connection = con.getConnection();
        ArrayList<Playlist> list=new ArrayList<>();
        Playlist playlist=null;
        try{
            Statement st = connection.createStatement();
            ResultSet rs=st.executeQuery("select * from playlist");
            System.out.println("All playlist Names :");
            while (rs.next()){
                if(!playlistName.equals(rs.getString(2))){
                    System.out.println(rs.getString(2));
                }
                playlistName = rs.getString(2);

            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    public static ArrayList<user> user(){
        GetConnection con=new GetConnection();
        Connection connection=con.getConnection();
        ArrayList<user>list=new ArrayList<>();
        user use=null;

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from users");
            while (rs.next()){
                use=new user(rs.getInt(1),rs.getString(2),rs.getString(3));
                list.add(use);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return list;
    }

    public static ArrayList<Song> SearchByAlbum(String Song) {
        GetConnection con = new GetConnection();
        Connection connection = con.getConnection();
        ArrayList<Song> search = new ArrayList<>();
        Song song = null;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from songs where album='" + Song + "';");
            while (rs.next()) {
                song = new Song(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getFloat(6), rs.getString(7));
                search.add(song);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return search;
    }
}