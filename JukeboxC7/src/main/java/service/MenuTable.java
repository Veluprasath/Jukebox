package service;

import music.MusicDetails;
import beat.Playlist;
import beat.Song;
import database.GetConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class MenuTable {
    public static void displaySongs(ArrayList<Song> Songs) {
        Iterator<Song> i = Songs.iterator();
        Song song ;

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.printf(" %-10s  %-30s  %-25s  %-18s  %-20s  %-18s\n", "Song Id", "Song Name", "Artist", "Genre","Album","Duration");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        while(i.hasNext()) {
            song=i.next();
            System.out.printf(" %-10s  %-30s  %-25s  %-18s  %-20s  %-18s\n", song.getSongId(), song.getSongName(), song.getArtist(), song.getGenre() ,song.getAlbum(), song.getDuration());
        }
    }

    public static ArrayList<Song> displayPlaylist(String play) throws SQLException {
        ArrayList<Song>list=new ArrayList<>();
        ArrayList<Song> songslist = MusicDetails.songs();
        Connection connection = GetConnection.getConnection();
        Playlist playlist = null;
        String songs = "";
        Iterator<Song> i= songslist.iterator();
        Statement st = connection.createStatement();
        Song song = null;
        ResultSet rs = st.executeQuery("select * from playlist");
        ArrayList<Integer>songId=new ArrayList<>();
        while (rs.next()) {
            if (rs.getString(2).equals(play)){
                songId.add(rs.getInt(4));

            }
        }
        int ip=songId.size();
        System.out.println(ip);
        while (i.hasNext()){
            song=i.next();
            for (int x=0;x<=ip-1;x++){
                if (song.getSongId()==songId.get(x)){
                    list.add(song);
                }
            }
        }
        return list;
    }
}