package org.example.DAO;

import org.example.DTOs.Champ;
import org.example.Exceptions.DaoException;

import java.util.List;

public interface ChampDaoInterface {

    public List<Champ> findAllChamp() throws org.example.Exceptions.DaoException;

    public Champ findChampByChampName(String name) throws org.example.Exceptions.DaoException;

    public void addChamp(int id, String name, String mainRole, String region, double winRate, double pickRate, double banRate,int roleRank, int overAllRank, String tier) throws DaoException;

    public List<Champ> findAllFromRegion(String region) throws DaoException;

    Champ deleteChampByID(int id) throws org.example.Exceptions.DaoException;

    String findAllChampJSON() throws DaoException;

}
