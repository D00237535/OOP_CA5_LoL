package org.example.DAO;

import org.example.DTOs.Champ;

import java.util.List;

public interface ChampDaoInterface {

    public List<Champ> findAllChamp() throws org.example.Exceptions.DaoException;

    public Champ findChampByChampBan(String name, double banRate) throws org.example.Exceptions.DaoException;

    Champ deleteChampByID(int id) throws org.example.Exceptions.DaoException;
}
