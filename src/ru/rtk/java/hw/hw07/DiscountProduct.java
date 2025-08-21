package ru.rtk.java.hw.hw07;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DiscountProduct extends Product {

    private int    percent;     // процент скидки
    private LocalDate dateEnd;  // дата окончания скидки

    /**
     * конструктор
     * @param name     - (String) название товара
     * @param cost     - (int) цена товара
     * @param percent  - (int) процент скидки, по умолчанию 0
     * @param dateEnd  - (String) дата в формате "dd.MM.yyyy" последнего дня скидки, если нет даты то null
     */
    public DiscountProduct(String name, int cost, int percent, String dateEnd) {
        super(name, cost);
        this.percent = percent;
        if (dateEnd != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate date = null;
            try {  
                date = LocalDate.parse(dateEnd, formatter);
            } catch (DateTimeParseException e) {  
                System.out.println("Error: неправильный фоормат даты ограничения введения скидки, должен быть дд.мм.гггг");
            }  
            this.dateEnd = date;
        } else {
            this.dateEnd = null;
        }
       // System.out.println(this.dateEnd);
       // System.out.println(LocalDate.now());
    }

    /**
     * возвращает цену товара c учетом скидки
     *  @return - (int) цена товара c учетом скидки
     */
    public int getCost() {
        LocalDate dateNow = LocalDate.now(); // Текущая дата
        /* находится ли заданная дата после текущей */
        if (this.percent > 0 && dateEnd != null) {
            if (this.dateEnd.isBefore(dateNow)) {
                return super.getCost();
            }  else {
                return (int) (super.getCost() - (this.percent* super.getCost() /100));  
            } 
        }
        return super.getCost();
    }
}
