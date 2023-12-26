package com.myaqa;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int age;

    public Employee(String fullName, String position, String email, String phone, double salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void showInfo() {
        System.out.println("ФИО: " + fullName);
        System.out.println("Должность: " + position);
        System.out.println("Email: " + email);
        System.out.println("Телефон: " + phone);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age);
        System.out.println();
    }


    public static Employee[] createArray() {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Симончук Антон", "Тестировщик", "simanchuk1997@gmail.com", "+123456789", 1000000, 26);
        employees[1] = new Employee("Крис Эванс", "Тестировщик", "evans@example.com", "+987654321", 45000, 28);
        employees[2] = new Employee("Юрий Быков", "Аналитик", "bykov@example.com", "+111223344", 55000, 35);
        employees[3] = new Employee("Ювал Ноах Харари", "Дизайнер", "harari@example.com", "+555666777", 60000, 25);
        employees[4] = new Employee("Луций Анней Сенека", "Менеджер", "seneka@example.com", "+999000111", 48000, 32);

        return employees;
    }

}
