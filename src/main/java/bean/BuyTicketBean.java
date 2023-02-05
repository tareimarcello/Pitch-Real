package bean;

import exception.NullSelectionException;

//Classe bean che uso nel caso d'uso buy Ticket
public class BuyTicketBean {
    private String sectorName;
    private String seatNumber;
    public BuyTicketBean(){
        this.sectorName=null;
        this.seatNumber=null;
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
    private void checkValidSector() throws NullSelectionException {
        if(this.sectorName==null){
            throw new NullSelectionException("Non hai selezionato alcun settore ");
        }
    }
}
