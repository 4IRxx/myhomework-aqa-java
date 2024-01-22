package com.myaqa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class CollectionManagement {

    public CollectionManagement() {
    }

    public ArrayList<Integer> RandomPrimes(int min, int max, int count) {
        ArrayList<Integer> primes = new ArrayList<>();
        Random random = new Random();

        while (primes.size() < count) {
            int candidate = random.nextInt((max - min) + 1) + min;
            primes.add(candidate);
        }
        return primes;
    }

    public int numberOfEven(ArrayList<Integer> numbers) {
        int counter = 0;
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                counter++;
            }
        }
        return counter;
    }

    public int numberOfRepetitions(ArrayList<String> list, String word) {
        int counter = 0;
        for (String value : list) {
            if (word.equals(value)) {
                counter++;
            }
        }
        return counter;
    }

    public String firstInCollection(ArrayList<String> list) {
        if (list.isEmpty()) {
            return "0";
        }
        return list.get(0);
    }

    public String lastInCollection(ArrayList<String> list) {
        if (list.isEmpty()) {
            return "0";
        }
        return list.get(list.size() - 1);
    }

    public void ascendingSort(ArrayList<String> list) {
        Collections.sort(list, new CustomComparator());
    }

    private static class CustomComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            int num1 = Integer.parseInt(s1.substring(1));
            int num2 = Integer.parseInt(s2.substring(1));
            return Integer.compare(num1, num2);
        }
    }
}