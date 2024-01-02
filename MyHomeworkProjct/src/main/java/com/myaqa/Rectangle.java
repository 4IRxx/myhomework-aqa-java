package com.myaqa;

public class Rectangle implements Shape, Colorable {
    private double width;
    private double height;
    private Color color;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.color = new Color(fillColor, borderColor);
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public void displayInfo() {
        System.out.println("Прямоугольник:");
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
