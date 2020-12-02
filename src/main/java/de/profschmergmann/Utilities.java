package de.profschmergmann;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Utilities {

    public static final String PART_ONE = "Result of part one: ";
    public static final String PART_TWO = "Result of part two: ";

    /**
     * Reads Strings from a file and puts them linewise into an ArrayList.
     *
     * @param numberOfDay the specific day
     * @param example     if the returned file shall be the example file
     * @return an ArrayList of the lines or an empty one if reading did not work
     */
    public static ArrayList<String> readFromFile(int numberOfDay, boolean example) {
        ArrayList<String> res = new ArrayList<>();
        try {
            String filename;
            if (example) {
                filename = "src/main/java/de/profschmergmann/day" + numberOfDay + "/example.txt";
            } else {
                filename = "src/main/java/de/profschmergmann/day" + numberOfDay + "/input.txt";
            }
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            reader.lines().forEachOrdered(res::add);
            reader.close();
        } catch (IOException e) {
            Logger.getGlobal().info("Reading did not work.");
        }
        return res;
    }

}