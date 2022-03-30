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

            Champ champ = IChampDao.findChampByChampName(name);
            if(champ != null)
                System.out.println("Champion: " + name + " was found " + champ);
            else
                System.out.println("Champion: " + name + ", banRate: " + banRate + " was not found");


            System.out.println("\nCall: deleteChampByID");
            int id = 1;
            name = "Warwick";

            champ = IChampDao.deleteChampByID(id);
            if(champ != null)
                if(champ != null)
                    System.out.println("Champion: " + name + " with id " + id +" was found and deleted");
                else
                    System.out.println("Champion: " + id + " was not found");


            System.out.println("\nCall: insertChamp");
            id = 11;
            name = "Veigar";
            String mainRole = "MidLane";
            String region = "Bandle";
            double winRate = 51.74;
            double pickRate = 7.9;
            banRate = 9.7;
            int roleRank = 11;
            int overAllRank = 36;
            String tier= "s";

            champ = IChampDao.deleteChampByID(id);
            if(champ != null)
                if(champ != null)
                    System.out.println("Champion: " + name + " with id " + id +" was found and deleted");
                else
                    System.out.println("Champion: " + id + " was not found");

        }
        catch( DaoException e )
        {
            e.printStackTrace();
        }
    }
}
