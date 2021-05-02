package hotel.type;

import java.util.StringJoiner;

public class RoomType {
    private final boolean allowSmoking;
    private final boolean hasAC;

    public RoomType(boolean allowSmoking, boolean hasAC) {
        this.allowSmoking = allowSmoking;
        this.hasAC = hasAC;
    }

    public boolean allowSmoking() {
        return allowSmoking;
    }

    @Override
    public String toString() {
        String negative = "doesn't ";
        StringJoiner ret = new StringJoiner(", ");

        String now = "allow smoking";
        ret.add(allowSmoking ? now : negative + now);

        now = "has a/c";
        ret.add(hasAC ? now : negative + now);

        return "{" + ret + "}";
    }
}
