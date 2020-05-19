package jtm.activity05;

import jtm.activity04.Road;
import jtm.activity04.Transport;

public class Ship extends Transport {
    protected byte sails;

    public Ship(String id, byte sails) {
        super(id, 0f, 0);
        this.sails = sails;
    }

    @Override
    public String move(Road road) {
    String shipMove = "";
    if(road instanceof WaterRoad){
        shipMove = super.getId()+ " Ship is sailing on " + road.toString() +
                " with " + sails + " sails";
    }else{
        shipMove = "Cannot sail on " + road.toString();
    }
    return shipMove;
}
}
