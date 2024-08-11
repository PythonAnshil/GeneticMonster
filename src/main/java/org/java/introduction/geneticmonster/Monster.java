package org.java.introduction.geneticmonster;

import java.io.*;

public abstract class Monster {
    protected String name;
    protected String color;
    protected int strength;
    protected int speed;

    public Monster(String name, String color, int strength, int speed) {
        this.name = name;
        this.color = color;
        this.strength = strength;
        this.speed = speed;
    }

    public abstract void performSpecialAbility();

    @Override
    public String toString() {
        return name + "," + color + "," + strength + "," + speed;
    }

    public void saveToFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(name + ".txt"))) {
            writer.write(toString());
        }
    }

    public static Monster loadFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            String[] parts = line.split(",");
            return new Monster(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3])) {
                @Override
                public void performSpecialAbility() {
                    // Implement a default ability if needed
                }
            };
        }
    }
}

