package org.example.DAO;

import org.example.DTOs.Champ;
import org.example.Exceptions.DaoException;
import org.example.Main.BanRateComparator;

import java.util.List;

public interface ChampDaoInterface {

    public List<Champ> findAllChamp() throws org.example.Exceptions.DaoException;

    public Champ findChampByChampName(String name) throws org.example.Exceptions.DaoException;

    public void addChamp(int id, String name, String mainRole, String region, double winRate, double pickRate, double banRate, int roleRank, int overAllRank, String tier) throws DaoException;

    Champ deleteChampByID(int id) throws org.example.Exceptions.DaoException;

    String findAllChampJSON() throws DaoException;

    String findAllChampByIDJSON(String _id) throws DaoException;

    List<Champ> findChampUsingFilter(double Champ_banRate, BanRateComparator banRateComparator) throws DaoException;

    void addChamp(Champ champ);

    String findAllChampByNameJSON(String _name) throws DaoException;
}
