class Ride extends services {

    public static final String TypeName = "Ride";

    public Ride(drivers driver, String from, String to, User user, int distance, double cost) {
        super(driver, from, to, user, TypeName, distance, cost);
    }

    
    public String getServiceType() {
        return TypeName;
    }
}
