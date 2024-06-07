package ru.bip.melodyv2;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Melody extends Thread {
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        Player player;// = new Player(music1);
        try (FileInputStream file = new FileInputStream(fileName)) {
            player = new Player(file);
            player.play();// заходим
            System.out.println(fileName);
        } catch (JavaLayerException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
