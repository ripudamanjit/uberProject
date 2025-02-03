import java.util.*;

public class registration {
    
    static int userId = 1000 - 1;
    static int driverId = 7000 - 1;
    static int userCount = 0;
    static int driverCount = 0;

    public static String genUserID(ArrayList<User> curr) {
        userCount++;
        return String.valueOf(userId + userCount);
    }

    public static String genDriverID(ArrayList<drivers> curr) {
        driverCount++;
        return String.valueOf(driverId + driverCount);
    }

    public static void predefinedUser(ArrayList<User> users) {
        users.add(new User(genUserID(users), "McInerney, T.", "34 5th Street", 25));
        users.add(new User(genUserID(users), "Valenzano, R.", "71 1st Street", 55));
        users.add(new User(genUserID(users), "Lugez, E.", "55 9th Avenue", 125));
        users.add(new User(genUserID(users), "Miranskyy, A.", "15 2nd Avenue", 15));
        users.add(new User(genUserID(users), "Raman, P.", "32 3rd Street", 13));
        users.add(new User(genUserID(users), "Woungang, I.", "64 6th Avenue", 27));
        users.add(new User(genUserID(users), "Soutchanski, M.", "28 7th Avenue", 22));
        users.add(new User(genUserID(users), "Harley, E.", "10 7th Avenue", 34));
        users.add(new User(genUserID(users), "Mason, D.", "48 8th Street", 11));
        users.add(new User(genUserID(users), "Santos, M.", "83 4th Street", 41));
    }

    public static void predefinedDriver(ArrayList<drivers> drivers) {

        drivers.add(new drivers(genDriverID(drivers), "Tom Cruise", "Toyota Corolla", "MAVERICK", "34 4th Street"));
        drivers.add(new drivers(genDriverID(drivers), "Brad Pitt", "Audi S4", "FGDR 983", "85 8th Street"));
        drivers.add(new drivers(genDriverID(drivers), "Millie Brown", "Tesla", "STRNGRTHGS", "67 9th Avenue"));
        drivers.add(new drivers(genDriverID(drivers), "Tim Chalamet", "Thopter", "DUNE", "21 8th Avenue"));
        drivers.add(new drivers(genDriverID(drivers), "John Boyega", "X-Wing", "REBEL", "32 7th Avenue"));
    }
}
