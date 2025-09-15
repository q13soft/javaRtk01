package homework11.src.model;

public class Car {
    private String number;
    private String model;
    private String color;
    private Integer mileage;
    private Integer cost;

    public Car() {
    }
    /**
     * 
     * @param number
     * @param model
     * @param color
     * @param mileage
     * @param cost
     */
    public Car(String number, String model, String color, String mileage, String cost) {
        this.number = number;
        this.model = model;
        this.color = color;
        this.mileage = Integer.valueOf(mileage);
        this.cost = Integer.valueOf(cost);
    }
        public Car(String number, String model, String color, Integer mileage, Integer cost) {
        this.number = number;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "{" +
            " number='" + getNumber() + "'" +
            ", model='" + getModel() + "'" +
            ", color='" + getColor() + "'" +
            ", mileage='" + getMileage() + "'" +
            ", cost='" + getCost() + "'" +
            "}";
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getMileage() {
        return this.mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getCost() {
        return this.cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }


}
