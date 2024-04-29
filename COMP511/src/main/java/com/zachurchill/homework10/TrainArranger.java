package com.zachurchill.homework10;

public class TrainArranger {
    public void arrange(TrainYard yard, Car [] ordering) {
        while (yard.frontOf(Track.INPUT) != null) {
            yard.move(Track.INPUT, Track.OUTPUT);
        }
        System.out.println(yard.toString());
    }
}

