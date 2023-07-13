package main;
import java.sql.Connection;

import connex.Connect;
import vols.Vol;

public class Main {

	public static void main(String[] args)
	{
		
		Connect con=new Connect();
		Connection c=con.Connex();
		
		Vol v= new Vol();
		Vol[] vo=v.get_All_ListeVols(c);
		for(int i=0;i<vo.length;i++)
		{
			System.out.println(vo[i].getId_Vol());
		}

		
	}
}
