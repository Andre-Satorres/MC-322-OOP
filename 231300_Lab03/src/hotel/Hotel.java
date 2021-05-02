package hotel;

import hotel.address.Address;
import hotel.type.RoomType;
import util.SystemUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Hotel {
    private final static int VIP_ROOM_AMOUNT = 10;
    private final static int ROOM_AMOUNT = 100;
    private final String name;
    private final Address address;
    private final String phone;
    private final RoomType vipRoomType;
    private final RoomType defaultRoomType;
    private final double vipDailyRate;
    private final double defaultDailyRate;
    private List<Room> rooms;

    public Hotel(String name, Address address, String phone, RoomType vipRoomType, RoomType defaultRoomType,
                 int vipDailyRate, int defaultDailyRate) {
        validateConstructorArgs(name, address, phone, vipRoomType, defaultRoomType, vipDailyRate, defaultDailyRate);

        this.name = name;
        this.phone = phone;
        this.address = address;
        this.vipRoomType = vipRoomType;
        this.defaultRoomType = defaultRoomType;
        this.vipDailyRate = vipDailyRate;
        this.defaultDailyRate = defaultDailyRate;
        initializeHotelRooms();
    }

    public List<Integer> availableRooms() {
        return rooms.stream().filter(room -> !room.isOccupied()).map(room -> rooms.indexOf(room)).collect(Collectors.toList());
    }

    public void bookRoom(int roomNumber, int days) {
        validateRoomNumber(roomNumber);
        if (!isAvailable(roomNumber)) {
            throw new IllegalArgumentException("Cannot book room: occupied!");
        }

        this.rooms.get(roomNumber).book(days);
    }

    public void releaseRoom(int roomNumber) {
        validateRoomNumber(roomNumber);
        if (isAvailable(roomNumber)) {
            throw new IllegalArgumentException("Cannot release room: not occupied!");
        }

        this.rooms.get(roomNumber).release();
    }

    public boolean isAvailable(int roomNumber) {
        return availableRooms().contains(roomNumber);
    }

    public int daysBooked(int roomNumber) {
        validateRoomNumber(roomNumber);
        if (isAvailable(roomNumber)) {
            throw new IllegalArgumentException("This room is not booked!");
        }

        return this.rooms.get(roomNumber).getDays();
    }

    public double roomDailyRate(int roomNumber) {
        return roomNumber < 10 ? vipDailyRate : defaultDailyRate;
    }

    public RoomType getRoomType(int roomNumber) {
        validateRoomNumber(roomNumber);
        return rooms.get(roomNumber).isVip() ? vipRoomType : defaultRoomType;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("\n");
        stringJoiner.add("Hotel: " + name);
        stringJoiner.add("Address: " + address);
        stringJoiner.add("Phone: " + phone);

        List<Integer> availableRooms = availableRooms();
        stringJoiner.add("Available rooms:");

        StringJoiner roomNumbers = new StringJoiner(", ");
        availableRooms.forEach(room -> roomNumbers.add(String.valueOf(room)));
        stringJoiner.add(roomNumbers.toString());
        stringJoiner.add("Total: " + availableRooms.size());

        stringJoiner.add("Vip Rooms: " + vipRoomType);
        stringJoiner.add("Default Rooms: " + defaultRoomType);

        return stringJoiner.toString();
    }

    private void validateRoomNumber(int roomNumber) {
        if (roomNumber < 0 || roomNumber > ROOM_AMOUNT) {
            throw new IllegalArgumentException("This room does not exist in this Hotel!");
        }
    }

    private void validateConstructorArgs(String name, Address address, String phone, RoomType vipRoomType, RoomType defaultRoomType, int vipRoomsAmount, int roomsAmount) {
        List<Map<String, String>> validations = new ArrayList<>(
                List.of(
                        Map.of("name", name),
                        Map.of("phone", phone)
                )
        );

        SystemUtils.validateStrings(validations, "hotel");

        if (address == null) {
            throw new IllegalArgumentException("Invalid hotel Address!");
        }

        if (vipRoomType == null) {
            throw new IllegalArgumentException("Invalid hotel vip room type!");
        }

        if (defaultRoomType == null) {
            throw new IllegalArgumentException("Invalid hotel default room type!");
        }

        if (vipRoomsAmount < 0) {
            throw new IllegalArgumentException("Invalid vip room amount!");
        }

        if (roomsAmount <= 0) {
            throw new IllegalArgumentException("Invalid room amount!");
        }

        if (vipRoomsAmount > roomsAmount) {
            throw new IllegalArgumentException("Vip Room amount cannot be greater then total rooms!");
        }
    }

    private void initializeHotelRooms() {
        rooms = new ArrayList<>();

        for (int i = 0; i < VIP_ROOM_AMOUNT; i++) {
            this.rooms.add(i, new Room(true));
        }

        for (int i = VIP_ROOM_AMOUNT; i < ROOM_AMOUNT; i++) {
            this.rooms.add(i, new Room(false));
        }
    }
}
