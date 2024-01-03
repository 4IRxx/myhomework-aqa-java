package com.myaqa;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AppData {
    public String[] header;
    public int[][] data;

    public AppData() {
    }
    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public void save(String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println(String.join(";", header));

            for (int[] row : data) {
                String rowData = Arrays.stream(row)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(";"));
                writer.println(rowData);
            }

            System.out.println("Данные успешно сохранены в файл: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String headerLine = reader.readLine();

            header = Arrays.stream(headerLine.split(";"))
                    .map(value -> value.replaceAll("\"", "").trim())
                    .toArray(String[]::new);

            List<int[]> dataList = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                int[] row = new int[values.length];

                for (int i = 0; i < values.length; i++) {
                    String cleanedValue = values[i].trim();
                    if (!cleanedValue.isEmpty()) {
                        row[i] = Integer.parseInt(cleanedValue);
                    } else {
                        row[i] = 0;
                    }
                }

                dataList.add(row);
            }

            data = dataList.toArray(new int[0][]);

            System.out.println(Arrays.toString(header));
            System.out.print("");
            for (int[] row : data) {
                System.out.println(Arrays.toString(row));
            }

            System.out.println("Данные успешно загружены из файла: " + filePath);
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}

