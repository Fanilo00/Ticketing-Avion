package main;
import java.sql.Connection;
import java.sql.Timestamp;

import connex.Connect;
import vols.Vol;

public class Main {

	public static void main(String[] args)
	{
		
		Connect con=new Connect();
		Connection c=con.Connex();
		
		Vol v= new Vol();
//		Vol[] vo=v.get_ListeVols(c);
//		for(int i=0;i<vo.length;i++)
//		{
//			System.out.println(vo[i].getId_Vol());
//		}
		v.setNumero_vol(1003);
		v.setId_avion(1); 
		v.setSource("Paris"); 
		v.setDestination("Hawai"); 
		v.setDate_vol(Timestamp.valueOf("2023-07-08 10:30:00")); 
		v.setPrix(500); 
		
		v.insert_vol(c);

		
	}
}
