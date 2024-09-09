import demo.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final Double PI = 3.14159;

    private static Double E = 2.1;

    static {
        E = 1.23;
        new Unused();
        System.out.println("PI value is " + PI);
        E = 32.123;
    }

    {

    }

    public Main() {

    }

    public Main(String var) {

    }

    public static void main(String[] args) {
        House house = new House("будинок 123");

        Room livingRoom = new Room(RoomType.LIVING_ROOM, 32.2);
        Room kitchen = Room.builder()
                .type(RoomType.KITCHEN)
                .build();

        house.getRooms().add(livingRoom);
        house.getRooms().add(kitchen);

        System.out.println(house);
        check(house);
        System.out.println(house);

        University university = University.builder()
                .area(8237)
                .build();

        ArrayList<Building> buildings = new ArrayList<>();
        buildings.add(house);
        buildings.add(university);
        City city = City.builder()
                .name("Lviv")
                .buildings(buildings)
                .build();
        System.out.println(city);
        city.printBuildingsArea();
    }

    public static void check(House house) {
        for (Room room : house.getRooms()) {
            if (room.type().isCanHaveSofa()) {
                System.out.println("Sofa can be placed at " + room.type());
                System.out.println(room.type().ordinal());
                System.out.println(room.type().name());
            }
        }
    }
}