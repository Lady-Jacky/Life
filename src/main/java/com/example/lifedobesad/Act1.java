package com.example.lifedobesad;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class Act1 implements Initializable {
    @FXML
    private Button act1Button;
    @FXML
    private ImageView jakyView;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        delay(2000, () -> playAct1());
        delay(2000, () -> switchCostumes(10));
    }

    @FXML
    protected void playAct1() {
        if (act1Button != null) {
            act1Button.setVisible(false);
            act1Button.setDisable(true);
        } else {
            System.out.println("act1Button is null");
        }
    }

    private void switchCostumes(int time) {
        String[] costumes = {
                "/costume1.png",
                "/costume3.png",
                "/costume2.png",
                "/costume4.png"
        };
        for(int i = 0; i < time; i++) {
            for(int k = 0; k < costumes.length; k++ ) {
                Image costu = new Image(costumes[k]);
                jakyView.setImage(costu);
                System.out.println(k);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // Handle interrupted exception
                    e.printStackTrace();
                }
            }
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
