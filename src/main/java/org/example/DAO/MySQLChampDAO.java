package org.example.DAO;

import com.google.gson.Gson;
import org.example.DTOs.Champ;
import org.example.Exceptions.DaoException;
import org.example.Main.BanRateComparator;

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
        try {
            connection = this.getConnection();

            String query = "SELECT * FROM `champ` WHERE name = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, Champ_name);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
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
        } catch (SQLException e) {
            throw new DaoException("findChampByChampName() " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    freeConnection(connection);
                }
            } catch (SQLException e) {
                throw new DaoException("findChampByChampName() " + e.getMessage());
            }
        }
        return champ;
    }

    @Override
    public void addChamp(int id, String name, String mainRole, String region, double winRate, double pickRate, double banRate, int roleRank, int overAllRank, String tier) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = this.getConnection();
            String query = "INSERT INTO `champ` (id, name, mainRole, region, winRate, pickRate, banRate, RoleRank, overAllRank, tier) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
        } catch (SQLException e) {
            throw new DaoException("addChamp() " + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    freeConnection(connection);
                }
            } catch (SQLException e) {
                throw new DaoException("addChamp() " + e.getMessage());
            }
        }
    }

    @Override
    public Champ deleteChampByID(int Champ_id) throws DaoException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Champ champ = null;
        try {
            connection = this.getConnection();

            String query = "DELETE FROM `champ` WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Champ_id);

            preparedStatement.executeUpdate();

            Statement statement = connection.createStatement();

            resultSet = preparedStatement.executeQuery("SELECT * FROM `champ`");
            if (resultSet.next()) {
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
        } catch (SQLException e) {
            throw new DaoException("deleteChampByID " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    freeConnection(connection);
                }
            } catch (SQLException e) {
                throw new DaoException("findChampByChampBan() " + e.getMessage());
            }
        }
        return champ;
    }

    @Override
    public void addChamp(String name, String mainRole, String region, double winRate, double pickRate, double banRate, int roleRank, int overAllRank, String tier) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = this.getConnection();

            String query = "INSERT INTO champ VALUES (null, ?,?,?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, mainRole);
            preparedStatement.setString(3, region);
            preparedStatement.setDouble(4, winRate);
            preparedStatement.setDouble(5, pickRate);
            preparedStatement.setDouble(6, banRate);
            preparedStatement.setInt(7, roleRank);
            preparedStatement.setInt(8, overAllRank);
            preparedStatement.setString(9, tier);


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException("addPerfume() " + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    freeConnection(connection);
                }
            } catch (SQLException e) {


            }
        }
    }


    @Override
    public String findAllChampJSON() throws DaoException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Champ> champlist = new ArrayList<>();
        Gson gsonParser = new Gson();

        try {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            connection = this.getConnection();

            String query = "SELECT * FROM champ";
            ps = connection.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
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

                Champ c = new Champ(id, name, mainRole, region, winRate, pickRate, banRate, roleRank, overAllRank, tier);
                champlist.add(c);
            }
        } catch (SQLException e) {
            throw new DaoException("findAllChampResultSet() " + e.getMessage());
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

        String Result = gsonParser.toJson(champlist);    // Serialize an object

        return Result;     // may be empty
    }

    @Override
    public String findAllChampByIDJSON(String _id) throws DaoException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Champ champ = null;
        Gson gsonParser = new Gson();
        try {
            connection = this.getConnection();

            String query = "SELECT * FROM champ WHERE id = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, _id);


            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
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
        } catch (SQLException e) {
            throw new DaoException("findChampByID() " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    freeConnection(connection);
                }
            } catch (SQLException e) {
                throw new DaoException("findPerfumeByID() " + e.getMessage());
            }
        }
        String Result = gsonParser.toJson(champ);    // Serialize an object

        return Result;     // may be empty
    }

    @Override
    public List<Champ> findChampUsingFilter(double Champ_banRate, BanRateComparator banRateComparator) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Champ> champList = new ArrayList<>();
        try {
            connection = this.getConnection();

            String query = "SELECT * FROM champ where banRate < ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, Champ_banRate);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
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

                Champ c = new Champ(id, name, mainRole, region, winRate, pickRate, banRate, roleRank, overAllRank, tier);
                champList.add(c);
            }
        } catch (SQLException e) {
            throw new DaoException("findChampUsingFilter() " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    freeConnection(connection);
                }
            } catch (SQLException e) {
                throw new DaoException("findChampUsingFilter() " + e.getMessage());
            }
        }
        return champList;
    }

    @Override
    public void addChamp(Champ champ) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = this.getConnection();
            String query = "INSERT INTO champ (name, mainRole, Region, winRate, pickRate, banRate, RoleRank, overAllRank, tier) VALUES (?,?,?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, champ.getName());
            preparedStatement.setString(2, champ.getMainRole());
            preparedStatement.setString(3, champ.getRegion());
            preparedStatement.setDouble(4, champ.getWinRate());
            preparedStatement.setDouble(5, champ.getPickRate());
            preparedStatement.setDouble(6, champ.getBanRate());
            preparedStatement.setInt(7, champ.getRoleRank());
            preparedStatement.setInt(8, champ.getOverAllRank());
            preparedStatement.setString(9, champ.getTier());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    freeConnection(connection);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String findAllChampByNameJSON(String _name) throws DaoException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Champ champ = null;
        Gson gsonParser = new Gson();
        try {
            connection = this.getConnection();

            String query = "SELECT * FROM champ WHERE name = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, _name);


            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
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
        } catch (SQLException e) {
            throw new DaoException("findChampByID() " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    freeConnection(connection);
                }
            } catch (SQLException e) {
                throw new DaoException("findPerfumeByID() " + e.getMessage());
            }
        }
        String Result = gsonParser.toJson(champ);    // Serialize an object

        return Result;     // may be empty
    }

}
