package ru.rtk.java.hw.hw03;

import java.util.Scanner;

/**
 * Домашняя работа 3. Задача 1. Составить программу вывода на экран в одну строку сообщения «Привет, имя_пользователя», 
 * где «имя_пользователя» - это введёное в консоль имя, для выполнения данного задания нужно 
 * использовать класс Scanner.
 *
 * Информация по работе в IDE VScode
 * ctrl+space сонтекстное меню создание класса, ctor - конструктор
 * ctrl+ЛКМ по методу или объекту или свойству переход на использоваение
 * alt+ins  создать getter & setter 
*/
public class Hw0301 {

    private String name;      // your name
    private String codePage = "cp866";  // set code page, default 866
    
    /* constructors */
    public Hw0301() {
    }
  
    public Hw0301(String codePage) {
        this.codePage = codePage;
    }
    
    public static void main(String[] args) {
        Hw0301 obj = new Hw0301();
        obj.workingProcess();
    }

    /* start process */
    public void workingProcess(){
        this.inputName();
        this.printInfo();
    }
    /* input name */
    public void inputName() {
        System.out.print("Введите имя: ");
        Scanner sc = new Scanner(System.in,this.codePage);
        this.name = sc.nextLine();
        sc.close();

    }
    /* print info */
    public void printInfo() {
        if ("".equals(this.name)) {   // don't have name
            this.name = "незнакомец";
        }
        System.out.println("Привет, "+this.name);
    } 
   
}


