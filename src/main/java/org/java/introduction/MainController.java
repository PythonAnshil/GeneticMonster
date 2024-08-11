package org.java.introduction;




import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.java.introduction.geneticmonster.*;

import java.awt.*;
import java.io.IOException;

public class MainController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField colorField;

    @FXML
    private TextField strengthField;

    @FXML
    private TextField speedField;

    @FXML
    private ComboBox<String> typeComboBox;

    @FXML
    private ListView<String> monsterListView;

    private MonsterManager monsterManager = new MonsterManager();
    private Label specialField;

    @FXML
    public void initialize() {
        typeComboBox.setItems(FXCollections.observableArrayList("Flying Monster", "Aquatic Monster", "Mountain Monster", "Desert Monster"));
    }

    @FXML
    public void handleCreateMonster() {
        String name = nameField.getText();
        String color = colorField.getText();
        int strength = Integer.parseInt(strengthField.getText());
        int speed = Integer.parseInt(speedField.getText());
        String type = typeComboBox.getValue();

        Monster monster = null;
        switch (type) {
            case "Flying Monster":
                // Add a specific input for wingSpan
                int wingSpan = Integer.parseInt(specialField.getText());
                monster = new FlyingMonster(name, color, strength, speed, wingSpan);
                break;
            case "Aquatic Monster":
                monster = new AquaticMonster(name, color, strength, speed);
                break;
            case "Mountain Monster":
                monster = new MountainMonster(name, color, strength, speed);
                break;
            case "Desert Monster":
                monster = new DesertMonster(name, color, strength, speed);
                break;
            default:
                System.out.println("Invalid Monster Type.");
                return;
        }

        monsterManager.addMonster(monster);
        monsterListView.getItems().add(monster.toString());
    }

    @FXML
    public void handleSaveGame() {
        try {
            FileManager.saveMonsters(monsterManager.getMonsters(), "monsters_data.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleLoadGame() {
        try {
            monsterManager.setMonsters(FileManager.loadMonsters("monsters_data.txt"));
            monsterListView.getItems().clear();
            for (Monster monster : monsterManager.getMonsters()) {
                monsterListView.getItems().add(monster.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

