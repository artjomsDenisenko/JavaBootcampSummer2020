package jtm.activity05;

import jtm.activity04.Road;
import jtm.activity04.Transport;

public class Amphibia extends Transport {
    private int wheels;
    private byte sails;

    public Amphibia(String id, float consumption, int tankSize, byte sails, int wheels) {
        super(id, consumption, tankSize);
        this.wheels = wheels;
        this.sails = sails;
    }

    @Override
    public String move(Road road) {
        String amphMove = "";
        if(road instanceof WaterRoad){
            amphMove = super.getId() + " Amphibia is sailing on " + road.toString() +
                    " with " + sails + " sails";
        }else{
            amphMove = super.getId() + " Amphibia is driving on " + road.toString() +
                    " with " + wheels + " wheels";
        }
        return amphMove;
    }

}
