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
            ArrayList<String> champList = new ArrayList();
            initaialize(champList);
        }


        private void initaialize(List list){
            list.add(new champ(1,"Warwick", "Jungler", 2.9, 50.4, 1.4));
            list.add(new champ(2,"Viego", "Jungler", 11.2, 48.5, 11.7));
            list.add(new champ(3,"Tahm Kench", "Top-lane", 1.6, 59.95, 3.6));
            list.add(new champ(4,"Illaoi", "Top-Lane", 2.2, 50.97, 1.0));
            list.add(new champ(5,"Aurelion Sol", "Mid-Lane", 0.8, 52.56, 0.2));
            list.add(new champ(6,"Akshan", "Mid-Lane", 3.8, 51.17, 16.3));
            list.add(new champ(7,"Vayne", "Bot-Lane", 13.5, 52.09, 18.0));
            list.add(new champ(8,"Draven", "Bot-Lane", 5.1, 49.71, 6.8));
            list.add(new champ(9,"Sona", "Support", 3.5, 52.74, 0.3));
            list.add(new champ(10,"Traic", "Support", 0.9, 50.71, 0.1));

            System.out.println(list);
        }


}

