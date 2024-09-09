package demo;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder
public class City {

    private String name;

    private ArrayList<Building> buildings;

    public void printBuildingsArea() {
        for (Building building : buildings) {
            double area = building.getTotalArea();
            System.out.println(building.getAddress() + " - " + area + "m2");
        }
    }
}
