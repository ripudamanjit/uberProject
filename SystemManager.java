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



public boolean cancelReq(int req){
	int adjReq=req-1;
	if(adjReq<0||adjReq>Services.size()){
		errMessage="invalid request";
		return false;

	}
     services temp = Services.remove(adjReq);
	 temp.getDriver().setStatus(drivers.Status.Available);
	 return true;

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



	public boolean existingRequest(services req) {
		for (services service : Services) {
			if (service.equals(req)) {
				return true;
			}
		}
		return false;
	}






	public boolean requestRide(String accountId, String from, String to)
	{
		if (accountId == null || accountId.isEmpty()) {
			System.out.println("Invalid User Account");
			return false;
		}
		if (from == null || from.isEmpty() || to == null || to.isEmpty()) {
			System.out.println("Invalid Address");
			return false;
		}

		User user = getUser(accountId);
		if (user == null) {
			System.out.println("User Account Not Found");
			return false;
		}


		int distance = cmap.distance(from, to);

		if (distance <= 1) {
			System.out.println("Insufficient Travel Distance");
			return false;
		}
		double ridecost = getRideCost(distance);
		if(user.getWallet()<ridecost) {
			errMessage= "Insufficient Funds";
			return false;
		}


		drivers driver = getAvailableDriver();
		if (driver == null) {
			System.out.println("No Drivers Available");
			return false;
		}


		Ride ride = new Ride(driver,from,to,user, distance, getRideCost(distance));

		if (existingRequest(ride)) {
			errMessage="User Already Has Ride Request";
			return false;
		}

		driver.setStatus(drivers.Status.Driving);

		Services.add(ride);



		return true;
	}






	public boolean requestDelivery(String accountId, String from, String to, String restaurant, String foodOrderId)
{
	if (accountId == null || accountId.isEmpty()) {
		System.out.println("Invalid User Account");
		return false;
	}
	if (from == null || from.isEmpty() || to == null || to.isEmpty()) {
		System.out.println("Invalid Address");
		return false;
	}
	if (restaurant == null || restaurant.isEmpty() || foodOrderId == null || foodOrderId.isEmpty()) {
		System.out.println("Invalid Restaurant or Food Order");
		return false;
	}

	User user = getUser(accountId);
	if (user == null) {
		System.out.println("User Account Not Found");
		return false;
	}


	int distance = cmap.distance(from, to);

	drivers driver = getAvailableDriver();
	if (driver == null) {
		System.out.println("No Drivers Available");
		return false;
	}

	Delivery delivery = new Delivery(driver, from, to,user, distance,getDeliveryCost(distance), restaurant, foodOrderId);

	if (existingRequest(user, restaurant, foodOrderId)) {
		System.out.println("User Already Has Delivery Request at Restaurant with this Food Order");
		return false;
	}

	driver.setStatus(drivers.Status.Driving);

	Services.add(delivery);

	

	return true;
}

public boolean dropOff(int req){
	int adjReq= req-1;
	if(adjReq<0||adjReq>Services.size()){
		errMessage="invalid req";
		return false;
	}

   services temp = Services.get(adjReq);
   double cost=temp.getCost();
   totalRevenue+=cost;
   double driverFee= cost*payRate;

   temp.getDriver().setWallet(temp.getDriver().getWallet()+driverFee);
   totalRevenue-=driverFee;
   temp.getDriver().setStatus(drivers.Status.Available);
   temp.getUser().deductWallet(driverFee);

   return true;
}










}
