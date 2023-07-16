package avion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class Avion {
	
	
	int id_avion;
	int nb_placeaff;
	int nb_placeeco;
	public int getId_avion() {
		return id_avion;
	}
	public void setId_avion(int id_avion) {
		this.id_avion = id_avion;
	}
	public int getNb_placeaff() {
		return nb_placeaff;
	}
	public void setNb_placeaff(int nb_placeaff) {
		this.nb_placeaff = nb_placeaff;
	}
	public int getNb_placeeco() {
		return nb_placeeco;
	}
	public void setNb_placeeco(int nb_placeeco) {
		this.nb_placeeco = nb_placeeco;
	}
	public Avion() {
		
	}
	public Avion(int id_avion, int nb_placeaff, int nb_placeeco) {
		this.setId_avion(id_avion);
		this.setNb_placeaff(nb_placeaff);
		this.setNb_placeeco(nb_placeeco);
	}
	
	
	public static Avion get_Avion_by_Id(Connection con,int idavion) 
    {
        Avion avion=null;
        try {
        	if(con!=null)
        	{
        		Statement stmnt = con.createStatement();
       	      
     	        String sql = "SELECT * FROM Avion where id_avion=" + idavion;
     	        ResultSet result = stmnt.executeQuery(sql);
     	        while (result.next()) 
     	        {
     	            int id_avion = result.getInt("id_avion");
     	            int nbplace_affaire=result.getInt("nb_place_ca");
     	            int nbplace_eco = result.getInt("nb_place_ce");
     	            

     	            avion = new Avion(id_avion,nbplace_affaire,nbplace_eco);
     	        }
     	        	
     	        result.close();
     	        stmnt.close();
        	}
     
       
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        return avion;
    }
	
	
	
	

}
