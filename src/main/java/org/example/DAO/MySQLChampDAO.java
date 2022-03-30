package org.example.DAO;

import org.example.DTOs.Champ;
import org.example.Exceptions.DaoException;

import java.sql.*;
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

            String query = "SELECT * FROM `champ` WHERE name = ? AND banRate = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, Champ_name);
            preparedStatement.setDouble(2, Champ_banRate);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String mainRole = resultSet.getString("mainRole");
                String region = resultSet.getString("Region");
                double winRate = resultSet.getDouble("winRate");
                double pickRate = resultSet.getDouble("pickRate");
                double banRate = resultSet.getDouble("banRate");
                int roleRank = resultSet.getInt("RoleRank");
                int overAllRank = resultSet.getInt("overAllRank");
                String tier = resultSet.getString("tier");

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

    @Override
    public Champ deleteChampByID(int Champ_id) throws DaoException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Champ champ = null;
        try{
            connection = this.getConnection();

            String query = "DELETE FROM `champ` WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Champ_id);

            preparedStatement.executeUpdate();

            Statement statement = connection.createStatement();

            resultSet = preparedStatement.executeQuery("SELECT * FROM `champ`");
            if (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String mainRole = resultSet.getString("mainRole");
                String region = resultSet.getString("Region");
                double winRate = resultSet.getDouble("winRate");
                double pickRate = resultSet.getDouble("pickRate");
                double banRate = resultSet.getDouble("banRate");
                int roleRank = resultSet.getInt("RoleRank");
                int overAllRank = resultSet.getInt("overAllRank");
                String tier = resultSet.getString("tier");

                champ = new Champ(id, name, mainRole, region, winRate, pickRate, banRate, roleRank, overAllRank, tier);
            }
        }catch (SQLException e){
            throw new DaoException("deleteChampByID " + e.getMessage());
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
