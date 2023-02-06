package entity;

import bean.BuyTicketBean;

public class Sector {
    private String nomeSettore;
    private boolean isFull=false;
    private String nomeClub;
    public Sector(String sector,String club){
        this.nomeSettore=sector;
        this.nomeClub=club;
    }
    public String getNomeSettore(){
        return this.nomeSettore;
    }
    public boolean sectorFull(){
        return this.isFull;
    }
    public String getNomeClub(){
        return this.nomeClub;
    }
    public void  setNomeclub(String club){
        this.nomeClub=club;
    }
    public void setNomeSettore(BuyTicketBean settore) {
        this.nomeSettore = settore.getSector();
    }
    public void setFull(){
        this.isFull=true;
    }
    public void unSetFull(){
        this.isFull=false;
    }
}
