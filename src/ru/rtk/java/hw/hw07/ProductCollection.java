package ru.rtk.java.hw.hw07;

import java.util.HashMap;

public class ProductCollection {

    HashMap<String, DiscountProduct> products = new HashMap<>();  // 

    /**
     * добавляет новый продукт в коллекцию, если нет скидки
     * @param name (String) - название продукта 
     * @param cost (int)    - цена продукта
     */
    public void addProduct(String name, int cost) {
        DiscountProduct prod = new DiscountProduct(name, cost, 0, null);
        this.setCollection(prod);
        System.out.println("Товар:" + name + " с ценой " + cost); 
    }
    /**
     * добавляет новый продукт в коллекцию, если есть скидка у продукта
     * @param name    (String) - название продукта 
     * @param cost    (int)    - цена продукта
     * @param percent (int)    - процент скидки, по умолчанию 0
     * @param dateEnd (String) - дата в формате "dd.MM.yyyy" последнего дня скидки, если нет даты то null
     */
    public void addProductDiscount(String name, int cost, int percent, String dateEnd) {
        DiscountProduct prod = new DiscountProduct(name, cost, percent, dateEnd);
        this.setCollection(prod);
        System.out.println("Товар:" + name + " с ценой " + cost + ", применяется процент скидки " + percent + "% до "+ dateEnd); 
    }

    /**
     * Добавление строки продуктов 
     * информация о каждом продукте, разделена ";"
     * данные продукта, разделитель "="
     * 1 вариант ввода: название продукта = цена продукта
     * 2 вариант ввода: название продукта = цена продукта = процент скидки = дата последнего дня скидки
     * @param strProducts (String) строка продуктов
     */
    public void addStrProducts(String strProducts) {
        Boolean error;    // наличие ошибок 
        String errorMsg;  // информация об ошибке
        String[] aStrPos = strProducts.split(";");
        for (String str : aStrPos) {
            error = false;  // обнуляем нет ошибок 
            errorMsg = "";  // обнуляем информация об ошибке
            String[] aPos = str.split("="); 
            if (aPos.length == 2 || aPos.length == 4){
                // this.addData(aPos[0], aPos[1]);
                // назхвание товара
                String name = aPos[0].trim();   
                if (name.length() == 0 ) { // имя пустое
                    error = true;
                    errorMsg += "Название не может быть пустым, ";
                }
                else if (name.length() < 3 ) {  // имя короче 3 символов
                    error = true;
                    errorMsg += "Название не может быть короче 3 символов, ";
                }
                // цена товара
                int cost = 0;
                try {  
                    cost = Integer.parseInt(aPos[1].trim());
                    if (cost< 0 ) {
                        error = true;
                        errorMsg += "цена не может быть отрицательной";
                    }
                } catch (NumberFormatException e) {  
                    error = true;
                    errorMsg += "Введена неправильная цена товара ";
                }  
                if (error) {
                    // если были ошибки
                    System.out.println("Error: "+ name + cost +" "+ errorMsg);  
                } else {
                    // товары без скидки
                    if (aPos.length == 2){
                        this.addProduct(name, cost);   // добавим товар
                    }                
                    // товары со скидкой
                    if (aPos.length == 4){
                        int discount = 0;  // процент скидки
                        String dateDiscount = aPos[3].trim();   
                        try {  
                            discount = Integer.parseInt(aPos[2].trim());
                            if (cost< 0 ) {
                                discount = 0;
                            }
                        } catch (NumberFormatException e) {  
                            error = true;
                            errorMsg += "Введен неправильный процент скидки ";
                        }  
                        this.addProductDiscount(name, cost, discount, dateDiscount);  // добавим товар со скидкой
                    }
                }
            } 
        }           

    }   


    /**
     * Проверяем по названию есть ли такой товар 
     * @param name (String) название товара
     * @return (boolean) true - если такой товар есть, иначе fasle
     */
    public boolean isProduct(String name) {
        return this.products.containsKey(name);
    }
    /**
     * возвращает цену товара поьназванию
     * @param name (String) название товара
     * @return (int) цена товара c учетом скидки
     */
    public int getCollectionCost(String name) {
        /* обавить обработку даты и процентов */
        // return this.products.get(name).cost;
        DiscountProduct prod = this.products.get(name);
        int i = prod.getCost();  
        return i;
    }

    /**
     * добавляет в коллекцию товар (имя, цена, процент скидки, дата последнего дня скидки) 
     * @param prod (DiscountProduct) объект товар со скидкой
     */
    public void setCollection(DiscountProduct prod) {
        this.products.put(prod.name, prod);
    }
    /**
     * показать все товары с ценами в коллекции
     */
    public void printAllProducts(){
        System.out.println(this.products);
    }


}
