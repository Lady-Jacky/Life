package com.example.lifedobesad;

import javafx.fxml.FXML;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.nio.file.Paths;

import static java.nio.file.Paths.get;

public class SceneController extends StartAnimation{

    private static MediaPlayer mediaPlayer;
    private String song;

    @FXML
    protected void startArc1() {
        song = "Audio/song1.mp3";
        String mediaPath = Paths.get(song).toUri().toString();
        Media regretOST = new Media(mediaPath);
        mediaPlayer = new MediaPlayer(regretOST);
        mediaPlayer.setVolume(0.25);
        System.out.println(songPlaying);
        if(!songPlaying) {
            songPlaying = true;
            mediaPlayer.play();
        }
    }

    @FXML
    protected void startArc2() {
        song = "Audio/Gone Forever.mp3";
        String mediaPath = Paths.get(song).toUri().toString();
        Media regretOST = new Media(mediaPath);
        mediaPlayer = new MediaPlayer(regretOST);
        mediaPlayer.setVolume(0.25);
        if(!songPlaying) {
            songPlaying = true;
            mediaPlayer.play();
        }
    }
}