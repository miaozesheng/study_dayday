package test.test.list_test;

public class Card {
    private String color;

    private String size;

    private Integer power;

    public Card() {
    }

    public Card(String color, String size, Integer power) {
        this.color = color;
        this.size = size;
        this.power = power;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return size+color;
    }
}
