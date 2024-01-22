package com.myaqa;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        CollectionManagement myCollection = new CollectionManagement();
        ArrayList<Integer> randomPrimes = myCollection.RandomPrimes(2, 100, 10);
        System.out.println("Количество чётных чисел из набора случайных чисел: " + myCollection.numberOfEven(randomPrimes));

        ArrayList<String> myList = new ArrayList<>(List.of("Highload", "High", "Load", "Highload"));
        System.out.println("Количество повторений объекта «High» в коллекции: " + myCollection.numberOfRepetitions(myList, "High"));
        System.out.println("Первый элемент в коллекции: " + myCollection.firstInCollection(myList));
        System.out.println("Последний элемент в коллекции: " + myCollection.lastInCollection(myList));

        ArrayList<String> myFList = new ArrayList<>(List.of("f10", "f15", "f2", "f4", "f4"));
        myCollection.ascendingSort(myFList);
        System.out.println("Отсортированная коллекция: " + myFList);

        Students students = new Students();
        System.out.println("Средний возраст студентов мужского пола: " + students.getAverageAgeOfMaleStudents());
        System.out.println("Кому из студентов грозит получение повестки в этом году: ");
        students.printDraftEligibleStudents();

        Scanner scan = new Scanner(System.in);
        LoginStorage loginList = new LoginStorage();
        UI userInterface = new UI(loginList, scan);

        userInterface.start();
    }
}