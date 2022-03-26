package org.example.DAO;

import org.example.DAO.MySQLChampDAO;
import org.example.DAO.ChampDaoInterface;
import org.example.DTOs.Champ;
import org.example.Exceptions.DaoException;
import java.util.List;

public class App
{
    public static void main(String[] args)
    {
        ChampDaoInterface IChampDao = new MySQLChampDAO();

        try{
            System.out.println("\nCall: findAllChamps");
            List<Champ> champs = IChampDao.findAllChamp();

            if( champs.isEmpty())
                System.out.println("There is no Champions");
            else{
                for(Champ champ : champs)
                    System.out.println("Champ: " +champ.toString());
            }

            System.out.println("\nCall: findChampByChampBan");
            String name = "Warwick";
            double banRate = 1.47;

            Champ champ = IChampDao.findChampByChampBan(name, banRate);
            if(champ != null)
                System.out.println("Champion: " + name + " was found " + champ);
            else
                System.out.println("Champion: " + name + ", banRate: " + banRate + " was not found");
        }
        catch( DaoException e )
        {
            e.printStackTrace();
        }
    }
}
