package ru.rtk.java.hw.hw04;

public class App {
   public static void main(String[] args) {
        Tv tv01 = new Tv("Samsung", "ND201");
        Tv tv02 = new Tv("LG", "GR-V");

        tv01.nextProgram(); // TV 1 следующий канал, TV выключен
        tv01.pressPower();  // TV 1 включим
        tv02.pressPower();  // TV 2 включим
        tv01.nextProgram(); // TV 1 следующий канал
        tv01.nextProgram(); // TV 1 следующий канал
        tv02.inputProgram(); // TV 2 выберем канал

        tv01.pressPower();  // TV 1 выключим
        tv02.prevProgram(); // TV 2 предыдущий канал
        tv01.nextProgram(); // TV 1 следующий канал, при выключенном ТВ
        tv01.nextProgram(); // TV 1 следующий канал, при выключенном ТВ
        tv02.prevProgram(); // TV 2 предыдущий канал


   }
    
}
