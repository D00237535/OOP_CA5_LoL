package org.example;

public class Champ {
        int id;
        String name;
        String mainRole;
        double winRate ;
        double pickRate;
        double banRate;
        int roleRank;
        int overAllRank;
        char tier;


        public Champ(int id, String name, String mainRole, double winRate,
                     double pickRate, double banRate, int roleRank , int overAllRank, char tier) {
                this.id = id;
                this.name = name;
                this.mainRole = mainRole;
                this.winRate = winRate;
                this.pickRate = pickRate;
                this.banRate = banRate;
                this.roleRank = roleRank;
                this.overAllRank = overAllRank;
                this.tier = tier;

        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getMainRole() {
                return mainRole;
        }

        public void setMainRole(String mainRole) {
                this.mainRole = mainRole;
        }

        public double getWinRate() {
                return winRate;
        }

        public void setWinRate(double winRate) {
                this.winRate = winRate;
        }

        public double getPickRate() {
                return pickRate;
        }

        public void setPickRate(double pickRate) {
                this.pickRate = pickRate;
        }

        public double getBanRate() {
                return banRate;
        }

        public void setBanRate(double banRate) {
                this.banRate = banRate;
        }

        public int getRoleRank() {
                return roleRank;
        }

        public void setRoleRank(int roleRank) {
                this.roleRank = roleRank;
        }

        public int getOverAllRank() {
                return overAllRank;
        }

        public void setOverAllRank(int overAllRank) {
                this.overAllRank = overAllRank;
        }

        public char getTier() {
                return tier;
        }

        public void setTier(char tier) {
                this.tier = tier;
        }

//        @Override
//        public String toString() {
//                return "Champion{" +
//                        "Champion Id: " + id +
//                        ", Champion Name: " + name +
//                        ", Champion Role: " + mainRole +
//                        ", Champion's PickRate: " + pickRate +
//                        ", Champion's WinRate: " + winRate +
//                        ", Champion's BanRate: " + banRate +
//                        ", Champion's Rank in Main Role: " + roleRank +
//                        ", Champion's Rank OverAll: " + overAllRank +
//                        ", Champion's Tier: " + tier +
//                        '}';
//        }
}
