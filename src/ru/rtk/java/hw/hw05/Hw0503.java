package ru.rtk.java.hw.hw05;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Задача 3*. Задана строка, состоящая из букв английского алфавита, 
 * разделенных одним пробелом. Необходимо каждую последовательность 
 * символов упорядочить по возрастанию и вывести слова в нижнем регистре.
 * Входные данные: в единственной строке последовательность символов представляющее два слова.
 * Выходные данные: упорядоченные по возрастанию буквы в нижнем регистре.
 */

public class Hw0503 {


    private String codePage = "cp866";  // set code page, default 866
    public static void main(String[] args) {
        Hw0503 obj = new Hw0503();
        obj.inputWords();
    }
    /* конструкторы */    
    public Hw0503() {   
    }    
    /* ввод двух слов разделенных пробелом и из обработка*/
    public void inputWords() {
        System.out.println("Введите последовательность английских символов разделенных пробелом:");
        Scanner sc = new Scanner(System.in, this.codePage);
        String line= sc.nextLine();
        sc.close();            
        System.out.println("Вы ввели: "+line);
        String[] words = line.toLowerCase().split(" ");
        if (words.length != 2 ) {
            System.out.println("Ошибка, требуется ввести ровно две последовательности");
        } else {
            for (int i= 0; i< words.length; i++ ) {
                System.out.println((i+1)+" последовательность: "+this.sortWord(words[i]));
            }
        }
    }
    /* получает строку и сорртирует ее символы, 
     * возвращает сортированную строку
    */
    public String sortWord(String str) {
        char[] chars = str.toCharArray();
		Arrays.sort(chars);
		str = new String(chars);
        return str;
    }
        


}
