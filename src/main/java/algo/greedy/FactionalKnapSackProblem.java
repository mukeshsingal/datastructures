package algo.greedy;

import java.util.ArrayList;
import java.util.Collections;

public class FactionalKnapSackProblem {

    static class Item implements Comparable<Item>{
        double profit;
        double weight;
        String name;

        Item(double profit, double weight, String name) {
            this.profit = profit;
            this.weight = weight;
            this.name = name;
        }

        @Override
        public int compareTo(Item i) {
            return (int) ((i.profit / i.weight) - (this.profit / this.weight));
        }
    }

    static public double getMaxValue(ArrayList<Item> items, int bagSize ) {
        Collections.sort(items);
        int currentBagSize = 0;
        double profit = 0;

        for (Item item : items) {
            for(int i = 1; i <= item.weight; i++) {
                if(currentBagSize < 15) {
                    currentBagSize++;
                    profit = profit + item.profit / item.weight;
                }
                else {
                    break;
                }
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();

        items.add(new Item(10, 2, "A"));
        items.add(new Item(5, 3, "B"));
        items.add(new Item(15, 5, "C"));
        items.add(new Item(7, 7, "D"));
        items.add(new Item(6, 1, "E"));
        items.add(new Item(18, 4, "F"));
        items.add(new Item(3, 1, "G"));

        System.out.println(getMaxValue(items, 15));
    }
}
