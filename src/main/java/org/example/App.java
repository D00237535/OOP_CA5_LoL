package org.example;

import java.util.ArrayList;
import java.util.List;


/**
 * Kevin Daly
 *
 */
public class App{
        public static void main(String[] args) {
            App app = new App();
            app.start();
        }

        public void start() {
            System.out.println("Hello World");
            System.out.println("Project Part 1 - CA5");
            ArrayList<Champ> champList = new ArrayList();
            initaialize(champList);
            display(champList);
        }


        private void initaialize(List list){
            list.add(new Champ(1,"Warwick", "Jungler", 2.9, 50.4, 1.4,5, 30, 'A'));

            list.add(new Champ(2,"Viego", "Jungler", 11.2, 48.5, 11.7,34, 168,'D'));

            list.add(new Champ(3,"Tahm Kench", "Top-lane", 1.6, 59.95, 3.6,11, 40,'S'));

            list.add(new Champ(4,"Illaoi", "Top-Lane", 2.2, 50.97, 1.0,42, 152,'B'));

            list.add(new Champ(5,"Aurelion Sol", "Mid-Lane", 0.8, 52.56, 0.2,37, 156,'B'));

            list.add(new Champ(6,"Akshan", "Mid-Lane", 3.8, 51.17, 16.3,5, 17,'S'));

            list.add(new Champ(7,"Vayne", "Bot-Lane", 13.5, 52.09, 18.0,5, 54,'S'));

            list.add(new Champ(8,"Draven", "Bot-Lane", 5.1, 49.71, 6.8,18, 145,'B'));

            list.add(new Champ(9,"Sona", "Support", 3.5, 52.74, 0.3,4, 24,'A'));

            list.add(new Champ(10,"Traic", "Support", 0.9, 50.71, 0.1,19, 132,'B'));
        }

    public void display(List <Champ> champList){
        for (Champ champ : champList ) {
            System.out.println(champ.getId() + "\t\t\t" + champ.getName() + "\t\t" + champ.getMainRole() + "\t\t" + champ.getWinRate() + "\t\t" + champ.getPickRate()
                    + "\t\t" + champ.getBanRate() + "\t\t" + champ.getRoleRank() + "\t\t" + champ.getOverAllRank() + "\t\t" + champ.getTier() + "\t\t\t");
        }

    }


}

