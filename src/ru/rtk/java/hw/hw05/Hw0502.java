package ru.rtk.java.hw.hw05;

/*
 * Задана последовательность, состоящая только из символов ‘>’, ‘<’ и ‘-‘. 
 * Требуется найти количество стрел, которые спрятаны в этой последовательности. 
 * Стрелы – это подстроки вида ‘>>-->’ и ‘<--<<’.
 * Входные данные: в первой строке входного потока записана строка, состоящая из символов ‘>’, ‘<’ и ‘-‘ (без пробелов). 
 * Строка может содержать до 106 символов.
 * Выходные данные: в единственную строку выходного потока нужно вывести искомое количество стрелок.
 */

public class Hw0502 { 

    private String str = "";  // введенная строка для обработки
    // private String codePage = "cp866";  // set code page, default 866
    public static void main(String[] args) {
        Hw0502 obj = new Hw0502();
        obj.countArrow2(">>--><><>--<>>>>-->>>><>----<><--<<-->>--><--<<");
        obj.countArrow2("<>>>><>--<>>>>-->>>><><--<<----<><--<<-->>--><--<<<--<<<--<<<--<<<--<<----<--<<<--<<<--<<");
        obj.countArrow2(">-->");
        obj.countArrow2(">>-->");
        obj.countArrow(">>-->>--><--<<<");
        obj.countArrow2(">>-->>--><--<<<");
    }
    /* конструкторы */    
    public Hw0502() {   
    }
    /* посчитаем количество стрелок, при условии, что часть стрелы может быть частью другой стрелы */
    public void countArrow(String str) {   
        int countArrow =0;  // всего стрелок
        int maxChar = str.length(); // количество символов
        this.setStr(str);
        System.out.println("Введена строка: "+ this.str);
        if (maxChar >= 5) {
            for (int i = 0; i < maxChar-4; i++) {
                // System.out.println(i+" ");
                if (this.isArrow(str.substring(i, i+5))) {
                    countArrow++;
                }
            }    
        }
        System.out.println("В строке: "+ this.str + " найдено стрелок: " + countArrow);
    }
    /* посчитаем количество стрелок, при условии что часть стрелы НЕ может быть частью другой стрелы */
    public void countArrow2(String str) {   
        int countArrow =0;  // всего стрелок
        int maxChar = str.length(); // количество символов
        this.setStr(str);
        System.out.println("Введена строка: "+ this.str);
        if (maxChar >= 5) {
            for (int i = 0; i < maxChar-4; i++) {
                // System.out.println(i+" ");
                if (this.isArrow(str.substring(i, i+5))) {
                    countArrow++;
                    i = i+4;
                }
            }    
        }
        System.out.println("В строке: "+ this.str + " найдено стрелок: " + countArrow);
    }

    /* стрелка true или нет false */
    public boolean isArrow(String str2) {   
        // System.out.print(str2);
        if (str2.equals(">>-->") || str2.equals("<--<<")) {
            // System.out.println(" OK");
            return true;
        }
        // System.out.println(" not");
        return false;
    }
    /* введем данные строки */
    public void setStr(String str) {   
        this.str = str;
    }
    



}