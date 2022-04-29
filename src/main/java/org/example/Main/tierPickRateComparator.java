package org.example.Main;

import java.util.Comparator;

public class tierPickRateComparator implements Comparator<Champ> {

    //compare integer stockLvl withing Brand
    @Override
    public int compare(Champ c1, Champ c2) {

        boolean brandSame =
                c1.getTier().equalsIgnoreCase(c2.getTier());


        if (brandSame) {
            return (int) ((c1.getPickRate() - c2.getPickRate()) * -1);
        } else {
            return c1.getTier().compareToIgnoreCase(c2.getTier());
        }
    }
}