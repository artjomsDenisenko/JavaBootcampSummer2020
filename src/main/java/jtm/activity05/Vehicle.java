package jtm.activity05;

import jtm.activity04.Road;
import jtm.activity04.Transport;

public class Vehicle extends Transport {
    protected int wheels;

    public Vehicle(String id, float consumption, int tankSize, int wheels) {
        super(id, consumption, tankSize);
        this.wheels = wheels;
    }

    @Override
    public String move(Road road) {
        String vehicleMove = "";
        if(road instanceof WaterRoad){
            vehicleMove = "Cannot drive on " + road.toString();
        }else{
            vehicleMove = super.getId() + " Vehicle is driving on " +
                    road.toString() + " with " + wheels + " wheels";
        }
        return vehicleMove;
    }
}
