package org.java.introduction.geneticmonster;


import java.util.Scanner;

public class Main {
    private static MonsterManager monsterManager = new MonsterManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Main Menu:");
            System.out.println("1. Create Monster");
            System.out.println("2. View Monsters");
            System.out.println("3. Breed Monsters");
            System.out.println("4. Save Game");
            System.out.println("5. Load Game");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createMonster(scanner);
                    break;
                case 2:
                    viewMonsters();
                    break;
                case 3:
                    breedMonsters(scanner);
                    break;
                case 4:
                    saveGame();
                    break;
                case 5:
                    loadGame();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private static void createMonster(Scanner scanner) {
        System.out.println("Choose Monster Type:");
        System.out.println("1. Flying Monster");
        System.out.println("2. Aquatic Monster");
        System.out.println("3. Mountain Monster");
        System.out.println("4. Desert Monster");
        System.out.print("Enter Monster Type: ");
        int type = scanner.nextInt();

        System.out.print("Enter Monster Name: ");
        String name = scanner.next();
        System.out.print("Enter Monster Color: ");
        String color = scanner.next();
        System.out.print("Enter Monster Strength: ");
        int strength = scanner.nextInt();
        System.out.print("Enter Monster Speed: ");
        int speed = scanner.nextInt();

        Monster monster = null;
        switch (type) {
            case 1:
                System.out.print("Enter Monster Wing Span: ");
                int wingSpan = scanner.nextInt();
                monster = new FlyingMonster(name, color, strength, speed, wingSpan);
                break;
            case 2:
                monster = new AquaticMonster(name, color, strength, speed);
                break;
            case 3:
                monster = new MountainMonster(name, color, strength, speed);
                break;
            case 4:
                monster = new DesertMonster(name, color, strength, speed);
                break;
            default:
                System.out.println("Invalid Monster Type.");
                return;
        }

        monsterManager.addMonster(monster);
        System.out.println("Monster created successfully.");
    }

    private static void viewMonsters() {
        monsterManager.displayMonsters(true);
    }

    private static void breedMonsters(Scanner scanner) {
        monsterManager.displayMonsters(false);
        System.out.print("Enter first monster index: ");
        int index1 = scanner.nextInt();
        System.out.print("Enter second monster index: ");
        int index2 = scanner.nextInt();

        monsterManager.breedMonsters(index1, index2);
    }

    private static void saveGame() {
        try {
            FileManager.saveMonsters(monsterManager.getMonsters(), "monsters_data.txt");
            System.out.println("Game saved successfully.");
        } catch (Exception e) {
            System.out.println("Failed to save game: " + e.getMessage());
        }
    }

    private static void loadGame() {
        try {
            monsterManager.setMonsters(FileManager.loadMonsters("monsters_data.txt"));
            System.out.println("Game loaded successfully.");
        } catch (Exception e) {
            System.out.println("Failed to load game: " + e.getMessage());
        }
    }
}

