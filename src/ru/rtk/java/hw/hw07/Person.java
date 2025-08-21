package ru.rtk.java.hw.hw07;

import java.util.HashMap;
import java.util.Map;

public class Person {

    HashMap<String, Integer> persons = new HashMap<>();  // покуматели и из суммы
    HashMap<String, String>  bagGoods  = new HashMap<>();  // покупки покупателя

    /**
     * Добавление строки покупателей 
     * информация о каждом покупателе, , разделитель ";"
     * данные покупателя, разделитель "="
     * @param strBuyers (String) строка покупателей
     */    
    public void addStrBuyer(String strBuyers) {
        Boolean error;  // нет ошибок 
        String errorMsg;  // информация об ошибке
        String[] aStrPos = strBuyers.split(";"); // разделим строку на покупателей, разделитель ";"
        for (String str : aStrPos) {
            // разделим строку по данным покупателя, разделитель "="
            // имя = сумма которую имеет покупатель
            String[] aPos = str.split("="); 
            error = false;  // нет ошибок 
            errorMsg = "";  // информация об ошибке
            if (aPos.length == 2){
                // this.addData(aPos[0], aPos[1]);
                // имя покупателя
                String name = aPos[0].trim();   
                if (name.length() == 0 ) { // имя пустое
                    error = true;
                    errorMsg += "Имя не может быть пустым, ";
                }
                else if (name.length() < 3 ) {  // имя короче 3 символов
                    error = true;
                    errorMsg += "Имя не может быть короче 3 символов, ";
                }
                // сумма которую имеет покупатель
                int cost = 0;
                try {  
                    cost = Integer.parseInt(aPos[1].trim());
                    if (cost< 0 ) {
                        error = true;
                        errorMsg += "сумма не может быть отрицательной";
                    }
                } catch (NumberFormatException e) {  
                    error = true;
                    errorMsg += "Введена неправильная сумма ";
                }  
                if (error) {
                    // если были ошибки
                    System.out.println("Error: "+ name+" "+ cost +" "+ errorMsg);  
                } else {
                    this.setPersons(name, cost);   // добавим покупателя
                    System.out.println("Покупатель:" + name + " с суммой " + cost); 
                }                
            } else {
                    System.out.println("Error: "+ str +", неправильный формат данных");  
            }
        }   
    }
    /**
     * Покупка
     * Проверяет может ли покупатель совершить покупку
     * Если средств достаточно списывает сумму товара из кошелька покупателя и 
     * сохраняет покупку покупателя в массив bagGoods в формате имя покупателя имя продукта
     * @param namePerson (String) имя покупателя
     * @param nameFood   (String) название товара
     * @param priceFood  (int)    цена товара
     */
    public void buyPersons(String namePerson, String nameFood, int priceFood) {
        String point; 
        String bag;
        int sumPerson = this.getPersonsSum(namePerson);
        if (sumPerson< priceFood) {
            System.out.println(namePerson + " не может позволить себе " + nameFood +" по цене:" + priceFood + " руб. в кошельке:" + sumPerson + " руб." );
        } else {
            this.persons.put(namePerson, sumPerson - priceFood);     // спишим сумму из кошелька
            bag = this.getBagGoods(namePerson).trim();
            point = (bag.length() >0 )  ? ", " : "";
            if  ("Ничего не куплено".equals(bag)) {
                // первая покупка
                this.bagGoods.put(namePerson, nameFood);
            } else {
                // следующие покупки, расставляем запятые
                this.bagGoods.put(namePerson, bag + point + nameFood);
            }
            System.out.println(namePerson + " купил(а) " + nameFood +" по цене:" + priceFood + " руб.");
        }
    }

    /*  */
    /**
     * Показать все купленные товары всех покупателей
     */
    public void itogoAllBag() {  
        for (Map.Entry<String, String> entry : bagGoods.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }    
    /**
     * есть ли такой покупатель возвращает true
     * @param name
     * @return
     */
    public boolean isPersons(String name) {
        return this.persons.containsKey(name);
    }
    /**
     * возвращает сумму у покупателя
     * @param name
     * @return
     */
    public int getPersonsSum(String name) {
        return this.persons.get(name);
    }

    /**
     * возвращает список покупок в пакете
     * @param namePerson
     * @return
     */
    public String getBagGoods(String namePerson) {
        return this.bagGoods.get(namePerson);
    }
    /**
     * устанавливает данные покупателя
     * @param name
     * @param sum
     */
    public void setPersons(String name, int sum) {
        this.persons.put(name, sum);     // данные покупателя 
        this.bagGoods.put(name, "Ничего не куплено"); // покупки покупателя
    }
    /**
     * показать всех покупателей
     */
    public void printAllPersons(){
        System.out.println(this.persons);
        System.out.println(this.bagGoods);
    }

}
