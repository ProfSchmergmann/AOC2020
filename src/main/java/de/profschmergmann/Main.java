package de.profschmergmann;

import de.profschmergmann.day1.Day1;
import de.profschmergmann.day10.Day10;
import de.profschmergmann.day11.Day11;
import de.profschmergmann.day12.Day12;
import de.profschmergmann.day13.Day13;
import de.profschmergmann.day14.Day14;
import de.profschmergmann.day15.Day15;
import de.profschmergmann.day16.Day16;
import de.profschmergmann.day17.Day17;
import de.profschmergmann.day2.Day2;
import de.profschmergmann.day3.Day3;
import de.profschmergmann.day4.Day4;
import de.profschmergmann.day5.Day5;
import de.profschmergmann.day6.Day6;
import de.profschmergmann.day7.Day7;
import de.profschmergmann.day8.Day8;
import de.profschmergmann.day9.Day9;

public class Main {

    public static void main(String[] args) {
        printResults(new Day17());
    }

    public static void printResults(Day day) {
        System.out.println("Result of day " + day.number() + ":");
        System.out.println(Utilities.PART_ONE + day.resultPartOne());
        System.out.println(Utilities.PART_TWO + day.resultPartTwo());
    }

    private static Day[] createDayArray() {
        return new Day[]{new Day1(), new Day2(), new Day3(), new Day4(),
                new Day5(), new Day6(), new Day7(), new Day8(), new Day9(),
                new Day10(), new Day11(), new Day12(), new Day13(), new Day14(),
                new Day15(), new Day16(), new Day17()};
    }

}
