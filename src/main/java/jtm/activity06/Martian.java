package jtm.activity06;

public class Martian implements Alien, Humanoid, Cloneable {
    int birthWeight = Alien.BirthWeight;
    Object contentOfstomach = null;
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
    public void eat(Object item) {
        if(item instanceof Human){
            contentOfstomach = ((Human) item).toString();
        	stomachWeight = ((Human) item).getWeight();
            weight += stomachWeight;
            ((Human) item).killHimself();
        }else if (item instanceof Martian) {
            contentOfstomach = ((Martian) item).toString();
        	stomachWeight = ((Martian) item).getWeight();
            ((Martian) item).killHimself();
            weight += stomachWeight;
        }
    }

    @Override
    public Object vomit() {
        Object toVomit = contentOfstomach;
        contentOfstomach = null;
        weight -= stomachWeight;
        stomachWeight = 0;
        return toVomit;
    }

    @Override
    public int getWeight() {
        weight = birthWeight + stomachWeight;
        return weight;
    }

    @Override
    public String isAlive() {
        return "I AM IMMORTAL!";
    }

    @Override
    public String killHimself() {
        return "I AM IMMORTAL!";
    }

    @Override
    public String toString() {
        return "Martian: " + weight + " [" + contentOfstomach + "]";
    }

    /*
     * Implementation of Object clone() method for Cloneable interface
     * @see https://docs.oracle.com/javase/7/docs/api/java/lang/Cloneable.html
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return clone(this);
    }

    private Object clone(Object current) throws CloneNotSupportedException {
        // TODO implement cloning of current object
        // and its stomach
        Object clonedStomach = new Object();
        clonedStomach.equals(contentOfstomach);
        
        Martian copy = new Martian();
        copy.birthWeight = Alien.BirthWeight;
        copy.contentOfstomach = clonedStomach;
        copy.stomachWeight = this.stomachWeight;
        copy.weight = birthWeight + stomachWeight;

        return copy;
  

    }


}