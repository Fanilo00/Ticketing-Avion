package vols;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

public class Promotion {
	int id_Promotion;
	int idvol;
    String classe;
    int par_Nbplace;
    Timestamp datedebut;
    Timestamp datefin;
	public int getId_Promotion() {
		return id_Promotion;
	}
	public void setId_Promotion(int id_Promotion)
	{
		this.id_Promotion = id_Promotion;
	}
	public int getIdvol() {
		return idvol;
	}
	public void setIdvol(int idvol) {
		this.idvol = idvol;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public int getPar_Nbplace() {
		return par_Nbplace;
	}
	public void setPar_Nbplace(int par_Nbplace) {
		this.par_Nbplace = par_Nbplace;
	}
	public Timestamp getDatedebut() {
		return datedebut;
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
	public Promotion(int id_Promotion, int idvol, String classe,int par_Nbplace,Timestamp datedebut,
			Timestamp datefin)
	{
		this.setId_Promotion(id_Promotion);
		this.setIdvol(idvol);
		this.setClasse(classe);
		this.setPar_Nbplace(par_Nbplace);
		this.setDatedebut(datedebut);
		this.setDatefin(datefin);
	}
	public Promotion() {
		
	}
	
	public static Promotion get_Promotion(Connection con,int id_vol)
	{
		
        Promotion prom=null;
        try {
        	if(con!=null)
        	{
        		Statement stmnt = con.createStatement();
       	      
     	        String sql = "SELECT * FROM Promotion where id_vol="+ id_vol;
     	        ResultSet result = stmnt.executeQuery(sql);
     	        while (result.next()) 
     	        {
     	            int id_prom = result.getInt("id_promotion");
     	            int idvol=result.getInt("id_vol");
     	            String classe = result.getString("classe");
     	            int nbplace = result.getInt("nb_place");
     	            Timestamp datedebut = result.getTimestamp("datedebut");
     	            Timestamp datefin = result.getTimestamp("datefin");
     	            prom = new Promotion(id_prom,idvol,classe,nbplace,datedebut,datefin);
     	        }
     	        result.close();
     	        stmnt.close();
        	}  
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return prom;
	}

   
    
}
