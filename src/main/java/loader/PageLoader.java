package loader;

import controllergrafici.loginview.LoginView;
import create.Createentity;
import exception.PrivateConstructorException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class PageLoader {
    private PageLoader() throws PrivateConstructorException {
        throw new PrivateConstructorException("Non chiamare questo costruttore");
    }
    public static void setCoordinate(TextField setter,int x,int y){
        setter.setLayoutX(x);
        setter.setLayoutY(y);
    }
    public static void pageLoader(String filename){            //Metodo per il caricamneto della pagina
        FXMLLoader loader = new FXMLLoader(PageLoader.class.getResource(filename));
        Parent root = null;
        try {
            root = loader.load();           //caricamento della pagina del Login
        } catch (IOException exception) {
            System.exit(0);
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }
    public static void loginPageLoader(String filename){
        FXMLLoader loader = new FXMLLoader(LoginView.class.getClassLoader().getResource(filename));
        Parent loginroot = null;
        try {
            loginroot = loader.load();           //caricamento della pagina del Login
        } catch (IOException exception) {
            System.exit(0);           //SE non trovo la pagina chiudo l'applicazione
        }
        Stage loginstage = new Stage();
        loginstage.setScene(new Scene(loginroot));
        loginstage.setResizable(false);
        loginstage.show();
    }
    public static void ticketPageLoader(String filename){
        FXMLLoader loader = new FXMLLoader(PageLoader.class.getClassLoader().getResource(filename));
        AnchorPane ticketRoot=null;
        try {
            ticketRoot=loader.load();
        } catch (IOException e) {
            System.exit(0);
        }
        TextField nome=new TextField();
        nome.setText(Createentity.getInstance().getaccount().getNome());
        TextField settore=new TextField();
        settore.setText(Createentity.getInstance().getSector().getNomeSettore());
        TextField seat=new TextField();
        seat.setText(Createentity.getInstance().getSeat().getNumSeat());
        PageLoader.setCoordinate();
    }
}
