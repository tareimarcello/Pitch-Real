package loader;

import controllergrafici.loginview.LoginView;
import create.CreateBuyGadget;
import create.Createentity;
import exception.PrivateConstructorException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import patterndecorator.Carrello;

import java.io.IOException;

import static javafx.scene.paint.Color.GREEN;
import static javafx.scene.paint.Color.WHITE;


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
    public static void loaderCarrello(){
        int i=0;
        double totPrice=0;
        FXMLLoader fxmlLoader = new FXMLLoader(PageLoader.class.getResource("Carrello.fxml"));
        AnchorPane rootCarrello=null;
        try {
            rootCarrello = fxmlLoader.load();
        } catch (IOException e) {
            System.exit(0);
        }
        Carrello ordineDaStampare=CreateBuyGadget.getInstance().getcontroller().getCarrello();
        Scene scene = new Scene(rootCarrello);
        Text text=new Text();
        text.setText("Stai acquistando: ");
        for(i=0;i< ordineDaStampare.getOrdine().size();i++) {
            text.setText(text.getText()+String.format("%n%s",ordineDaStampare.getOrdine().get(i).getNomeGadget()));
            totPrice=totPrice+ordineDaStampare.getOrdine().get(i).getPrezzo();
        }
        Text price=new Text(String.format("%d",totPrice));
        Button buyButton=new Button(price.getText());
        buyButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                PageLoader.pageLoader("First-View/OrdineEffettuato.fxml");
            }
        });
        Button backButton=new Button("Torna allo store");
        backButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                PageLoader.pageLoader("First-View/CityGadgetShop.fxml");
            }
        });
        PageLoader.setLayoutButton(buyButton,330,250);
        PageLoader.setLayoutButton(backButton,450,250);
        PageLoader.setLayoutLabel(text,30,200);
        rootCarrello.getChildren().addAll(text,buyButton,backButton);
        Stage stageCarrello=new Stage();
        stageCarrello.setScene(scene);
        stageCarrello.show();
    }
    private static void setLayoutLabel(Text l,double x,double y){
        l.setTranslateX(x);
        l.setTranslateY(y);
        l.setFill(WHITE);
        Font myFont=new Font("System Regular",24);
        l.setFont(myFont);
    }
    private static void setLayoutButton(Button b, double x, double y){
        b.setTranslateX(x);
        b.setTranslateY(y);
    }
}
