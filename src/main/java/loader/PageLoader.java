package loader;

import controllergrafici.Homepageview;
import controllergrafici.LoginView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PageLoader {
    public static void pageLoader(String filename){            //Metodo per il caricamneto della pagina
        FXMLLoader loader = new FXMLLoader(Homepageview.class.getClassLoader().getResource(filename));
        Parent root = null;
        try {
            root = loader.load();           //caricamento della pagina del Login
        } catch (IOException exception) {
            System.exit(0);
        }
        Stage stage = new Stage();
        stage.setScene(new Scene(root, 500, 500));
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
        loginstage.setScene(new Scene(loginroot, 500, 500));
        loginstage.setResizable(false);
        loginstage.show();
    }
}
