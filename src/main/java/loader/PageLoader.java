package loader;

import controllergrafici.loginview.LoginView;
import create.Createentity;
import exception.PrivateConstructorException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.paint.Color.GREEN;


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
    public static void ticketPageLoader(String filename, String message){
        FXMLLoader loader = new FXMLLoader(PageLoader.class.getClassLoader().getResource(filename));
        AnchorPane ticketRoot=null;
        try {
            ticketRoot=loader.load();
        } catch (IOException e) {
            System.exit(0);
        }
        Scene ticketOrder=new Scene(ticketRoot);
        TextField nome=new TextField();
        nome.setText(Createentity.getInstance().getaccount().getNome());
        TextField settore=new TextField();
        settore.setText(Createentity.getInstance().getSector().getNomeSettore());
        TextField seat=new TextField();
        seat.setText(Createentity.getInstance().getSeat().getNumSeat());
        PageLoader.setCoordinate(nome,44,80);
        PageLoader.setCoordinate(settore,44,147);
        PageLoader.setCoordinate(seat,44,219);
        if(message!=null){
            Text mailSend=new Text(message);
            mailSend.setLayoutX(417);
            mailSend.setLayoutY(226);
            mailSend.setFill(GREEN);
            Font myFont=new Font("System Regular",18);
            mailSend.setFont(myFont);                           //Caso in cui devo caricare la pagina e scrivere il messaggio a schermo che ho inviato la mail
            ticketRoot.getChildren().addAll(nome,settore,seat,mailSend);
        }else {
            ticketRoot.getChildren().addAll(nome, settore, seat);
        }
        Stage ticketOrderStage=new Stage();
        ticketOrderStage.setScene(ticketOrder);
        ticketOrderStage.show();                    //Ctreo una scena dinamicamente con i dati del biglietto
    }
}
