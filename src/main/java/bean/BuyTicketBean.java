package bean;

import exception.NullSelectionException;

//Classe bean che uso nel caso d'uso buy Ticket
public class BuyTicketBean {
    private String sectorName;
    private String seatNumber;
    private String nomeClub;
    public BuyTicketBean(String nomeClub){
        this.sectorName=null;
        this.seatNumber=null;
        this.nomeClub=nomeClub;
    }
    public void setSectorName(String name) throws NullSelectionException {
        this.sectorName=name;
        this.checkValidSector();
    }
    public void setSeatNum(String num){
        this.seatNumber=num;
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
    private void checkValidSector() throws NullSelectionException {
        if(this.sectorName==null){
            throw new NullSelectionException("Non hai selezionato alcun settore ");
        }
    }
}
