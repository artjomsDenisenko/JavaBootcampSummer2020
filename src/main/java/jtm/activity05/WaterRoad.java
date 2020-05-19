package jtm.activity05;

import java.util.Locale;

import jtm.activity04.Road;

public class WaterRoad extends Road {

    public WaterRoad(String from, String to, int distance) {
        super(from, to, distance);
    }

    public WaterRoad() {
    }

    @Override
    public String toString() {
        return "WaterRoad " + super.getFrom() +" — " + super.getTo() +", " +
                super.getDistance() + "km";
    }

}
