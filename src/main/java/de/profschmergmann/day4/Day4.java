package de.profschmergmann.day4;

import de.profschmergmann.Day;
import lombok.Data;

import java.util.ArrayList;

public class Day4 extends Day {

    private final ArrayList<Passport> passports;

    public Day4() {
        super(4);
        this.passports = new ArrayList<>();
        ArrayList<ArrayList<String>> splittedLines = new ArrayList<>();
        int splittedLinesCounter = 0;
        for (String value : this.input) {
            if (value.isEmpty()) {
                splittedLinesCounter++;
                continue;
            }
            try {
                if (splittedLines.get(splittedLinesCounter) == null) {
                    splittedLines.add(new ArrayList<>());
                }
            } catch (IndexOutOfBoundsException e) {
                splittedLines.add(new ArrayList<>());
            }
            for (String s : value.split("\\s")) {
                splittedLines.get(splittedLinesCounter).add(s);
            }
        }
        splittedLines.forEach(strings -> {
            Passport passport = new Passport();
            strings.forEach(s -> {
                String attribute = s.split(":")[0];
                String value = s.split(":")[1];
                if (attribute.matches("byr")) {
                    try {
                        passport.byr = Integer.parseInt(value);
                    } catch (NumberFormatException e) {
                        // ignored
                    }
                } else if (attribute.matches("iyr")) {
                    try {
                        passport.iyr = Integer.parseInt(value);
                    } catch (NumberFormatException e) {
                        // ignored
                    }
                } else if (attribute.matches("eyr")) {
                    try {
                        passport.eyr = Integer.parseInt(value);
                    } catch (NumberFormatException e) {
                        // ignored
                    }
                } else if (attribute.matches("hgt")) {
                    passport.hgt = value;
                } else if (attribute.matches("hcl")) {
                    passport.hcl = value;
                } else if (attribute.matches("ecl")) {
                    passport.ecl = value;
                } else if (attribute.matches("pid")) {
                    try {
                        passport.pid = Integer.parseInt(value);
                    } catch (NumberFormatException e) {
                        // ignored
                    }
                } else if (attribute.matches("cid")) {
                    try {
                        passport.cid = Integer.parseInt(value);
                    } catch (NumberFormatException e) {
                        // ignored
                    }
                }
            });
            this.passports.add(passport);
        });
    }

    @Override
    public String resultPartOne() {
        int counter = 0;
        for (Passport p : this.passports) {
            if (p.isPassportValid()) {
                counter++;
            }
        }
        return String.valueOf(counter);
    }

    @Override
    public String resultPartTwo() {
        return null;
    }

    @Override
    public int number() {
        return 4;
    }

    @Data
    private static class Passport {
        private int byr;
        private int iyr;
        private int eyr;
        private String hgt;
        private String hcl;
        private String ecl;
        private int pid;
        private int cid;

        public boolean isPassportValid() {
            return this.byr != 0 &&
                    this.iyr != 0 &&
                    this.eyr != 0 &&
                    this.pid != 0 &&
                    this.hgt != null &&
                    this.hcl != null &&
                    this.ecl != null;
        }
    }
}
