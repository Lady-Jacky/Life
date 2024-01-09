package com.example.lifedobesad;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.net.URI;
import java.nio.file.Paths;

import static java.nio.file.Paths.get;

public class SceneController {

    String song = "Audio/song1.mp3";
    @FXML
    protected void onStartButtonClick() {
        String mediaPath = Paths.get(song).toUri().toString();
        Media regretOST = new Media(mediaPath);
        MediaPlayer mediaPlayer = new MediaPlayer(regretOST);
        mediaPlayer.setVolume(0.25);
        mediaPlayer.play();
    }
}