package de.profschmergmann.day1;

import de.profschmergmann.Utilities;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Read the file
        ArrayList<String> numbers = Utilities.readFromFile("src/main/java/de/profschmergmann/day1/input.txt");
        // Parse the strings to integers
        ArrayList<Integer> ints = new ArrayList<>();
        numbers.forEach(s -> ints.add(Integer.parseInt(s)));
        // Part one
        for (int i = 0; i < ints.size(); i++) {
            for (int j = i + 1; j < ints.size(); j++) {
                if (ints.get(i) + ints.get(j) == 2020) {
                    System.out.println("Result of part one: " + ints.get(i) + " * " + ints.get(j) + " = "
                            + ints.get(i) * ints.get(j));
                }
            }
        }
        // Part two
        for (int i = 0; i < ints.size(); i++) {
            for (int j = i+1; j < ints.size(); j++) {
                for (int k = j+1; k < ints.size(); k++) {
                    if (ints.get(i) + ints.get(j) + ints.get(k) == 2020) {
                        System.out.println("Result of part two: " + ints.get(i) + " * "
                                + ints.get(j) + " * " + ints.get(k) + " = "
                                + ints.get(i) * ints.get(j) * ints.get(k));
                    }
                }
            }
        }
    }
}