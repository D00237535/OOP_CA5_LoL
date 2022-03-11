package org.example;


import java.util.*;


/**
 * Kevin Daly
 */
public class App {
    ChampManager champManager;

    public static void main(String[] args) {
        App app = new App();
        app.start();
        
        Map<Integer, Champ> champHashMap;
                                        
        //Feature 5                     
        Map<String, Champ> champTreeMap; 
    }

    public void start() {

        int findId;
        String findName;
        // Feature 1

        List<Champ> champList = new ArrayList();

        //Feature 3
        Map<Integer, Champ> champHashMap = new HashMap<>();

        //Feature 5
        Map<String, Champ> champTreeMap = new TreeMap<>();

        //Feature 6
        PriorityQueue<Champ> champPriorityQueue = new PriorityQueue<>();

        PriorityQueue<Champ> twoFieldQueue = new PriorityQueue<>(new tierPickRateComparator());

        initaialize(champList);
        for (Champ c : champList) {
            champHashMap.put(c.getId(), c);
            champTreeMap.put(c.getName(), c);
        }

        // Feature 2 + 4
        final String MENU_ITEMS = "\n*** MAIN MENU ***\n"

                + "1. Show all Champions\n"
                + "2. Hash Map Retrieve\n"
                + "3. Tree Map Retrieve \n"
                + "4. PriorityQueue Display\n"
                + "5. PriorityQueue Two-Field\n"
                + "6. Exit\n"
                + "Enter Option [1,6]";

        final int DISPLAY = 1;
        final int HASH_MAP_RETRIEVE = 2;
        final int TREE_MAP_RETRIEVE = 3;
        final int PRIORITY_QUEUE_SEQUENCE_SIMULATION = 4;
        final int PRIORITY_QUEUE_TIER_PICKRATE = 5;
        final int EXIT = 6;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option) {
                    
                    case DISPLAY:

                        System.out.println("Display All Champions");
                        displayAllChamps(champList);
                        break;

                    case HASH_MAP_RETRIEVE:

                        System.out.println("Hash Map Retrieve option chosen");
                        hashRetrieve(champList);
                        break;

                    case TREE_MAP_RETRIEVE:

                        System.out.println("Display using TreeMap option chosen");
                        treeRetrieve(champList);
                        break;

                    case PRIORITY_QUEUE_SEQUENCE_SIMULATION:

                        System.out.println("Display Priority Queue display");

                        //2 third priority
                        champPriorityQueue.add(champList.get(0));
                        champPriorityQueue.add(champList.get(1));

                        //2 second priority
                        champPriorityQueue.add(champList.get(2));
                        champPriorityQueue.add(champList.get(3));

                        //remove and display element
//                        champPriorityQueue.remove();
                        Champ champ = champPriorityQueue.remove();
                        System.out.println(champ + "\n");

                        champPriorityQueue.add(champList.get(6));

                        System.out.println(champPriorityQueue.remove());

                        while ( !champPriorityQueue.isEmpty() ) {
                            System.out.println(champPriorityQueue.remove());
                        }
                        break;

                    case PRIORITY_QUEUE_TIER_PICKRATE:
                        System.out.println("Priority queue, sorting by brand name alphabetically & pick rate, low to high");
                        twoFieldQueue.add(champList.get(0));
                        twoFieldQueue.add(champList.get(1));
                        twoFieldQueue.add(champList.get(2));
                        twoFieldQueue.add(champList.get(3));

                        displayTwoFieldQueue(twoFieldQueue);
                        break;

                    case EXIT:

                        System.out.println("Exit Menu option chosen");
                        break;

                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);

        System.out.println("\nExiting Application, goodbye.");

    }

    //Feature 1 ArrayList
    private void initaialize(List list) {
        list.add(new Champ(1, "Warwick", "Jungler", "Zuan", 50.45, 2.96, 1.47, 5, 30, "A"));

        list.add(new Champ(2, "Skarner", "Jungler", "Shurima", 48.54, 11.2, 11.7, 34, 168, "D"));

        list.add(new Champ(3, "Garen", "Toplane", "Demacia", 59.95, 1.68, 3.66, 11, 40, "S"));

        list.add(new Champ(4, "Karma", "TopLane", "Ionia", 52.98, 2.26, 1.08, 42, 152, "B"));

        list.add(new Champ(5, "Neeko", "MidLane", "Ixtal", 52.56, 3.83, 0.28, 37, 156, "A"));

        list.add(new Champ(6, "Akshan", "MidLane", "Shurima", 51.17, 3.88, 16.3, 5, 17, "S"));

        list.add(new Champ(7, "Vayne", "BotLane", "Demacia", 52.09, 13.59, 18.0, 5, 54, "S"));

        list.add(new Champ(8, "Draven", "BotLane", "Noxus", 49.71, 5.17, 6.87, 18, 145, "B"));

        list.add(new Champ(9, "Sona", "Support", "Demacia", 52.74, 3.52, 0.33, 4, 24, "A"));

        list.add(new Champ(10, "Traic", "Support", "Targon", 50.71, 0.95, 0.11, 19, 132, "B"));
    }

    public void displayAllChamps(List<Champ> champList) {
        System.out.println("==================================================================================================================================");

        System.out.println("\t " + "Id" + "\t\t" + "Name" + "\t\t" + "Role" + "\t\t" + "Region" + "\t\t" + "WinRate" + "\t\t" + "PickRate"
                + "\t\t" + "BanRate" + "\t\t" + "RoleRank" + "\t\t" + "TotalRank" + "\t\t" + "Tier" + "\t\t\t");

        System.out.println("==================================================================================================================================");

        for (Champ champ : champList) {
            System.out.println("\t " + champ.getId() + "\t\t" + champ.getName() + "\t\t" + champ.getMainRole() + "\t\t" + champ.getRegion() + "\t\t" + champ.getWinRate()
                    + "\t\t" + champ.getPickRate() + "\t\t\t" + champ.getBanRate() + "\t\t" + champ.getRoleRank() + "\t\t\t\t" + champ.getOverAllRank() + "\t\t\t\t" + champ.getTier());
        }
        System.out.println("==================================================================================================================================");
    }

    //Feature 3 Hashmap
    public static void hashRetrieve(List<Champ> champList) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Champ> map = new HashMap<>();
        for (Champ c : champList) {
            map.put(c.getId(), c);
        }

        Set<Integer> keySet = map.keySet();
        System.out.println("Choose Champion IDs:");
        for (Integer id : keySet) {
            System.out.print(id + ", ");
        }

        try {
            System.out.println("Please Enter Champion ID");
            int key = sc.nextInt();
            if (map.containsKey(key)) {
                System.out.println("Champion with the ID " + key + " - " + map.get(key));
            } else {
                System.out.println("Champion with the an ID of " + key + " does not exist.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Id entered is not valid");
        }

    }

    //Feature 5 TreeMap
    public static void treeRetrieve(List<Champ> champList) {

        Champion c1 = new Champion("Warwick", "Zaun");
        Champion c2 = new Champion("Skarner", "Shurima");
        Champion c3 = new Champion("Vayne", "Demacia");

         TreeMap<Champ, Champion> champTreeMap = new TreeMap<>(new ChampionRegionComparator());


        for (Champ c : champList) {
            if (c.getName() == c.name) {
                champTreeMap.put(c, c1);
            }
            else if (c.getName() == c.name) {
                champTreeMap.put(c, c2);
            }
            else {
                champTreeMap.put(c, c3);
            }
        }
        System.out.println("TreeMap:  Name -> Region  in order of champion name\n");

        for (Map.Entry<Champ, Champion> entry : champTreeMap.entrySet()) {

            Champ champ = entry.getKey();
            Champion champion = entry.getValue();

            System.out.println("{" + champ + "} -> " + champion);
        }
    }

        public void displayTwoFieldQueue(PriorityQueue<Champ> twoFieldQueue )
        {
            while ( !twoFieldQueue.isEmpty() ) {
                System.out.println(twoFieldQueue.remove());
            }
        }
}