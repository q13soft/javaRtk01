package ru.rtk.java.hw.hw07;

public class Product {

    protected String name;  // название
    protected int    cost;  // цена

    /**
     * конструктор 
     * @param name - (String) название товара
     * @param cost - (int) цена товара
     */
    public Product(String name, int cost) {
        this.setCost(cost);
        this.setName(name);
    }

    /**
     * возвращает имя товара
     * @return - (String) название товара
     */
    public String getName() {
        return this.name;
    }
    /**
     * возвращает цену товара
     * @return - (int) цена товара
     */
    public int getCost() {
        return this.cost;
    }
    /**
     * устанавливает цену товара
     * @param cost - (int) цена товара
     */
    public void setCost(int cost) {
        this.cost = cost;
    }
    /**
     * устанавливает название товара
     * @param name - (String) название товара
     */
    public void setName(String name) {
        this.name = name;
    }


}