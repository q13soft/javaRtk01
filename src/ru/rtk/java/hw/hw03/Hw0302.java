package ru.rtk.java.hw.hw03;


/*
 * Задача 2*. Вася и Петя играют в игру “Камень, ножницы, бумага”.
 * Каждый из них показывает свою фигуру камень-0, ножницы-1, бумага-2.
 * Программа определяет, кто из них выиграл.
 * Выбор каждого участника формируется случайным образом.
 * 
 */
public class Hw0302 {

    private int  pointValue;
    private String[] arrayName = {"камень","ножницы","бумага"};
    private String nameGamer;

        /*constructor */
    public Hw0302(String nameGamer) {
        this.nameGamer = nameGamer;
        this.throwDice();
    }

    public static void main(String[] args) {
        System.out.println("Игра началась ....");
        Hw0302 vasia = new Hw0302("Вася");
        Hw0302 petr = new Hw0302("Петя");
        vasia.game(petr);
    }    
    /* select fig. */
    public void throwDice() {
        this.pointValue = (int) (Math.random() * 3);
        this.printPoint();
    }
    /* print select */
    public void printPoint() {
        System.out.println(this.nameGamer +" показал фигуру: " +this.pointValue +"." + this.arrayName[pointValue]);
    }
    /* start game */
    public void game(Hw0302 opponent ) {
        int me = this.getPointValue();
        int oppo = opponent.getPointValue();
        if (me != oppo) {
            if ((me == 0  && oppo == 1) 
              || (me == 1  && oppo == 2) 
              || (me == 2  && oppo == 0)){
                System.out.println("Победил "+ this.getNameGamer());
            } else {
                System.out.println("Победил " + opponent.getNameGamer());
            }
        }
        else {
            System.out.println("Ничья");
        }
    }

    /**
     * @return int return the pointValue
     */
    public int getPointValue() {
        return pointValue;
    }

    /**
     * @param pointValue the pointValue to set
     */
    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }

    /**
     * @return String[] return the arrayName
     */
    public String[] getArrayName() {
        return arrayName;
    }

    /**
     * @param arrayName the arrayName to set
     */
    public void setArrayName(String[] arrayName) {
        this.arrayName = arrayName;
    }

    /**
     * @return String return the nameGamer
     */
    public String getNameGamer() {
        return nameGamer;
    }

    /**
     * @param nameGamer the nameGamer to set
     */
    public void setNameGamer(String nameGamer) {
        this.nameGamer = nameGamer;
    }

}

