import hotel.Hotel;
import hotel.address.Address;
import hotel.type.RoomType;
import io.KeyboardIO;
import user.Gender;
import user.User;

import java.util.Date;
import java.util.GregorianCalendar;

import static book.BookingHandler.*;

public class Booking {

    public static void main(String[] args) {
        KeyboardIO keyboardIO = new KeyboardIO();
        keyboardIO.welcomeMessage();

        RoomType vipType = new RoomType(true, true);
        RoomType defaultType = new RoomType(false, false);

        Address addH1 = new Address("Rua Dr Jose Coelho", 708, "Bonfim", "Campinas", "SP");
        Hotel hotel1 = new Hotel("Hotel Plaza", addH1, "5533423242", vipType, defaultType, 100, 900);

        Address addH2 = new Address("Avenida das Flores", 554, "Jardim Vitoria", "Poços de Caldas", "MG");
        Hotel hotel2 = new Hotel("Hotel das Caldas", addH2, "556535536553", vipType, defaultType, 50, 2000);

        Address addH3 = new Address("Fim do mundo", 65, "Raffard", "Raffard", "SP");
        Hotel hotel3 = new Hotel("Hotel dos Desejos", addH3, "556535533433", vipType, defaultType, 20, 200);

        User andre = new User("Andre", "54523453424", getDate(1, 8, 2002), Gender.MALE, 4000.0, false);
        User gabriela = new User("Gabriela", "54635655345", getDate(25, 1, 2002), Gender.FEMALE, 300.0, false);
        User diaz = new User("Diaz", "54645455345", getDate(27, 6, 2002), Gender.NO_ANSWER, 30000.0, true);
        User yesenia = new User("Yesenia", "54677755345", getDate(4, 9, 1978), Gender.NON_BINARY, -200.0, true);

        keyboardIO.display(andre);
        keyboardIO.display(gabriela);
        keyboardIO.display(diaz);
        keyboardIO.display(yesenia);

        keyboardIO.display(hotel1);
        keyboardIO.display(hotel2);
        keyboardIO.display(hotel3);

        keyboardIO.display("--------------------------------------------------");

        try {
            book(andre, hotel1, 7, 4);
            book(andre, hotel2, 76, 5);
            book(gabriela, hotel2, 99, 5);
            //book(diaz, hotel2, 99, 5);
            book(diaz, hotel3, 6, 5);
            book(yesenia, hotel3, 7, 5);
            keyboardIO.display(hotel1);
            keyboardIO.display(hotel2);
            keyboardIO.display(hotel3);

            cancel(andre, hotel1, 7);
            cancel(andre, hotel1, 89);
            cancel(gabriela, hotel2, 99);
            cancel(diaz, hotel2, 99);
            cancel(diaz, hotel3, 99);

            book(yesenia, hotel1, 7, 6);
            cancel(yesenia, hotel1, 7);
        } catch (IllegalArgumentException ex) {
            keyboardIO.errorMessage(ex);
        }

        keyboardIO.display("--------------------------------------------------");

        keyboardIO.display(hotel1);
        keyboardIO.display(hotel2);
        keyboardIO.display(hotel3);

        keyboardIO.exit();
    }

    private static Date getDate(int day, int month, int year) {
        return new GregorianCalendar(year, month, day).getTime();
    }
}
