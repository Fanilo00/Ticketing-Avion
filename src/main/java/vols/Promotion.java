package vols;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

public class Promotion {
	int id_Promotion;
	int idavion;
    int classe;
    Timestamp datefin;
    
	public int getId_Promotion() {
		return id_Promotion;
	}
	public void setId_Promotion(int id_Promotion) {
		this.id_Promotion = id_Promotion;
	}
	public int getIdavion() {
		return idavion;
	}
	public void setIdavion(int idavion) {
		this.idavion = idavion;
	}
	public int getClasse() {
		return classe;
	}
	public void setClasse(int classe) {
		this.classe = classe;
	}
	public Timestamp getDatefin() {
		return datefin;
	}
	public void setDatefin(Timestamp datefin) {
		this.datefin = datefin;
	}
	
	
	public Promotion(int id_Promotion, int idavion, int classe,
			Timestamp datefin)
	{
		this.setId_Promotion(id_Promotion);
		this.setIdavion(idavion);
		this.setClasse(classe);
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
     	            int idvol=result.getInt("id_avion");
     	            int classe = result.getInt("classe");
     	            Timestamp datefin = result.getTimestamp("datefin");
     	            prom = new Promotion(id_prom,idvol,classe,datefin);
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
