package bean;

import entity.Seat;
import entity.Sector;

public class CreateTicketBean {     //Bean che mando alla ticket dao per inserirlo sul  db non aggiungo check su input perchè già fatti in precedenza
    private String nomeProp;
    private Seat selectSeat;
    private Sector selectSector;
    public CreateTicketBean(Seat selSeat,Sector selSector,String nome){
        this.selectSeat=selSeat;
        this.selectSector=selSector;
        this.nomeProp=nome;
    }
    public Seat getSelectSeat(){
        return this.selectSeat;
    }
    public Sector getSelectSector(){
        return this.selectSector;
    }
    public String getNomeProp() {
        return this.nomeProp;
    }
}
