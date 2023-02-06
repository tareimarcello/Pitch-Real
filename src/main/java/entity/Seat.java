package entity;

import bean.BuyTicketBean;
//Classe che rappresenta l'entità posto a sedere nel caso d'uso buy ticket
public class Seat {
    private String numSeat;
    private String nomeSettore;
    private String nomeClub;
    public Seat(String numseat,String sector,String club){
        this.numSeat=numseat;
        this.nomeSettore=sector;
        this.nomeClub=club;
    }
    public String getNomeSettore(){
        return this.nomeSettore;
    }
    public String getNumSeat(){
        return this.numSeat;
    }
    public String getNomeClubSeat(){
        return this.nomeClub;
    }
    public void  setNomeclubSeat(String club){
        this.nomeClub=club;
    }
    public void setNomeSettoreSeat(BuyTicketBean settore) {
        this.nomeSettore = settore.getSector();
    }
   public void setNumSeat(BuyTicketBean seat){
        this.numSeat=seat.getSeat();
   }
}
