package com.myaqa;

import static com.myaqa.Employee.createArray;

public class Main {
    public static void main(String[] args) {
        Employee info = new Employee("Симончук Антон Александрович", "Тестировщик", "simanchuk1997@gmail.com", "+123456789", 1000000, 26);
        info.showInfo();

        Employee[] employees = createArray();
        for (Employee employee : employees) {
            employee.showInfo();
        }

        Park park = new Park();
        park.addAttraction("Колесо обозрения", "10:00 - 20:00", 69.0);
        park.addAttraction("Весёлые горки", "12:00 - 18:00", 13.9);
        park.addAttraction("Карусель-карусель", "09:00 - 21:00", 8.2);
        park.displayAttractions();
    }
}