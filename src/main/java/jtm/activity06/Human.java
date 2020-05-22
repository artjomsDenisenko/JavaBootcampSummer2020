package jtm.activity06;

public class Human implements Humanoid {
    int birthWeight = Humanoid.BirthWeight;
    Integer contentOfstomach = 0;
    int stomachWeight = 0;
    int weight = birthWeight;
    boolean isAlive = true;

    @Override
    public void eat(Integer food) {
        contentOfstomach = food;
        stomachWeight = food;
        weight += food;
    }


    @Override
    public Integer vomit() {
        Integer toVomit = contentOfstomach;
        contentOfstomach = 0;
        weight -= stomachWeight;
        stomachWeight = 0;
        return toVomit;
    }

    @Override
    public String isAlive() {
        if (isAlive = true) return "Alive";
        else return "Dead";
    }

    @Override
    public String killHimself() {
        isAlive = false;
//        isAlive();
        return "Dead";
    }

    @Override
    public int getWeight() {
        weight = birthWeight + stomachWeight;
        return weight;
    }

    @Override
    public String toString() {
        return "Human: " + getWeight() + " [" + stomachWeight + "]";
    }

}
