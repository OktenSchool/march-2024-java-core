package demo;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;

@Data
public class House extends Building {

    private static int COUNT = 123;

    // mutable
    private ArrayList<Room> rooms = new ArrayList<>();

    // immutable
    private final String name;

    public void delete() {
        System.out.println("House is deleting with its rooms");
        for (Room room : rooms) {
            room.delete();
        }
    }

    @Override
    public double getTotalArea() {
        double sum = 0;

        for (Room room : rooms) {
            sum += room.area();
        }

        return sum;
    }

    // Overload
    public void printAddress(boolean variable) {
        System.out.println("address of the house" + address);
    }

    public void printAddress(int variable) {
        System.out.println("address of the house" + address);
    }

    public void printAddress(long variable) {
        System.out.println("address of the house" + address);
    }
}
