package book;

import hotel.Hotel;
import hotel.type.RoomType;
import user.User;

public class BookingHandler {
    public static void book(User user, Hotel hotel, int roomNumber, int days) {
        RoomType roomType = hotel.getRoomType(roomNumber);
        if (user.isSmoker() && !roomType.allowSmoking()) {
            throw new IllegalArgumentException("Smoker user cannot book a room that does not allow smokers!");
        }

        hotel.bookRoom(roomNumber, days);
        double price = hotel.roomDailyRate(roomNumber) * days;
        user.withdraw(price);
    }

    public static void cancel(User user, Hotel hotel, int roomNumber) {
        double price = hotel.roomDailyRate(roomNumber) * hotel.daysBooked(roomNumber);
        hotel.releaseRoom(roomNumber);
        user.deposit(price * 0.7);
    }
}
