package com.test.amazon;

import java.util.ArrayList;
import java.util.List;

public class NoOfGoStore {

    public static void main(String[] args) {
        List<List<Integer>> in = new ArrayList<>();
        List<Integer> i1 = new ArrayList<>();

        i1.add(1);
        i1.add(1);
        i1.add(0);
        i1.add(0);
        List<Integer> i2 = new ArrayList<>();
        i2.add(0);
        i2.add(0);
        i2.add(1);
        i2.add(0);

        List<Integer> i3 = new ArrayList<>();
        i3.add(0);
        i3.add(0);
        i3.add(0);
        i3.add(0);

        List<Integer> i4 = new ArrayList<>();
        i4.add(1);
        i4.add(0);
        i4.add(1);
        i4.add(1);
        List<Integer> i5 = new ArrayList<>();
        i5.add(1);
        i5.add(1);
        i5.add(1);
        i5.add(1);

        in.add(i1);
        in.add(i2);
        in.add(i3);
        in.add(i4);
        in.add(i5);
        System.out.println(new NoOfGoStore().numberAmazonGoStores(5, 4, in));
    }

    int numberAmazonGoStores(int rows, int column, List<List<Integer>> grid)
    {
        int stores = 0;
        for (int i = 0; i < grid.size() ; i++) {
            List<Integer> list = grid.get(i);
            for (int j = 0; j < list.size() ; j++) {
                if(dfs(grid, i, j)){
                    stores += 1;
                }
            }
        }
        return stores;
    }

    private boolean dfs(List<List<Integer>> store, int i, int j){

        if(!isPossible(store, i, j)){
            return false;
        }

        store.get(i).set(j, 0);
        dfs(store, i, j + 1);
        dfs(store, i, j - 1);
        dfs(store, i + 1, j);
        dfs(store, i - 1, j);

        return true;

    }

    private boolean isPossible(List<List<Integer>> store, int i, int j) {
        return i >= 0 && i < store.size() && j >= 0 && j < store.get(0).size() && store.get(i).get(j) == 1;
    }
}
