package com.zachurchill.homework10;

public class TrainArranger {
    public void arrange(TrainYard yard, Car [] ordering) {
        int nextCarIndex = 0;
        while (nextCarIndex < ordering.length) {
            Track from = yard.containsCar(Track.INPUT, ordering[nextCarIndex]) ? Track.INPUT : Track.SIDING;
            Track holding = from == Track.INPUT ? Track.SIDING : Track.INPUT;
            if (yard.frontOf(from).equals(ordering[nextCarIndex])) {
                yard.move(from, Track.OUTPUT);
                ++nextCarIndex;
            } else {
                yard.move(from, holding);
            }
        }
        System.out.println(yard.toString());
    }
}

