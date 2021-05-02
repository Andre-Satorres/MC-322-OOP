package hotel.address;

import util.SystemUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Address {
    private final String street;
    private final int number;
    private final String district;
    private final String city;
    private final String state;

    public Address(String street, int number, String district, String city, String state) {
        validateConstructorArgs(number, street, district, city, state);

        this.street = street;
        this.number = number;
        this.district = district;
        this.city = city;
        this.state = state;
    }

    private void validateConstructorArgs(int number, String street, String district, String city, String state) {
        List<Map<String, String>> validations = new ArrayList<>(
                List.of(
                        Map.of("street", street),
                        Map.of("district", district),
                        Map.of("city", city),
                        Map.of("state", state)
                )
        );

        SystemUtils.validateStrings(validations, "address");

        if (number < 0) {
            throw new IllegalArgumentException("Invalid address number!");
        }
    }

    @Override
    public String toString() {
        return "'" + street + ", " + number + ". " + district + " - " + city + "/" + state + "'";
    }
}
