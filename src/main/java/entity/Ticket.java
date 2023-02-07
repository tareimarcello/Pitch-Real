package entity;

import create.Createentity;

//Classe entity che rappresenta il biglietto fisico
public class Ticket {
    String nomeProprietraio;
    Seat selectSeat;
    Sector selectSector;
    public Ticket(Seat seatSel,Sector sectorSel){
        this.selectSeat=seatSel;
        this.selectSector=sectorSel;
        this.nomeProprietraio=Createentity.getInstance().getaccount().getNome();
    }
    public void displayTicket(){  //Metodo per mostrare il biglietto

    }
}
