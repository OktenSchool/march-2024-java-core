package demo;

import java.io.Serializable;

// class may implement as many interfaces as you want
public class OilChange implements Repair, Job {

    @Override
    public void perform() {
        System.out.println("Oil change");
    }

    @Override
    public double getPrice() {
        return 9.99;
    }
}
