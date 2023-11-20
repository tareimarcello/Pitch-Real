package loader;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.paint.Color.RED;

public class Page {
    static Stage stage1;
    static Scene scene1;
    static String title1;
    boolean checkActive = true;
    static final String INTERF1 = "interf1";
    static final String INTERF2 = "interf2";
    static final String FXML = ".fxml";
    private AnchorPane clubNome;

    public Page() {
    }

    static void prevBack(ActionEvent event) {
        stage1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene1 = ((Node)event.getSource()).getScene();
        title1 = stage1.getTitle();
    }

    static String check(String name, Stage stage) {
        int index;
        if (stage.getWidth() > 500.0 && name.indexOf("interf1") > -1) {
            index = name.indexOf("interf1");
            name = name.substring(0, index);
            name = name + "interf2.fxml";
        } else if (stage.getWidth() < 500.0 && name.indexOf("interf2") > -1) {
            index = name.indexOf("interf2");
            name = name.substring(0, index);
            name = name + "interf1.fxml";
            stage.setMaxWidth(414.0);
            stage.setMinHeight(736.0);
        }

        return name;
    }

    public void switchToClub(String name, ActionEvent event,String clubName, String title,String sytemMessage) {
        try {
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            if (this.checkActive) {
                name = check(name, stage);
            }
            prevBack(event);
            AnchorPane root = FXMLLoader.load(getClass().getClassLoader().getResource(name));
            Label club = new Label(clubName);//rivedere bene la grandezza e la posizione della label
            club.setFont(Font.font(24));
            club.setLayoutY(104.0);
            club.setLayoutX(214.0);
            if(!sytemMessage.equals("")){
                Label systemMessage = new Label("Biglietto inviato");
                systemMessage.setLayoutX(216.0);
                systemMessage.setLayoutY(435.0);
                systemMessage.setTextFill(RED);
                systemMessage.setMinHeight(55.0);
                systemMessage.setMinWidth(55.0);    //Aggiungi la label alla root già esistente
                root.getChildren().add(systemMessage);
            }
            root.getChildren().add(club);
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();
        } catch (IOException var7) {
            var7.printStackTrace();
        }

    }
    public void switchTo(String name, ActionEvent event, String title) {
        try {
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            if (this.checkActive) {
                name = check(name, stage);
            }

            prevBack(event);
            Parent root = (Parent)FXMLLoader.load(getClass().getClassLoader().getResource(name));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();
        } catch (IOException var7) {
            var7.printStackTrace();
        }

    }

    public void backTo() {
        stage1.setScene(scene1);
        stage1.setTitle(title1);
        stage1.show();
    }

    public void setSize(String name, ActionEvent event) {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        int index = name.indexOf("interf2");
        if (index == -1) {
            index = name.indexOf("interf1");
        }

        if (stage.getWidth() > 500.0) {
            name = name.substring(0, index);
            name = name + "interf1.fxml";
        } else {
            name = name.substring(0, index);
            name = name + "interf2.fxml";
        }

        this.checkActive = false;
        this.switchTo(name, event, stage.getTitle());
    }
}
