import java.util.*;


public class SystemManager {
	ArrayList<User> users;
	ArrayList<drivers>Drivers;
	ArrayList<services> Services;
	double totalRevenue;


	int user_id=9000;
	int driver_id=7000;

	double perUnitDelivery=1.2;
	double perUnitRides=1.5;
	double payRate=0.1;


	String errMessage=null;
	public SystemManager() {
		this.users=new ArrayList<User>();
		this.Drivers= new ArrayList<drivers>();
		this.Services= new ArrayList<services>();
		registration.predefinedUser(users);
		registration.predefinedDriver(Drivers);
		this.totalRevenue=0;
	}

	public String getErrorMessage() {
		return this.errMessage;
	}


	public User getUser(String accountId)
	{
		for (User user : users) {
			if (user.getId().equals(accountId)) {
				return user;
			}
		}
		return null;

	}

	private boolean userExists(User user)
	{
		for (User existingUser : users) {
			if (existingUser.equals(user)) {
				return true;
			}
		}
		return false;
	}


	private boolean existingRequest(User user,String restaurant, String foodOrderId)
	{
		for (services service : Services) {
			if (service instanceof Delivery) {
				Delivery delivery = (Delivery) service;
				if (delivery.getUser().equals(user) &&
				        delivery.getRestaurant().equals(restaurant) &&
				        delivery.getFoodOrderID().equals(foodOrderId)) {
					return true;
				}
			}
		}

		return false;
	}







    public drivers getDriver(String accountId) {
        for (drivers driver : Drivers) {
            if (driver.getId().equals(accountId)) {
                return driver;
            }
        }
        return null;
    }
    
    private boolean driverExists(drivers driver) {
        for (drivers existingDriver : Drivers) {
            if (existingDriver.equals(driver)) {
                return true;
            }
        }
        return false;
    }
    
   
    

}
