package de.profschmergmann;

import de.profschmergmann.day1.Day1;
import de.profschmergmann.day2.Day2;

public class Main {

    public static Day[] days = {new Day1(), new Day2()};

    public static void main(String[] args) {
        for (Day day : days) {
            printResults(day);
        }
    }

    public static void printResults(Day day) {
        System.out.println("Result of day " + day.number() + ":");
        System.out.println(Utilities.PART_ONE + day.resultPartOne());
        System.out.println(Utilities.PART_TWO + day.resultPartTwo());
    }

}
