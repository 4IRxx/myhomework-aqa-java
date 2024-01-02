package com.myaqa;

public class Circle implements Shape, Colorable {
    private double radius;
    private Color color;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.color = new Color(fillColor, borderColor);
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void displayInfo() {
        System.out.println("Круг:");
        System.out.println("Периметр: " + calculatePerimeter());
        System.out.println("Площадь: " + calculateArea());
        System.out.println("Цвет фона: " + color.getFillColor());
        System.out.println("Цвет границы: " + color.getBorderColor());
    }

    @Override
    public String getFillColor() {
        return color.getFillColor();
    }

    @Override
    public String getBorderColor() {
        return color.getBorderColor();
    }
}
