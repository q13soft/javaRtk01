package ru.rtk.java.hw.hw05;

import java.util.Scanner;

/*
 * Задача 1. Для введенной с клавиатуры буквы английского алфавита нужно вывести слева 
 * стоящую букву на стандартной клавиатуре. При этом клавиатура замкнута, т.е. справа 
 * от буквы «p» стоит буква «a», а слева от 'а' буква 'р', также соседними считаются
 * буквы «l» и буква «z», а буква «m» с буквой «q».
 * Входные данные: строка входного потока содержит один символ — маленькую букву 
 * английского алфавита.
 * Выходные данные: следует вывести букву стоящую слева от заданной буквы, с учетом замкнутости клавиатуры.
 */

public class Hw0501 { 

    private char sign; 
    private String str = "qwertyuiopasdfghjklzxcvbnm"; 
    private int maxChar;
    private String codePage = "cp866";  // set code page, default 866
    public static void main(String[] args) {
        Hw0501 obj = new Hw0501();
        obj.inputSign();
    }
    public Hw0501() {   
        this.maxChar = this.str.length();
    }
    public void inputSign() {
        int indexChar; // индех выбранного символа 
        System.out.print("Введите английский символ ["+ this.str +"]: " );
        Scanner sc = new Scanner(System.in, this.codePage);
        String line = sc.nextLine();
        sc.close();

        if(line.isEmpty()) {
            System.out.println("Вы не ввели символ");
        } else {
            if (line.length() > 1) {
                System.out.println("Вы ввели больше одного символа, поэтому выбираем первый");
            }
            this.sign = line.charAt(0);
            indexChar = this.getIndexSign();  // возврвщвет порядковый номер введенного символа
            if (indexChar >= 0 && indexChar < this.maxChar ) {
                System.out.println("Вы ввели символ: " + this.sign);
                if (indexChar == 0) {
                    System.out.println("Символ слева: " + this.str.charAt(this.maxChar-1));
                } else {
                    System.out.println("Символ слева: " + this.str.charAt(indexChar-1));
                }
            } else {
                System.out.println("Введен неправильный символ: " + this.sign);
                System.out.println("ВЫ должны ввети один из указанных символов: " + this.str);
            }
        }
    }

   /* возвращает позицию введенного символа, 
   если символ не найден, то возвращает число которое привышает количество символов */
   public int getIndexSign() {
      for (int i = 0; i < this.maxChar; i++) {
        if (this.sign == this.str.charAt(i)) {
          return i;  
        }
      }
      return this.maxChar;
   }
}