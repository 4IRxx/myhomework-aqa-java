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
        StringBuilder info = new StringBuilder();
        info.append("ФИО: ").append(fullName)
                .append("\nДолжность: ").append(position)
                .append("\nEmail: ").append(email)
                .append("\nТелефон: ").append(phone)
                .append("\nЗарплата: ").append(salary)
                .append("\nВозраст: ").append(age)
                .append("\n");

        System.out.println(info.toString());
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
