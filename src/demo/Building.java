package demo;

import lombok.Data;

@Data
public abstract class Building {

    protected String address;

    public abstract double getTotalArea();

    public final void printAddress() {
        System.out.println(address);
    }
}
