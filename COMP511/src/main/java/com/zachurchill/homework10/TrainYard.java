package com.zachurchill.homework10;

import java.util.ArrayList;

/**
 * No changes to this file. It will be replaced
 * when the instructor tests run.
 */
public class TrainYard {
    private ArrayList<Move> moves;
    private Rail input;
    private Rail output;
    private Rail siding;
    
    
    public TrainYard(int [] cars) {
        moves = new ArrayList<Move>();
        input = new Rail("Input");
        output = new Rail("Output");
        siding = new Rail("Siding");
        
        for (int i = 0; i < cars.length; ++i) {
            input.push(new Car(cars[i]));
        }
    }

    private Rail trackFor(Track t) {
        Rail result = null;
        switch (t) {
            case INPUT: result = input; break;
            case OUTPUT: result = output; break;
            case SIDING: result = siding; break;
        }
        return result;
    }
    
    public boolean containsCar(Track track, Car car) {
        //System.out.printf("Looking for %s on track %s\n", car.toString(),
        //    trackFor(track).getName());
        boolean result = trackFor(track).containsCar(car);
        //System.out.printf("%s\n", result ? "found!" : "not there.");
        return result;
    }

    public Car frontOf(Track track) {
        if (trackFor(track).isEmpty()) {
            return null;
        }
        return trackFor(track).peek();
    }

    public void move(Track from, Track to) {
        moves.add(new Move(trackFor(from), trackFor(to)));
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Track t : Track.values()) {
            builder.append(String.format(
                "%6s: %s%n", t, trackFor(t)));
        }
        builder.append(getMoves());
        return builder.toString();
    }
    
    public Rail getOutputRail() {
        return output;
    }
    
    private String getMoves() {
        if (moves.isEmpty()) {
            return "";
        }
        int count = 1;
        StringBuilder builder = new StringBuilder();
        builder.append("Moves so far:\n");
        for (Move m : moves) {
            builder.append(String.format("  %2d. %s%n",
                count++, m));
        }
        return builder.toString();
    }
    
    private static class Move {
        Rail from;
        Rail to;
        Car car;

        public Move(Rail from, Rail to) {
            this.from = from;
            this.to = to;
            this.car = from.pop();
            to.push(this.car);
        }

        public String toString() {
            return String.format("Move %s from %s to %s",
                car, from.getName(), to.getName());
        }
    }
}
