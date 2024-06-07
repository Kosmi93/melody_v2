package ru.bip.melodyv2;

import java.io.IOException;

public class VideoThead implements Runnable{
    private String fileName;

    public VideoThead(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            Process processes = new ProcessBuilder().command("cmd", "/C", fileName).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
