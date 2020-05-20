package jtm.activity05;

import jtm.activity04.Road;
import jtm.activity04.Transport;

public class Vehicle extends Transport {
    protected int wheels;
    float fuelInTank;

    public Vehicle(String id, float consumption, int tankSize, int wheels) {
        super(id, consumption, tankSize);
        this.wheels = wheels;
    }

    @Override
    public String move(Road road) {
        String vehicleMove = "";
        if(road instanceof WaterRoad){

//                    = fuelInTank - road.getDistance()*consumption/100;
            vehicleMove = "Cannot drive on " + road.toString();
        }else{
        	super.move(road);
            vehicleMove = super.getId() + " Vehicle is driving on " +
                    road.toString() + " with " + wheels + " wheels";
        }
        return vehicleMove;
    }
}
