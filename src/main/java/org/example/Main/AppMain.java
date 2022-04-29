package org.example.Main;
import org.example.DAO.ChampDaoInterface;
import org.example.DAO.MySQLChampDAO;
import org.example.Exceptions.DaoException;

import java.util.*;


/**
 * Kevin Daly
 */
public class AppMain {
    PriorityQueue<org.example.DTOs.Champ> queueDBFiltered;
    List<org.example.DTOs.Champ> listDBFiltered;

    public static void main(String[] args) {
        AppMain app = new AppMain();
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

                + "1. Show All Champions\n"
                + "2. Hash Map Retrieve\n"
                + "3. Tree Map Retrieve \n"
                + "4. PriorityQueue Display\n"
                + "5. PriorityQueue Two-Field\n"
                + "6. Find All Champions From Database\n"
                + "7. Find Champion By ID From Database\n"
                + "8. Delete Champion From Database By ID\n"
                + "9. Add Champion to database\n"
                + "10. List Champs Filtered By Ban Rate\n"
                + "11. Find All Champions From Database As JSON\n"
                + "12. Find one Champion From Database By ID As JSON\n"
                + "13. Exit\n"
                + "Enter Option [1,13]";

        final int DISPLAY = 1;
        final int HASH_MAP_RETRIEVE = 2;
        final int TREE_MAP_RETRIEVE = 3;
        final int PRIORITY_QUEUE_SEQUENCE_SIMULATION = 4;
        final int PRIORITY_QUEUE_TIER_PICKRATE = 5;
        final int GET_ALL_CHAMPS_FROM_DB = 6;
        final int GET_CHAMPS_FROM_DB_BY_ID = 7;
        final int DELETE_CHAMPS_FROM_DB_BY_ID = 8;
        final int ADD_CHAMP_TO_DB = 9;
        final int LIST_FILTERED_CHAMPS_BY_BAN_RATE = 10;
        final int GET_ALL_CHAMPS_FROM_DB_JSON = 11;
        final int GET_CHAMPS_FROM_DB_BY_ID_JSON = 12;
        final int EXIT = 13;

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

                        while (!champPriorityQueue.isEmpty()) {
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

                    case GET_ALL_CHAMPS_FROM_DB:

                        findAllChamp();
                        break;

                    case GET_CHAMPS_FROM_DB_BY_ID:

                        System.out.println("Please enter Champion Name: ");
                        String champName = keyboard.nextLine();
                        findChampByChampName(champName);
                        break;

                    case DELETE_CHAMPS_FROM_DB_BY_ID:

                        System.out.println("Please enter Champ ID: ");
                        int DeleteId = keyboard.nextInt();
                        deleteChampByID(DeleteId);
                        break;

                    case ADD_CHAMP_TO_DB:

                        addChampToDB();
                        break;

                    case LIST_FILTERED_CHAMPS_BY_BAN_RATE:

//                        listFilteredChamp();
                        break;

                    case GET_ALL_CHAMPS_FROM_DB_JSON:

                        findAllChampJSON();
                        break;

                    case GET_CHAMPS_FROM_DB_BY_ID_JSON:

                        System.out.println("Please enter Champion ID: ");
                        String champID = keyboard.nextLine();
                        findChampByIDJSON(champID);
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
            } catch (DaoException e) {
                e.printStackTrace();
            }
        } while (option != EXIT);

        System.out.println("\nExiting Application, goodbye.");

    }


    //Feature 1 ArrayList
    private void initaialize(List list) {
        list.add(new Champ(1, "Warwick", "Jungler", "Zuan", 50.45, 2.96, 1.47, 5, 30, "A"));

        list.add(new Champ(2, "Skarner", "Jungler", "Shurima", 48.54, 11.2, 11.7, 34, 168, "D"));

        list.add(new Champ(3, "Garen", "TopLane", "Demacia", 59.95, 1.68, 3.66, 11, 40, "S"));

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
            } else if (c.getName() == c.name) {
                champTreeMap.put(c, c2);
            } else {
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

    //Feature 6
    public void displayTwoFieldQueue(PriorityQueue<Champ> twoFieldQueue) {
        while (!twoFieldQueue.isEmpty()) {
            System.out.println(twoFieldQueue.remove());
        }
    }

    //Feature 7
    public void findAllChamp() {
        ChampDaoInterface IChampDao = new MySQLChampDAO();
        try {
            System.out.println("\nCall findAllChamps()");
            List<org.example.DTOs.Champ> champs = IChampDao.findAllChamp();

            if (champs.isEmpty())
                System.out.println("There are no Champions");
            else {
                for (org.example.DTOs.Champ champ : champs)
                    System.out.println(champ.toString());
            }

        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    //Feature 8
    public void findChampByChampName(String name) {
        ChampDaoInterface IChampDao = new MySQLChampDAO();
        try {
            System.out.println("findChampByChampName()");
            org.example.DTOs.Champ champ = IChampDao.findChampByChampName(name);

            if (champ == null)
                System.out.println("No Champion exists with the name: " + name);
            else {
                System.out.println(champ);
            }

        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    //Feature 9
    public void deleteChampByID(int id) {
        ChampDaoInterface IChampDao = new MySQLChampDAO();
        try {
            System.out.println("deleteChampionByID()");
            org.example.DTOs.Champ champ = IChampDao.deleteChampByID(id);

            if (champ != null)
                if (champ != null)
                    System.out.println("Champion: with id " + id + " was found and deleted");
                else
                    System.out.println("Champion: " + id + " was not found");
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    //Feature 10
    public void addChampToDB() {
        ChampDaoInterface IChampDao = new MySQLChampDAO();

        int id = -1;
        String name = "";
        String mainRole = "";
        String region = "";
        double winRate = -1.0;
        double pickRate = -1.0;
        double banRate = -1.0;
        int roleRank = -1;
        int overAllRank = -1;
        String tier = "";
        Scanner kb = new Scanner(System.in);

        while (id < 1) {
            System.out.println("Please enter a new Champion ID: ");
            id = kb.nextInt();
        }
        ;

        while (name == "") {
            System.out.println("Please enter Champion Name: ");
            name = kb.nextLine();
        }
        ;

        while (mainRole == "") {
            System.out.println("Please enter Champion mainRole: ");
            mainRole = kb.nextLine();
        }
        ;

        while (region == "") {
            System.out.println("Please enter Champion home region: ");
            region = kb.nextLine();
        }
        ;

        while (winRate <= 0) {
            System.out.println("Please enter Champion winRate: ");
            winRate = kb.nextDouble();
        }
        ;

        while (pickRate <= 0) {
            System.out.println("Please enter Champion pickRate: ");
            pickRate = kb.nextDouble();
        }
        ;

        while (banRate <= 0) {
            System.out.println("Please enter Champion banRate: ");
            banRate = kb.nextDouble();
        }
        ;

        while (roleRank <= 0) {
            System.out.println("Please enter Champion roleRank: ");
            roleRank = kb.nextInt();
        }
        ;

        while (overAllRank <= 0) {
            System.out.println("Please enter Champion overAllRank: ");
            overAllRank = kb.nextInt();
        }
        ;

        while (tier == "") {
            System.out.println("Please enter Champion tier");
            tier = kb.nextLine();
        }

        try {
            IChampDao.addChamp(id, name, mainRole, region, winRate, pickRate, banRate, roleRank, overAllRank, tier);
            System.out.println("Added Successfully");
        } catch (DaoException e) {
            e.printStackTrace();
        }

    }

//    //Feature 11
//    public void listFilteredChamp() throws DaoException {
//
//        ChampDaoInterface IChampDao = new MySQLChampDAO();
//        Scanner kb = new Scanner(System.in);
//        BanRateComparator banRateComparator = new BanRateComparator(SortType.Ascending);
//        double banRate = 0.0;
//
//        System.out.println("Enter BanRate to filter above");
//        banRate = kb.nextDouble();
//
//        List<org.example.DTOs.Champ> champs = IChampDao.findChampUsingFilter(banRate, banRateComparator);
//        Collections.sort(champs, banRateComparator);
//
//        if (champs.isEmpty())
//            System.out.println("There are no Champions with a banRate above " + banRate);
//        else {
//            for (org.example.DTOs.Champ champ : champs)
//                System.out.println("Champion: " + champ.toString());
//        }
//
//    }

    //Feature 12
    public void findAllChampJSON() throws DaoException {
        try {
            ChampDaoInterface IChampDao = new MySQLChampDAO();
            System.out.println("\nCall findAllChampJSON()");
            String jsonString = IChampDao.findAllChampJSON();

            if (jsonString.equals("null"))
                System.out.println("No Champions found");
            else {
                System.out.println(jsonString);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }

    }

    //Feature 13
    public void findChampByIDJSON(String ChampID) throws DaoException {
        try {
            ChampDaoInterface IChampDao = new MySQLChampDAO();
            System.out.println("findChampionByIDJSON()");
            String jsonString = IChampDao.findAllChampByIDJSON(ChampID);

            if (jsonString.equals("null"))
                System.out.println("No Champion found");
            else {
                System.out.println(jsonString);
            }

        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

}