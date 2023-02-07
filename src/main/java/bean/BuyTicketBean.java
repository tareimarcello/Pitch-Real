package bean;

import exception.FormatErrorException;
import exception.NullSelectionException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Classe bean che uso nel caso d'uso buy Ticket
public class BuyTicketBean {
    private String sectorName;          //Settore del posto scelto
    private String seatNumber;          //POsto  selezionato
    private String nomeClub;            //Club proprietario dello stadio
    public BuyTicketBean(String nomeClub){
        this.sectorName=null;               //SEtto questi a null perchè ella prima interazione con il beam ho bisogno solo del settore succesivamente cambierò i valori tramite setter e getter
        this.seatNumber=null;
        this.nomeClub=nomeClub;
    }
    public void setSectorName(String name) throws NullSelectionException {
        this.sectorName=name;
        this.checkValidSector();
    }
    public void setSeatNum(String num) throws NullSelectionException, FormatErrorException {
        this.seatNumber=num;
        this.checkValidSEat();
    }
    public String getSector(){
        return this.sectorName;
    }
    public String getSeat(){
        return this.seatNumber;
    }
    public String getNomeClub(){
        return this.nomeClub;
    }
    private void checkValidSector() throws NullSelectionException {             //Check dell'input da parte del bean
        if(this.sectorName==null){
            throw new NullSelectionException("Non hai selezionato alcun settore ");
        }
    }
    private void checkValidSEat() throws NullSelectionException, FormatErrorException {               //Check dell'input del seat
        if(this.seatNumber==null){
            throw new NullSelectionException("Non hai selezionato alcun posto");
        }
        String espressione = "[0-9A-R]";     //Espressione regolare della email
        Pattern p = Pattern.compile(espressione);
        Matcher m = p.matcher(this.seatNumber);
        boolean matchFound = m.matches();
        if (!matchFound){         //Controllo se il numero del biglietto è stato scritto correttamente
            throw new FormatErrorException("Numero biglietto errato");
        }
    }
}
