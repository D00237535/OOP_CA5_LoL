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
            list.add(new champ(1,"Warwick", "Jungler", 1.1%, 50.4%, 1.4%));
            list.add(new champ(2,"Viego", "Jungler"));
            list.add(new champ(3,"Tahm Kench", "Top-lane"));
            list.add(new champ(4,"Illaoi", "Top-Lane"));
            list.add(new champ(5,"Aurelion Sol", "Mid-Lane"));
            list.add(new champ(6,"Akshan", "Mid-Lane"));
            list.add(new champ(7,"Vayne", "Bot-Lane"));
            list.add(new champ(8,"Draven", "Bot-Lane"));
            list.add(new champ(9,"Sona", "Support"));
            list.add(new champ(10,"Traic", "Support"));

            System.out.println(list);
        }


}

