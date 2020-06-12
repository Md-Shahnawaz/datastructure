package com.test.amazon;

public class TreasureIsland {
    private static int minRoute = Integer.MAX_VALUE;
    public static void main(String[] args) {

        char[][] map = new char[][]{{'O', 'O', 'O', 'O'},
                                    {'D', 'O', 'D', 'O'},
                                    {'O', 'O', 'O', 'O'},
                                    {'X', 'D', 'D', 'O'}};
        dfs(map, 0, 0,0);
        System.out.println(minRoute);
    }

    public static void dfs(char[][] map, int route, int i, int j){

        if(!isPossible(map, i, j)){
            return;
        }

        if(map[i][j] == 'X'){
            minRoute = Math.min(minRoute, route);
            return;
        }

        map[i][j] = 'D';
        dfs( map, route + 1, i, j + 1);
        dfs( map, route + 1, i, j - 1);
        dfs( map, route + 1, i + 1, j);
        dfs( map, route + 1, i - 1, j);
        map[i][j] = 'O';

    }

    private static boolean isPossible(char[][] map, int i, int j){
        return i >= 0 && i < map.length && j >= 0 && j < map[0].length && (map[i][j] == 'O' || map[i][j] == 'X');
    }

}
