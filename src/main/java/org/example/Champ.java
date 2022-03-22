package org.example;

import java.util.Comparator;

public class Champ implements Comparable<Champ> {

        int id;
        String name;
        String mainRole;
        String region;
        double winRate ;
        double pickRate;
        double banRate;
        int roleRank;
        int overAllRank;
        String tier;


        public Champ(int id, String name, String mainRole, String region, double winRate,
                     double pickRate, double banRate, int roleRank , int overAllRank, String tier) {
                this.id = id;
                this.name = name;
                this.mainRole = mainRole;
                this.region = region;
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

        public String getRegion() {
                return region;
        }

        public void setRegion(String region) {
                this.region = region;
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

        public String getTier() {
                return tier;
        }

        public void setTier(String tier) {
                this.tier = tier;
        }


        @Override
        public int compareTo(Champ c)
        {
                double ChampionWinRate = (this.getWinRate());
                double cChampWinRate = (c.getWinRate());

                boolean winRateComp =
                        ChampionWinRate == cChampWinRate;

                if (winRateComp)
                {
                        return 0;
                }
                else
                {
                        if (ChampionWinRate - cChampWinRate > 0)
                        {
                                return -1;
                        }
                        else
                        {
                                return 1;
                        }
                }
        }



        @Override
        public String toString() {
                return "Champion{" +
                        "Champion Id: " + id +
                        ", Champion Name: " + name +
                        ", Champion Role: " + mainRole +
                        ", Home Region: " + region +
                        ", Champion's PickRate: " + pickRate +
                        ", Champion's WinRate: " + winRate +
                        ", Champion's BanRate: " + banRate +
                        ", Champion's Rank in Main Role: " + roleRank +
                        ", Champion's Rank OverAll: " + overAllRank +
                        ", Champion's Tier: " + tier +
                        '}';
        }

}
