package org.example;

import java.util.Comparator;

public class ChampionRegionComparator implements Comparator<Champ>{

    @Override
    public int compare(Champ c1, Champ c2) {
        boolean sameRegion = c1.getRegion().equalsIgnoreCase(c2.getRegion());

        if(sameRegion){
            return  c1.getName().compareToIgnoreCase(c2.getName());
        }
        else{
            return c1.getRegion().compareToIgnoreCase(c2.getRegion());
        }
    }
}