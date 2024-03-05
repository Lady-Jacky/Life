package com.example.lifedobesad;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.nio.file.Paths;

import java.io.IOException;

public class StartAnimation extends Application {
    protected static boolean songPlaying;
    protected static FXMLLoader fxmlLoader;

    protected static MediaPlayer mediaPlayer;
    protected static Stage stage;
    @Override
    public void start(Stage menuStage) throws IOException {
        stage = menuStage;
        fxmlLoader = new FXMLLoader(StartAnimation.class.getResource("start.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Life do be sad huh");
        stage.setScene(scene);
        playBackgroundMusic();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void playBackgroundMusic() {
        String song = "Audio/Gone Forever.mp3";
        String mediaPath = Paths.get(song).toUri().toString();
        Media regretOST = new Media(mediaPath);
        mediaPlayer = new MediaPlayer(regretOST);
        mediaPlayer.setVolume(0.25);
        mediaPlayer.play();
        songPlaying = true;
    }

}