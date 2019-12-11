package Nov_31_10;
/*
Given an array of time intervals (start, end) for classroom lectures (possibly overlapping),
        find the minimum number of rooms required.
        For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.

*/


import common.Lectures;
import common.Room;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinimumRooms {

    /*
    Sort the given rooms in ascending order based on the start time
    0,50 30, 75 60,150
    ArrayList rooms == r1, r2, ...

     */

    public static void main(String args[]) {

        MinimumRooms minimumRooms = new MinimumRooms();
        List<Lectures> list = new ArrayList<>();

        Lectures lectures1 = new Lectures(0, 50);
        Lectures lectures2 = new Lectures(30, 75);
        Lectures lectures3 = new Lectures(60, 150);

        list.add(lectures1);
        list.add(lectures2);
        list.add(lectures3);

        System.out.println(minimumRooms.findMinimumRoomsRequired(list));


    }

    public int findMinimumRoomsRequired(List<Lectures> lectures) {
        if (lectures == null || lectures.size() == 0) {
            return 0;
        }
        ArrayList<Room> listOfRooms = new ArrayList<Room>();

        Collections.sort(lectures, new Comparator<Lectures>() {
            @Override
            public int compare(Lectures o1, Lectures o2) {
                return o1.getStart() - o2.getStart();
            }
        });


        label:
        for (Lectures lectures1 : lectures) {
            int start = lectures1.getStart();
            int end = lectures1.getEnd();
            if (listOfRooms.isEmpty()) {
                listOfRooms.add(new Room(start, end));
            } else {
                for (Room room : listOfRooms) {
                    if (room.getEnd() < start) {
                        room.setStart(start);
                        room.setEnd(end);
                        continue label;
                    }
                }
                listOfRooms.add(new Room(start, end));
            }
        }

        return listOfRooms.size();
    }
}
