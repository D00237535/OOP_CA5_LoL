package org.example.DAO;

import org.example.DTOs.Champ;
import org.example.Exceptions.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLChampDAO extends MySqlDao implements ChampDaoInterface {


    @Override
    public List<Champ> findAllChamp() throws DaoException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Champ> champList = new ArrayList<>();

        try {
            connection = this.getConnection();

            String query = "SELECT * FROM CHAMP";
            ps = connection.prepareStatement(query);

            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String mainRole = resultSet.getString("mainRole");
                String region = resultSet.getString("region");
                double winRate = resultSet.getDouble("winRate");
                double pickRate = resultSet.getDouble("pickRate");
                double banRate = resultSet.getDouble("banRate");
                int roleRank = resultSet.getInt("RoleRank");
                int overAllRank = resultSet.getInt("overAllRank");
                String tier = resultSet.getString("tier");
                Champ c = new Champ(id, name, mainRole, region, winRate, pickRate, banRate, roleRank, overAllRank, tier);
                champList.add(c);
            }
        } catch (SQLException e) {
            throw new DaoException("findAllChampResultSet()" + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    freeConnection(connection);
                }
            } catch (SQLException e) {
                throw new DaoException("findAllUsers() " + e.getMessage());
            }
        }
        return champList;
    }

    @Override
    public Champ findChampByChampBan(String Champ_name, double Champ_banRate) throws DaoException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Champ champ = null;
        try{
            connection = this.getConnection();

            String query = "SELECT * FROM CHAMP_name = Warwick AND Champ_banRate = 1.47";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, Champ_name);
            preparedStatement.setDouble(2, Champ_banRate);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int id = resultSet.getInt("Champ_id");
                String name = resultSet.getString("Champ_name");
                String mainRole = resultSet.getString("Champ_mainRole");
                String region = resultSet.getString("Champ_Region");
                double winRate = resultSet.getDouble("Champ_winRate");
                double pickRate = resultSet.getDouble("Champ_pickRate");
                double banRate = resultSet.getDouble("Champ_banRate");
                int roleRank = resultSet.getInt("Champ_RoleRank");
                int overAllRank = resultSet.getInt("Champ_overAllRank");
                String tier = resultSet.getString("Champ_tier");

                champ = new Champ(id, name, mainRole, region, winRate, pickRate, banRate, roleRank, overAllRank, tier);
            }
        }catch (SQLException e){
            throw new DaoException("findChampByChampBan() " + e.getMessage());
        } finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (preparedStatement != null)
                {
                    preparedStatement.close();
                }
                if (connection != null)
                {
                    freeConnection(connection);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findChampByChampBan() " + e.getMessage());
            }
        }
        return champ;
    }
}
