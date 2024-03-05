package com.example.lifedobesad;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.nio.file.Paths;

import static java.nio.file.Paths.get;

public class SceneController extends StartAnimation{

    private String song;

    @FXML
    protected void startArc1() {
        mediaPlayer.stop();
        songPlaying = false;
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
        switchToArc1();
    }

    protected void switchToArc1() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(StartAnimation.class.getResource("arc1.fxml"));
            Parent root = fxmlLoader.load();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        delay(3000, () -> animateArc1());
    }

    protected void animateArc1() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(StartAnimation.class.getResource("art1Animation.fxml"));
            Parent root = fxmlLoader.load();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
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

    //Credits to Dave8 for this delay method:
    // https://stackoverflow.com/questions/26454149/make-javafx-wait-and-continue-with-code
    public static void delay(long millis, Runnable continuation) {
        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try { Thread.sleep(millis); }
                catch (InterruptedException e) { }
                return null;
            }
        };
        sleeper.setOnSucceeded(event -> continuation.run());
        new Thread(sleeper).start();
    }
}