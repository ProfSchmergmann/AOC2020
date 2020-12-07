package de.profschmergmann;

import de.profschmergmann.day1.Day1;
import de.profschmergmann.day2.Day2;
import de.profschmergmann.day3.Day3;
import de.profschmergmann.day4.Day4;
import de.profschmergmann.day5.Day5;
import de.profschmergmann.day6.Day6;

public class Main {

    public static void main(String[] args) {
        printResults(new Day6());
    }

    public static void printResults(Day day) {
        System.out.println("Result of day " + day.number() + ":");
        System.out.println(Utilities.PART_ONE + day.resultPartOne());
        System.out.println(Utilities.PART_TWO + day.resultPartTwo());
    }

    private static Day[] createDayArray() {
        return new Day[] {new Day1(), new Day2(), new Day3(), new Day4(),
            new Day5(), new Day6()};
    }

}
