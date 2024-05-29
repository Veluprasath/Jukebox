package service;

import database.GetConnection;
import music.MusicDetails;
import beat.Playlist;
import beat.Song;
import database.CreatePlaylist;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends MusicDetails {
    public Menu() {
    }

    public static void mainMenu() throws SQLException {
        MenuTable display = new MenuTable();
        Scanner src = new Scanner(System.in);
        GetConnection beats = new GetConnection();
        String playlistname = "";
        String finalsongs = "";
        int songId = 0;
        Playlist playlist = null;
        String songsId = "";
        String Input = "";

        System.out.println("---------------------");
        System.out.println("*** Main menu ***");
        System.out.println("---------------------");
        int selection;
        Scanner sc = new Scanner(System.in);
        ArrayList<Song> songslist  = MusicDetails.songs();

        System.out.println("1 View Songs List");
        System.out.println("2 Search Name Of The Song");
        System.out.println("3 Search Artist Of The Song");
        System.out.println("4 Search Album Of The Song");
        System.out.println("5 Search Genre Of The Song");
        System.out.println("6 Create Playlist");
        System.out.println("7 View Playlist");
        System.out.println("Enter your Choice");
        selection = sc.nextInt();

        switch (selection) {
            case 1: {
                ArrayList<Song> list = MusicDetails.songs();
                display.displaySongs(songslist);
                Menu.playSong(list);
                Menu.mainMenu();
            }
            break;


            case 2: {

                //display.displaySongs(songslist);
                System.out.println("Enter SongName");
                Input = sc.next();
                ArrayList<Song> searchSongs = MusicDetails.Searchsong(Input);
                display.displaySongs(searchSongs);
                Menu.playSong(searchSongs);
                Menu.mainMenu();

                break;
            }

            case 3: {
                System.out.println("Enter Artist of Song");
                Input = sc.nextLine();
                Input = sc.nextLine();
                ArrayList<Song> searchSongs = MusicDetails.SearchByArtist(Input);
                display.displaySongs(searchSongs);
                Menu.playSong(searchSongs);
                Menu.mainMenu();

                break;
            }

            case 4:{
                System.out.println("Enter Album of Song");
                Input = sc.nextLine();
                Input = sc.nextLine();
                ArrayList<Song> searchSongs = MusicDetails.SearchByAlbum(Input);
                display.displaySongs(searchSongs);
                Menu.playSong(searchSongs);
                Menu.mainMenu();
                break;
            }

            case 5: {
                System.out.println("Enter Genre of Song");
                Input = sc.nextLine();
                Input = sc.nextLine();
                ArrayList<Song> searchSongs = MusicDetails.SearchByGenre(Input);
                display.displaySongs(searchSongs);
                Menu.playSong(searchSongs);
                Menu.mainMenu();
                break;
            }

            case 6: {
                display.displaySongs(songslist);
                int songId1;
                System.out.println("Enter Playlist Names :");
                String playlistName = sc.nextLine();
                playlistName = sc.nextLine();
                System.out.println("your playlist is successfully created");
                do {
                    System.out.println("enter songId or press 0 to exit");
                    songId1 = sc.nextInt();
                    CreatePlaylist.createSongs(playlistName,  songId);
                } while (songId1 > 0);
                Menu.mainMenu();
            }
            break;

            case 7: {
                MusicDetails.viewPlaylist();
                System.out.println("Enter playlist name to view");
                String playlistName = sc.next();
                ArrayList<Song> list = MenuTable.displayPlaylist(playlistName);
                MenuTable.displaySongs(list);
                Menu.playSong(list);
                Menu.mainMenu();
                break;

            }
            case 8:{
                System.out.println("--------------------------------------");
                System.out.println("****THANK YOU ****");
                System.out.println("---------------------------------------");
                break;
            }
        }
    }
    public static void playSong(ArrayList<Song> Music) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Play all songs\n2.Your Selected Songs\n3.Go To Main menu ");
        int opt = sc.nextInt();
        int songId = 0;
        switch (opt) {

            case 1: {
                PlayMusic.playList(Music);
                break;
            }

            case 2: {
                System.out.println("Enter song id");
                songId = sc.nextInt();
                PlayMusic.playSong(Music, songId);
                break;
            }

            case 3: {
                Menu.mainMenu();
                break;
            }
        }
        System.out.println("------------------------------------------");
    }
}