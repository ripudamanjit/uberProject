import java.sql.Driver;
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
		return errMessage;
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

	public double getDeliveryCost(int dist) {
		return perUnitDelivery*dist;

	}
	public double getRideCost(int dist) {
		return perUnitRides*dist;

	}



	public drivers getAvailableDriver() {
		for (drivers driver : Drivers) {
			if(driver.getStatus().equals(drivers.Status.Available)) {
				return driver;
			}
		}

		return null;
	}
	public void listAllUsers() {

		System.out.println("---- List of Users ----");
		for (User user : users) {
			user.infoUser();
			System.out.println("----------------------");
		}
	}



	public void listAllDrivers() {

		System.out.println("---- List of Drivers ----");
		for (drivers driver : Drivers) {
			driver.getInfo();
			System.out.println("----------------------");
		}
	}


	public void listAllServices() {

		System.out.println("---- List of Services ----");
		for (services service : Services) {
			service.PrintInfo();
			System.out.println("----------------------");
		}
	}





	public boolean registerUser(String name, String address, Double wallet) {

		if (name == null || name.isEmpty() ||
		        address == null || address.isEmpty() ||
		        wallet == null || wallet < 0) {

			errMessage = "Invalid user";
			return false;
		}


		User tempUser = new User(registration.genUserID(users), name, address, wallet);

		if (userExists(tempUser)) {
			errMessage = "User already exists";
			return false;
		}


		users.add(tempUser);


		System.out.println("User registered successfully:");

		return true;
	}







	public boolean registerNewDriver(String name, String carModel, String carLicencePlate)
	{
		if (name == null || name.isEmpty()) {
			errMessage= "Invalid Driver Name";
			return false;
		}
		if (carModel == null || carModel.isEmpty()) {
			errMessage = "Invalid Car Model";
			return false;
		}
		if (carLicencePlate == null || carLicencePlate.isEmpty()) {
			errMessage = "Invalid Car Licence Plate";
			return false;
		}
		String accountId = registration.genDriverID(Drivers);
		drivers newDriver = new drivers(accountId, name, carModel, carLicencePlate);
		if (driverExists(newDriver)) {
			errMessage = "Driver Already Exists in System";
			return false;
		}
		Drivers.add(newDriver);
		driver_id++;
		return true;
	}
	public String getUsernameFromId(String accountId)
	{
		for(User user : users) {
			if(user.getId().equals(accountId)) {
				return user.getName();
			}

		}
		return null;
	}





}
