package ru.bip.melodyv2;

import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class HelloController {
    private Timeline timeline;
    private Config config = new Config();
    private Process[] processes = new Process[6];

    @FXML
    private TextField aptekaText;

    @FXML
    private TextField createText;

    @FXML
    private TextField maximText;


    @FXML
    private Button buttonStart;

    @FXML
    private Button buttonStop;

    @FXML
    private Label timer;

    @FXML
    void onStop(ActionEvent event) {

       /* timeline.stop();
        buttonStop.setDisable(true);
        buttonStart.setDisable(false);*/
    }

    private void playStart(String fileName) {
        Melody melody = new Melody();
        melody.setFileName(fileName);
        melody.start();
    }

    //создание подкаталогов для каждого аккредитуемого
    private Path[] greatSubdirectories(Path newPath) throws IOException {
        System.out.println(newPath.toAbsolutePath());
        String[] subdirectories = new String[]{aptekaText.getText(), createText.getText(), maximText.getText()};
        Path[] subdirectoriesPath = new Path[subdirectories.length];
        for (int i = 0; i < subdirectories.length; i++) {
            if (subdirectories[i].equals("")) {
                subdirectoriesPath[i] = Path.of(newPath.toAbsolutePath() + "\\" + i);
            } else {
                subdirectoriesPath[i] = Path.of(newPath.toAbsolutePath() + "\\" + subdirectories[i]);
            }
            Files.createDirectories(subdirectoriesPath[i]);
        }
        return subdirectoriesPath;
    }

    //создание подкаталогов для нового прохода
    private Path getNewPath(Path directoryPath) {
        File[] dirs = directoryPath.toFile().listFiles();
        int newNumber = 1;
        if (dirs != null) {
            newNumber = dirs.length + 1;
        }
        Path newPath = Path.of(directoryPath.toString() + "\\" + newNumber);
        return newPath;
    }

    private String[] greatFilesPath(Path[] directorysPath) {
        String[] filesPath = new String[18];
        //первый круг
        filesPath[0] = config.getCAM_MEDICINE_DISPENSING_ROOM_1() + " " + directorysPath[0].toString() + "\\БИП-фарм-отпуск-" + directorysPath[0].getFileName() + "-к1.mp4";
        filesPath[1] = config.getCAM_MEDICINE_DISPENSING_ROOM_2() + " " + directorysPath[0].toString() + "\\БИП-фарм-отпуск-" + directorysPath[0].getFileName() + "-к2.mp4";

        filesPath[2] = config.getCAM_MEDICINE_MANUFACTURING_ROOM_1() + " " + directorysPath[1].toString() + "\\БИП-фарм-изготовление-" + directorysPath[1].getFileName() + "-к1.mp4";
        filesPath[3] = config.getCAM_MEDICINE_MANUFACTURING_ROOM_2() + " " + directorysPath[1].toString() + "\\БИП-фарм-изготовление-" + directorysPath[1].getFileName() + "-к2.mp4";

        filesPath[4] = config.getCAM_FIRST_AID_ROOM_1() + " " + directorysPath[2].toString() + "\\БИП-фарм-помощь-" + directorysPath[2].getFileName() + "-к1.mp4";
        filesPath[5] = config.getCAM_FIRST_AID_ROOM_2() + " " + directorysPath[2].toString() + "\\БИП-фарм-помощь-" + directorysPath[2].getFileName() + "-к2.mp4";

        //второй круг
        filesPath[6] = config.getCAM_MEDICINE_MANUFACTURING_ROOM_1() + " " + directorysPath[0].toString() + "\\БИП-фарм-изготовление-" + directorysPath[0].getFileName() + "-к1.mp4";
        filesPath[7] = config.getCAM_MEDICINE_MANUFACTURING_ROOM_2() + " " + directorysPath[0].toString() + "\\БИП-фарм-изготовление-" + directorysPath[0].getFileName() + "-к2.mp4";

        filesPath[8] = config.getCAM_FIRST_AID_ROOM_1() + " " + directorysPath[1].toString() + "\\БИП-фарм-помощь-" + directorysPath[1].getFileName() + "-к1.mp4";
        filesPath[9] = config.getCAM_FIRST_AID_ROOM_2() + " " + directorysPath[1].toString() + "\\БИП-фарм-помощь-" + directorysPath[1].getFileName() + "-к2.mp4";

        filesPath[10] = config.getCAM_MEDICINE_DISPENSING_ROOM_1() + " " + directorysPath[2].toString() + "\\БИП-фарм-отпуск-" + directorysPath[2].getFileName() + "-к1.mp4";
        filesPath[11] = config.getCAM_MEDICINE_DISPENSING_ROOM_2() + " " + directorysPath[2].toString() + "\\БИП-фарм-отпуск-" + directorysPath[2].getFileName() + "-к2.mp4";

        //третий круг
        filesPath[12] = config.getCAM_FIRST_AID_ROOM_1() + " " + directorysPath[0].toString() + "\\БИП-фарм-помощь-" + directorysPath[0].getFileName() + "-к1.mp4";
        filesPath[13] = config.getCAM_FIRST_AID_ROOM_2() + " " + directorysPath[0].toString() + "\\БИП-фарм-помощь-" + directorysPath[0].getFileName() + "-к2.mp4";

        filesPath[14] = config.getCAM_MEDICINE_DISPENSING_ROOM_1() + " " + directorysPath[1].toString() + "\\БИП-фарм-отпуск-" + directorysPath[1].getFileName() + "-к1.mp4";
        filesPath[15] = config.getCAM_MEDICINE_DISPENSING_ROOM_2() + " " + directorysPath[1].toString() + "\\БИП-фарм-отпуск-" + directorysPath[1].getFileName() + "-к2.mp4";

        filesPath[16] = config.getCAM_MEDICINE_MANUFACTURING_ROOM_1() + " " + directorysPath[2].toString() + "\\БИП-фарм-изготовление-" + directorysPath[2].getFileName() + "-к1.mp4";
        filesPath[17] = config.getCAM_MEDICINE_MANUFACTURING_ROOM_2() + " " + directorysPath[2].toString() + "\\БИП-фарм-изготовление-" + directorysPath[2].getFileName() + "-к2.mp4";

        return filesPath;
    }

    @FXML
    void onStart(ActionEvent event) throws IOException {

        buttonStop.setDisable(false);
        /* buttonStart.setDisable(true);*/
        int[] timeMin = {30}; //Чтобы внутри события был доступен, делаем в виде массива.
        int[] timeSec = {0};
        int[] count = {0};
        Path newPath = getNewPath(Path.of(config.getDIRECTORY()));
        try {
            Files.createDirectories(newPath);
        } catch (RuntimeException | IOException e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR, "Каталог по адресу " + newPath.getParent() + " не найден.\nПроверьте файл конфигураций!");
            errorAlert.showAndWait();
        }
        Path[] subdirectoriesPath = greatSubdirectories(newPath);
        String[] filesPath = greatFilesPath(subdirectoriesPath);

        try {
            for (int i = 0; i < processes.length; i++) {
                processes[i] = new ProcessBuilder().command("cmd", "/C", filesPath[i]).start();
                Thread.sleep(1000);
                System.out.println(filesPath[i]);
            }


        } catch (Exception e) {
            System.out.println(e.toString());;
        }

        //Работает
        /*
        timer.setText("30:00");

        timeline = new Timeline(
                new KeyFrame(
                        Duration.millis(1000 ), //каждую секунду
                        ae -> {

                            switch ( count[0]){
                                case 0:
                                    count[0]++;
                                    playStart("src/mp3/1.mp3");
                                    break;
                                case 510:
                                    count[0]++;
                                    playStart("src/mp3/2.mp3");
                                    break;
                                case 570:
                                    count[0]++;
                                    playStart("src/mp3/3.mp3");
                                    break;
                                case 630:
                                    count[0]++;
                                    playStart("src/mp3/1.mp3");
                                    break;
                                case 1110:
                                    count[0]++;
                                    playStart("src/mp3/2.mp3");
                                    break;
                                case 1170:
                                    count[0]++;
                                    playStart("src/mp3/3.mp3");
                                    break;
                                case 1230:
                                    count[0]++;
                                    playStart("src/mp3/1.mp3");
                                    break;
                                case 1740:
                                    count[0]++;
                                    playStart("src/mp3/2.mp3");
                                    break;
                                case 1800:
                                    count[0]++;
                                    playStart("src/mp3/3.mp3");
                                    break;
                            }
                            System.out.println(count[0]);
                            count[0]++;
                            timeSec[0]--;
                            if (timeSec[0]<0){
                                timeMin[0]--;
                                timeSec[0]=59;
                            }
                            timer.setText(timeMin[0]+":"+timeSec[0]);
                        }
                )
        );

        timeline.setCycleCount(30*60); //Ограничим число повторений
        timeline.play(); //Запускаем*/
    }


}

