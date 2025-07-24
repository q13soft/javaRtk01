package ru.rtk.java.hw.hw04;

import java.util.Scanner;

public class Tv {

    private String name;     // производитель
    private String model;    // модель
    private boolean status;  // true - вкл, false - выкл
    private String ledStatus;  // индикатор статуса  
    private int program;     // включенная активная программа 
    private String codePage = "cp866";  // set code page, default 866

/* 
 * 
*/
    public Tv(String name, String model) {
        this.setName(name);
        this.setModel(model);
        this.setStatus(false);
        this.setLedStatus("red");
        this.program = 1;
        this.infoAboutTv();
    }

    // включение/выключение телевизора
    public void pressPower() {
        if (this.isStatus()) {
            this.setStatus(false); // если включен, выключить
            this.setLedStatus("red"); // индикатор красный
        } else {
            this.setStatus(true); // если выключен включить 
            this.setLedStatus("green"); // индикатор зеленый
        }
        this.infoAboutTv();
    }
    // информация о телевизоре
    public void infoAboutTv() {
        this.aboutTv();
        System.out.println(this.getStatusString() + " индикатор " + this.getLedStatus());
        this.infoProgram();
        this.separator();
    }
    public void separator() {
        System.out.println("---");
    }
    

    public void aboutTv() {
        System.out.println( "Телевизор " + this.getName() + " модель " + this.getModel());
    }


    // выбрать канал
    public void setProgram(int program) {
        // если телевизор включен
        if (this.isStatus()){
            this.aboutTv();
            if (program < 1 || program > 200) {
                System.out.println("Нет такого канала, переключаем на 1");
                this.program = 1; 
            } else {
                this.program = program;
                System.out.println("Выбран канала " + this.program);
            }
            this.separator();            
        }    
    }

    // выбрать канал
    public void inputProgram() {
        // если телевизор включен
        if (this.isStatus()){
            this.aboutTv();
            System.out.print("Ожидание...Выберите программу ...>");
            Scanner sc = new Scanner(System.in,this.codePage);
            this.setProgram(sc.nextInt());
            sc.close();
        }
    }
    // переключить на следующий канал
    public void nextProgram() {
        if (this.program > 200) {
            this.setProgram(1); 
        } else {
            if (this.isStatus()){
                System.out.print("Следующий канал.");
            }
            this.setProgram(this.getProgram()+1);
        }
    }
    // переключить на предыдущий канал
    public void prevProgram() {
        if (this.program < 1) {
            this.setProgram(200); 
        } else {
            if (this.isStatus()){
                System.out.print("Предыдующий канал.");
            }
            this.setProgram(this.getProgram()-1);
        }
    }

    public int getProgram() {
        return this.program;
    }

    public void infoProgram() {
        if (this.getStatus()) {
            System.out.println("Выбрана программа " + this.program);
        }
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    // узнать статус телевизора включен или нет
    public boolean isStatus() {
        return this.status;
    }
    // возвращает статус телевизора 
    public boolean getStatus() {
        return this.status;
    }
    // возвращает статус телевизора, текст
    public String getStatusString() {
        if (this.getStatus()) {
            return "Телевизор включен ON";
        } else {
            return "Телевизор выключен OFF";
        }
    }

    /* изменить статус телевизора */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /* изменить статус индикатора */
    public void setLedStatus(String ledStatus) {
        this.ledStatus = ledStatus;
    }
        
    // возвращает статус индикатора
    public String getLedStatus() {
        return this.ledStatus;
    }    

    
}
