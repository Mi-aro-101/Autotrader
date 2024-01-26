package org.autotrader.dto;

public class ModeleVoitureDto {
    
    private int idModeleVoiture;
    private String nomModeleVoiture;
    private int idMarqueVoiture;

    public int getIdModeleVoiture() {
        return idModeleVoiture;
    }

    public String getNomModeleVoiture() {
        return nomModeleVoiture;
    }

    public int getIdMarqueVoiture() {
        return idMarqueVoiture;
    }

    public void setIdModeleVoiture(int idModeleVoiture) {
        this.idModeleVoiture = idModeleVoiture;
    }

    public void setNomModeleVoiture(String nomModeleVoiture) {
        this.nomModeleVoiture = nomModeleVoiture;
    }

    public void setIdMarqueVoiture(int idMarqueVoiture) {
        this.idMarqueVoiture = idMarqueVoiture;
    }

}
