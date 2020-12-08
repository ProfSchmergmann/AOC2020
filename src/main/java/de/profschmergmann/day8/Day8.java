package de.profschmergmann.day8;

import de.profschmergmann.Day;
import lombok.Data;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Day8 extends Day {

    static int accumulator = 0;
    private final ArrayList<InstructionLine> instructionLines;

    public Day8() {
        super(8);
        this.instructionLines = new ArrayList<>();
        this.readInstructions();
    }

    /**
     * Reads all instructions in the given file.
     */
    private void readInstructions() {
        for (int i = 0; i < this.input.size(); i++) {
            String[] tmpInstruction = this.input.get(i).split(" ");
            this.instructionLines.add(
                    new InstructionLine(i,
                            Integer.parseInt(tmpInstruction[1]),
                            Instruction.valueOf(tmpInstruction[0])));
        }
    }

    @Override
    public String resultPartOne() {
        this.executeInstructions();
        return String.valueOf(accumulator);
    }

    @Override
    public String resultPartTwo() {
        int instructionNumberChanged;
        while (!this.executeInstructions()) {
            for (int i = 0; i < this.instructionLines.size(); i++) {
                // TODO: Change an instruction from nop to jmp or jmp to nop and see if the program terminates
            }
        }
        return null;
    }

    @Override
    public int number() {
        return 8;
    }

    /**
     * Executed all instructions and stops if a instruction would be executed twice.
     *
     * @return true if the program terminated correctly, false if not
     */
    private boolean executeInstructions() {
        boolean terminated = true;
        for (int i = 0; i < this.instructionLines.size(); ) {
            if (this.instructionLines.get(i).visited) {
                terminated = false;
                break;
            }
            this.instructionLines.get(i).visited = true;
            i += this.instructionLines.get(i).execute();
        }
        return terminated;
    }

    @Data
    private static class InstructionLine {
        private boolean visited;
        private final int lineNumber;
        private final int value;
        private Instruction instruction;

        InstructionLine(int lineNumber, int value, Instruction instruction) {
            this.lineNumber = lineNumber;
            this.value = value;
            this.instruction = instruction;
        }

        /**
         * Executes the given Instruction.
         *
         * @return the skip value,
         * where +1 means it will execute the next instruction
         * and +2 will skip the next one
         */
        int execute() {
            switch (this.instruction) {
                case acc:
                    accumulator += this.value;
                    return 1;
                case jmp:
                    return this.value;
                case nop:
                    return 1;
                default:
                    Logger.getGlobal().info("No executable instruction found.");
            }
            return 0;
        }
    }

    enum Instruction {
        acc("acc"), jmp("jmp"), nop("nop");

        private final String text;

        Instruction(String text) {
            this.text = text;
        }

        String getText(Instruction instruction) {
            return instruction.text;
        }

        /**
         * Checks if the given text is associated to a stored value.
         *
         * @param text the text to be checked
         * @return the enum value
         */
        Instruction getValue(String text) {
            for (Instruction instruction : Instruction.values()) {
                if (this.getText(instruction).equals(text)) {
                    return instruction;
                }
            }
            return null;
        }
    }
}
