package service;

import beat.Song;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class PlayMusic {
    public static void playList(ArrayList<Song> list){
        Scanner scanner = new Scanner(System.in);
        Iterator<Song> i= list.iterator();
        Song song=null;
        String response = "";

        try {
            while (!(response.equalsIgnoreCase("0")||response.equalsIgnoreCase("6"))) {
                while (i.hasNext() && !(response.equalsIgnoreCase("0") && !(response.equalsIgnoreCase("6") ) )) {

                    song=i.next();
                    System.out.println(song.geturl());

                    File file = new File(song.geturl());
                    if (file.exists()) {
                        AudioInputStream audioinput = AudioSystem.getAudioInputStream(file);
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioinput);
                        clip.start();
                        do {
                            System.out.println("1.Play 2.Pause 3.Reset 4.Forward 5.Backward 6.Next 0.Stop");
                            response = scanner.next();
                            switch (response) {
                                case ("1") : {
                                    clip.start();
                                    break;
                                }
                                case ("2") :{
                                    clip.stop();
                                    break;
                                }

                                case ("3") :
                                {
                                    clip.setMicrosecondPosition(0);
                                    break;
                                }

                                case("4"):
                                {
                                    clip.setMicrosecondPosition(clip.getMicrosecondPosition()+10000000);
                                    System.out.println("song forwarded by 10 sec");
                                    break;
                                }
                                case("5"):
                                {
                                    clip.setMicrosecondPosition(clip.getMicrosecondPosition()-10000000);
                                    System.out.println("song backwarded by 10sec");
                                    break;
                                }
                                case ("6") :
                                {
                                    clip.close();
                                    break;
                                }
                                case ("0") :
                                {
                                    clip.close();
                                    break;
                                }

                                default :
                                    System.out.println(" Invalid Response ");
                                    break;

                            }
                        }
                        while (!response.equalsIgnoreCase("0")&&!response.equalsIgnoreCase("6"));
                    }
                    else{
                        System.out.println("file not found");}
                }}
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void playSong(ArrayList<Song> list,int a){
        Scanner scanner = new Scanner(System.in);
        Iterator<Song> i= list.iterator();
        Song song=null;
        String response ="";
        try {
            while (i.hasNext() && (!(response.equalsIgnoreCase("0"))) ) {
                song=i.next();
                if (a==(song.getSongId())){

                    File file = new File(song.geturl());
                    if (file.exists()) {
                        AudioInputStream audioinput = AudioSystem.getAudioInputStream(file);
                        Clip clip = AudioSystem.getClip();
                        clip.open(audioinput);

                        do {

                            System.out.println("1.Play 2.Pause 3.Reset 4.Forward 5.Backward 0.Stop");
                            response = String.valueOf(scanner.next());
                            switch (response) {
                                case ("1") :
                                {
                                    clip.start();
                                    break;
                                }

                                case ("2"), ("0"):
                                {
                                    clip.stop();
                                    break;
                                }
                                case ("3") : {
                                    clip.setMicrosecondPosition(0);
                                    break;
                                }
                                case("4"):
                                {
                                    clip.setMicrosecondPosition(clip.getMicrosecondPosition()+10000000);
                                    System.out.println("song forwarded by 10 sec");
                                    break;
                                }
                                case("5"):
                                {
                                    clip.setMicrosecondPosition(clip.getMicrosecondPosition()-10000000);
                                    System.out.println("song backwarded by 10sec");
                                    break;
                                }
                                default :
                                {
                                    System.out.println("Not a valid response");
                                    break;
                                }
                            }
                        } while (!(response.equalsIgnoreCase("0")));
                    }
                    else{
                        System.out.println("file not found");}
                }}
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}