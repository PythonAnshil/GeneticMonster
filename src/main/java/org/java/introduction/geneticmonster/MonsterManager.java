package org.java.introduction.geneticmonster;


import java.io.IOException;
import java.util.ArrayList;

public class MonsterManager {
    private ArrayList<Monster> monsters = new ArrayList<>();

    public void addMonster(Monster m) {
        monsters.add(m);
    }

    public void breedMonsters(int index1, int index2) {
        // Implement breeding logic
    }

    public void saveGame() throws IOException {
        FileManager.saveMonsters(monsters, "monsters_data.txt");
    }

    public void loadGame() throws IOException {
        monsters = FileManager.loadMonsters("monsters_data.txt");
    }

    public void displayMonsters(boolean detailed) {
        for (Monster m : monsters) {
            System.out.println(m);
        }
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(ArrayList<Monster> monsters) {
        this.monsters = monsters;
    }
}
