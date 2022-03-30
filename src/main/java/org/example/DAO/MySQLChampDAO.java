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
    public Champ findChampByChampName(String Champ_name) throws DaoException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Champ champ = null;
        try{
            connection = this.getConnection();

            String query = "SELECT * FROM `champ` WHERE name = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, Champ_name);

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
            throw new DaoException("findChampByChampName() " + e.getMessage());
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
                throw new DaoException("findChampByChampName() " + e.getMessage());
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

    @Override
    public void addChamp(int id, String name, String mainRole, String region, double winRate, double pickRate, double banRate,int roleRank, int overAllRank, String tier) throws DaoException
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try
        {
            connection = this.getConnection();

            String query = "INSERT INTO champ VALUES (?,?,?,?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, mainRole);
            preparedStatement.setString(4, region);
            preparedStatement.setDouble(5, winRate);
            preparedStatement.setDouble(6, pickRate);
            preparedStatement.setDouble(7, banRate);
            preparedStatement.setInt(8, roleRank);
            preparedStatement.setInt(9, overAllRank);
            preparedStatement.setString(10, tier);


            preparedStatement.executeUpdate();

        } catch (SQLException e)
        {
            throw new DaoException("addPerfume() " + e.getMessage());
        } finally
        {
            try
            {
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


            }
        }
    }
}
