package com.myaqa;

import java.util.ArrayList;

public class Park {
    public static class Attraction {
        private String name;
        private String time;
        private double cost;

        public Attraction(String name, String time, double cost) {
            this.name = name;
            this.time = time;
            this.cost = cost;
        }

        public String getInfo() {
            return "Аттракцион: " + name + "\nВремя работы: " + time + "\nСтоимость: " + cost + "\n";
        }
    }

    private ArrayList<Attraction> attractions;

    public Park() {
        attractions = new ArrayList<>();
    }

    public void addAttraction(String name, String time, double cost) {
        Attraction attraction = new Attraction(name, time, cost);
        attractions.add(attraction);
    }

    public void displayAttractions() {
        for (Attraction attraction : attractions) {
            System.out.println(attraction.getInfo());
        }
    }
}