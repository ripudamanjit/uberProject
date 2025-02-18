import java.util.*;

public class drivers {
    String driver_id; 
    String name; 
    String carModel; 
    String licensePlate; 
    double wallet;
      
    public static enum Status{Available,Driving};
  private Status status;


    public drivers(String driver_id, String name, String carModel, String licensePlate) {
        this.driver_id = driver_id;
        this.name = name; 
        this.carModel = carModel; 
        this.licensePlate = licensePlate; 
        this.wallet = 0;
        this.status= Status.Available;
    }

    public Status getStatus(){
     return status;
    }

    
    public String getId() {
        return driver_id;
    }

    public void setID(String id) {
        this.driver_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getLicensePlate() {  // Fixed incorrect method signature
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }


    public void getInfo() {
        System.out.println("Driver ID: " + driver_id);
        System.out.println("Name: " + name);
        System.out.println("Car Model: " + carModel);
        System.out.println("License Plate: " + licensePlate);
        System.out.println("Wallet Balance: $" + wallet);
        System.out.println("----------------------------------");
    }

    @Override
    public boolean equals(Object d2) {
        if (this == d2) {
            return true;
        }
        if (!(d2 instanceof drivers)) {
            return false;
        }
        drivers obj = (drivers) d2;
        return this.name.equals(obj.name) && this.licensePlate.equals(obj.licensePlate);
    }


    public void pay(double fee){
        this.wallet= wallet+fee;
    }

    public boolean isAvailable(){
        return status==Status.Available;
    }


    public void setStatus(Status available) {
        if(available==Status.Available){
            this.status=Status.Available;
        }
        else{
            this.status=Status.Driving;
        }
    }


    public static void main(String args[]) {
        drivers driver1 = new drivers("7001", "Tom Cruise", "Toyota Corolla", "ABC1234");
        drivers driver2 = new drivers("7002", "Brad Pitt", "Audi S4", "XYZ5678");
        drivers driver3 = new drivers("7003", "Tom Cruise", "Toyota Corolla", "ABC1234");

        System.out.println(driver1.getId());
        System.out.println(driver1.getLicensePlate());
        driver1.setCarModel("Toyota Innova");
        System.out.println(driver1.getCarModel());

        driver1.getInfo();

        System.out.println(driver1.equals(driver3));
    }
}
