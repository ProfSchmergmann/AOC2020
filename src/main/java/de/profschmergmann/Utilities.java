package de.profschmergmann;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Utilities {

    /**
     * Reads Strings from a file and puts them linewise into an ArrayList.
     *
     * @param filename the path to the file from src root
     * @return an ArrayList of the lines or an empty one if reading did not work
     */
    public static ArrayList<String> readFromFile(String filename) {
        ArrayList<String> res = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            reader.lines().forEachOrdered(res::add);
            reader.close();
        } catch (IOException e) {
            Logger.getGlobal().info("Reading did not work.");
        }
        return res;
    }

}