package leetcode;

import java.util.List;

public class Problem_841_Keys_and_Rooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visitedRooms = new boolean[rooms.size()];

        visitedRooms[0] = true;
        DFS(rooms, visitedRooms, 0);

        //Check all the rooms visited by DFS.
        for(boolean isVisited: visitedRooms) {
            if(!isVisited) {
                return false;
            }
        }
        return true;
    }

    public void DFS(List<List<Integer>> rooms, boolean[] visitedRooms, int roomNumber) {
        for(int keyInRoom : rooms.get(roomNumber)) {
            if(!visitedRooms[keyInRoom]) {
                visitedRooms[keyInRoom] = true;
                DFS(rooms, visitedRooms, keyInRoom);
            }
        }
    }
}