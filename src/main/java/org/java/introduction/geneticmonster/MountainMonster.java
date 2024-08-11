package org.java.introduction.geneticmonster;



import java.io.*;

import static java.lang.Character.getName;

public class MountainMonster extends Monster {
    public MountainMonster(String name, String color, int strength, int speed) {
        super(name, color, strength, speed);
    }

    @Override
    public void performSpecialAbility() {
        System.out.println(getName() + " is climbing!");
    }

    private boolean getName() {
        return false;
    }

    @Override
    public void saveToFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(getName() + ".txt"))) {
            writer.write(toString());
        }
    }

    public static MountainMonster loadFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            String[] parts = line.split(",");
            return new MountainMonster(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
