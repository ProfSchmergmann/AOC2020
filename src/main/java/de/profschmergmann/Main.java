package de.profschmergmann;

import de.profschmergmann.day1.Day1;
import de.profschmergmann.day2.Day2;
import de.profschmergmann.day3.Day3;
import de.profschmergmann.day4.Day4;

public class Main {

    public static Day[] days = {new Day1(), new Day2(), new Day3(), new Day4()};

    public static void main(String[] args) {
//        for (Day day : days) {
//            printResults(day);
//        }
        printResults(new Day4());
    }

    public static void printResults(Day day) {
        System.out.println("Result of day " + day.number() + ":");
        System.out.println(Utilities.PART_ONE + day.resultPartOne());
        System.out.println(Utilities.PART_TWO + day.resultPartTwo());
    }

}
