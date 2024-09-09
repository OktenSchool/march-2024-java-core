package demo;

import lombok.Builder;
import lombok.Data;

@Builder
public record Room(
        RoomType type,
        double area
) {

    public void delete() {
        System.out.println("Delete room");
    }
}
