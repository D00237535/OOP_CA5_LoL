package org.example.Main;

import org.example.Main.Champ;
import org.example.Main.SortType;

import java.util.Comparator;

public class BanRateComparator implements Comparator<Champ> {

    private SortType sortType;

    public BanRateComparator(SortType sortType) {
        this.sortType = sortType;
    }

    @Override
    public int compare(Champ champ1, Champ champ2) {
        if (sortType == SortType.Ascending) {
            return Double.compare(champ1.getBanRate(), champ2.getBanRate());
        } else {
            return Double.compare(champ2.getBanRate(), champ1.getBanRate());
        }
    }
}