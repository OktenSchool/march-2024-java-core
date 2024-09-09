package demo;

import lombok.Data;
import lombok.Getter;

// immutable
@Getter
public enum RoomType {

    LIVING_ROOM(true),
    BEDROOM(true),
    KITCHEN(false),
    BATHROOM(false);

    private final boolean canHaveSofa;

    RoomType(boolean canHaveSofa) {
        this.canHaveSofa = canHaveSofa;
    }
}
