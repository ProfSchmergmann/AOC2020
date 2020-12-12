package de.profschmergmann.day12;

import de.profschmergmann.Day;

public class Day12 extends Day {
    public Day12() {
        super(12);
    }

    @Override
    public String resultPartOne() {
        Ship ship = new Ship();
        this.input.forEach(s -> {
            Instruction instruction = new Instruction(s.charAt(0), Integer.parseInt(s.substring(1)));
            ship.move(instruction);
        });
        return ship.positionEast + ship.positionSouth + "";
    }

    @Override
    public String resultPartTwo() {
        return null;
    }

    @Override
    public int number() {
        return 12;
    }

    private static class Ship {
        char movingDirection = 'E';
        int positionEast = 0;
        int positionSouth = 0;

        void move(Instruction instruction) {
            switch (instruction.direction) {
                case 'F':
                    this.moveHelp(this.movingDirection, instruction.value);
                    break;
                case 'R':
                    // falls through
                case 'L':
                    this.movingDirection =
                            this.getNextDirectionWithDegrees(
                                    this.movingDirection, instruction.direction, instruction.value);
                    break;
                case 'N':
                case 'S':
                case 'E':
                case 'W':
                    this.moveHelp(instruction.direction, instruction.value);
                    break;
                default:
                    throw new IllegalArgumentException("Direction not supported.");
            }
        }

        private void moveHelp(char direction, int value) {
            switch (direction) {
                case 'E':
                    this.positionEast += value;
                    break;
                case 'W':
                    this.positionEast -= value;
                    break;
                case 'S':
                    this.positionSouth += value;
                    break;
                case 'N':
                    this.positionSouth -= value;
                    break;
            }

        }

        private char getNextDirectionWithDegrees(char direction, char turn, int numberOfDegrees) {
            switch (numberOfDegrees) {
                case 90:
                    if (turn == 'R') {
                        return this.getNextDirection(direction);
                    } else if (turn == 'L') {
                        return this.getPreviousDirection(direction);
                    }
                case 180:
                    if (turn == 'R') {
                        return this.getNextDirection(this.getNextDirection(direction));
                    } else if (turn == 'L') {
                        return this.getPreviousDirection(this.getPreviousDirection(direction));
                    }
                case 270:
                    if (turn == 'R') {
                        return this.getNextDirection(
                                this.getNextDirection(
                                        this.getNextDirection(direction)));
                    } else if (turn == 'L') {
                        return this.getPreviousDirection(
                                this.getPreviousDirection(
                                        this.getPreviousDirection(direction)));
                    }
                default:
                    return direction;
            }
        }

        private char getNextDirection(char direction) {
            switch (direction) {
                case 'E':
                    return 'S';
                case 'W':
                    return 'N';
                case 'S':
                    return 'W';
                case 'N':
                    return 'E';
                default:
                    throw new IllegalArgumentException("Direction not supported.");
            }
        }

        private char getPreviousDirection(char direction) {
            switch (direction) {
                case 'E':
                    return 'N';
                case 'W':
                    return 'S';
                case 'S':
                    return 'E';
                case 'N':
                    return 'W';
                default:
                    throw new IllegalArgumentException("Direction not supported.");
            }
        }

    }

    private static class Instruction {
        final int value;
        final char direction;

        Instruction(char direction, int value) {
            this.direction = direction;
            this.value = value;
        }
    }
}
