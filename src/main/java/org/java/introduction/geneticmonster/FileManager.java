package org.java.introduction.geneticmonster;


import java.io.*;
import java.util.ArrayList;

public class FileManager {
    public static void saveMonsters(ArrayList<Monster> monsters, String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Monster m : monsters) {
                writer.write(m.toString());
                writer.newLine();
            }
        }
    }

    public static ArrayList<Monster> loadMonsters(String filename) throws IOException {
        ArrayList<Monster> monsters = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Monster monster = new Monster(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3])) {
                    @Override
                    public void performSpecialAbility() {
                        // Default ability
                    }
                };
                monsters.add(monster);
            }
        }
        return monsters;
    }
}



