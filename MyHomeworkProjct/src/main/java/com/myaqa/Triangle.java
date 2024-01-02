package com.myaqa;

public class Triangle implements Shape, Colorable {
    private double side1;
    private double side2;
    private double side3;
    private Color color;

    public Triangle(double side1, double side2, double side3, String fillColor, String borderColor) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.color = new Color(fillColor, borderColor);
    }

    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public double calculateArea() {
        double s = calculatePerimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public void displayInfo() {
        System.out.println("Треугольник:");
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
