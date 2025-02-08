class Delivery extends services {

    public static final String TypeName = "Delivery";
    private String restaurant;
    private String foodOrderID;

    public Delivery(drivers driver, String from, String to, User user, int distance, double cost, String restaurant, String foodOrderID) {
        super(driver, from, to, user, TypeName, distance, cost);
        this.restaurant = restaurant;
        this.foodOrderID = foodOrderID;
    }

    
    public String getServiceType() {
        return TypeName;
    }

    
    public String getRestaurant() {
        return restaurant;
    }

    public String getFoodOrderID() {
        return foodOrderID;
    }

    
    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public void setFoodOrderID(String foodOrderID) {
        this.foodOrderID = foodOrderID;
    }

    
}
