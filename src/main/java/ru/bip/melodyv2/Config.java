package ru.bip.melodyv2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private String CAM_MEDICINE_MANUFACTURING_ROOM_1; //ПОМЕЩЕНИЕ ДЛЯ ПРОИЗВОДСТВА МЕДИЦИНСКИХ ПРЕПАРАТОВ
    private String CAM_MEDICINE_MANUFACTURING_ROOM_2;
    private String CAM_FIRST_AID_ROOM_1;               //ПОМЕЩЕНИЕ ДЛЯ ОКАЗАНИЯ ПЕРВОЙ МЕДИЦИНСКОЙ ПОМОЩИ
    private String CAM_FIRST_AID_ROOM_2;
    private String CAM_MEDICINE_DISPENSING_ROOM_1;      //ПОМЕЩЕНИЕ ДЛЯ ВЫДАЧИ МЕДИЦИНСКИХ ПРЕПАРАТОВ
    private String CAM_MEDICINE_DISPENSING_ROOM_2;
    private String DIRECTORY;

    public Config() {
        Properties properties = new Properties();
        /*TO DO перед компиляцией заменить адрес файла*/
        try (FileInputStream fileConf = new FileInputStream(new File("H:\\Мой диск\\java\\_akkreditacia\\melody_v2\\src\\main\\resources\\properties.ini"))){
            properties.load(fileConf);
            CAM_MEDICINE_MANUFACTURING_ROOM_1 = properties.getProperty("CAM_MEDICINE_MANUFACTURING_ROOM_1");
            CAM_MEDICINE_MANUFACTURING_ROOM_2= properties.getProperty("CAM_MEDICINE_MANUFACTURING_ROOM_2");
            CAM_FIRST_AID_ROOM_1= properties.getProperty("CAM_FIRST_AID_ROOM_1");
            CAM_FIRST_AID_ROOM_2= properties.getProperty("CAM_FIRST_AID_ROOM_2");
            CAM_MEDICINE_DISPENSING_ROOM_1= properties.getProperty("CAM_MEDICINE_DISPENSING_ROOM_1");
            CAM_MEDICINE_DISPENSING_ROOM_2= properties.getProperty("CAM_MEDICINE_DISPENSING_ROOM_2");
            DIRECTORY = properties.getProperty("DIRECTORY");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getCAM_MEDICINE_MANUFACTURING_ROOM_1() {
        return CAM_MEDICINE_MANUFACTURING_ROOM_1;
    }

    public String getCAM_MEDICINE_MANUFACTURING_ROOM_2() {
        return CAM_MEDICINE_MANUFACTURING_ROOM_2;
    }

    public String getCAM_FIRST_AID_ROOM_1() {
        return CAM_FIRST_AID_ROOM_1;
    }

    public String getCAM_FIRST_AID_ROOM_2() {
        return CAM_FIRST_AID_ROOM_2;
    }

    public String getCAM_MEDICINE_DISPENSING_ROOM_1() {
        return CAM_MEDICINE_DISPENSING_ROOM_1;
    }

    public String getCAM_MEDICINE_DISPENSING_ROOM_2() {
        return CAM_MEDICINE_DISPENSING_ROOM_2;
    }

    public String getDIRECTORY() {
        return DIRECTORY;
    }
}
