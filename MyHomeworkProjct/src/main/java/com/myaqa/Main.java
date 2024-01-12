package com.myaqa;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] wordsArray = {"sun", "earth", "saturn", "jupiter", "sun", "saturn", "uranus", "neptune", "mars", "mercury", "mars"};

        List<String> wordsList = Arrays.asList(wordsArray);
        Set<String> uniqueWords = new HashSet<>(wordsList);

        System.out.println("Уникальные слова: " + uniqueWords);

        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : wordsList) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        System.out.println("Количество повторений каждого слова:");
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        Contact simanchuk = new Contact("Simanchuk", 3232013);
        Contact saka = new Contact("Saka", 4232010);
        Contact rice = new Contact("Rice", 9232011);
        Contact saliba = new Contact("Saliba", 2232209);

        PhoneDirectory catalog = new PhoneDirectory();
        catalog.add(simanchuk);
        catalog.add(saka);
        catalog.add(rice);
        catalog.add(saliba);

        catalog.get("Saka");
    }
}