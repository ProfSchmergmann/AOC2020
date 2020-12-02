package de.profschmergmann;

import java.util.ArrayList;

public abstract class Day {

    protected final ArrayList<String> example;
    protected final ArrayList<String> input;

    public Day(int numberOfDay) {
        this.example = Utilities.readFromFile(numberOfDay, true);
        this.input = Utilities.readFromFile(numberOfDay, false);
    }

    public abstract String resultPartOne();

    public abstract String resultPartTwo();

    public abstract int number();

}
