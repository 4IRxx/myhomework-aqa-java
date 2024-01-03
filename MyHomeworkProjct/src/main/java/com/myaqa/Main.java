package com.myaqa;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        AppData loadedData = new AppData();
        loadedData.load("MyHomeworkProjct/src/main/resources/example.csv");

        loadedData.data[0][0] = 23;
        loadedData.data[0][1] = 33;
        loadedData.data[0][2] = 56;
        loadedData.data[1][0] = 16;
        loadedData.data[1][1] = 18;
        loadedData.data[1][2] = 97;

        loadedData.save("MyHomeworkProjct/src/main/resources/example.csv");
        loadedData.load("MyHomeworkProjct/src/main/resources/example.csv");

    }
}