package avion;

import java.sql.Timestamp;

public class Promotion {
	int id_Promotion;
    Classe classe;
    int par_Nbplace;
    Timestamp datedebut;
    Timestamp datefin;

    public int getId_Promotion() {
        return id_Promotion;
    }
    public void setId_Promotion(int id_Promotion) {
        this.id_Promotion = id_Promotion;
    }
    public Classe getClasse() {
        return classe;
    }
    public void setClasse(Classe classe) {
        this.classe = classe;
    }
    public int getPar_Nbplace() {
        return par_Nbplace;
    }
    public void setDatedebut(Timestamp datedebut) {
        this.datedebut = datedebut;
    }
    public Timestamp getDatefin() {
        return datefin;
    }
    public void setDatefin(Timestamp datefin) {
        this.datefin = datefin;
    }
 
}
