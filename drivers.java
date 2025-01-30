
import java.util.*;

public class drivers {
    String user_id ; 
    String name ; 
    String carModel; 
    String licensePlate ; 
    double wallet;

    public drivers(String user_id ,String name ,String carModel,String licensePlate ){
    this.user_id=user_id;
    this.name=name ; 
    this.carModel=carModel; 
    this.licensePlate=licensePlate ; 
    this.wallet=0;
    }

    public String getId(){
        return user_id;
    }
    public void setID(String id){
        this.user_id=id;
        
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getCarModel(){
        return carModel;
    }
    public void setCarModel(String carModel){
        this.carModel=carModel;
    }
    public String getLicensePlate(String licensePlate){
        return licensePlate;
    }
    public void setLicensePlate(String licensePlate){
        this.licensePlate=licensePlate;
    }
    public double getWallet(){
        return wallet;
    }
    public void setWallet(double wallet){
        this.wallet=wallet;
    }
    public void getInfo() {
        System.out.println("Driver ID: " + user_id);
        System.out.println("Name: " + name);
        System.out.println("Car Model: " + carModel);
        System.out.println("License Plate: " + licensePlate);
        System.out.println("Wallet Balance: $" + wallet);
        System.out.println("----------------------------------");
    }

    @Override
    public boolean equals(Object d2){
   if(this==d2){
    return true;
   }
   if(!(d2 instanceof drivers)){
    return false;
   }
   drivers obj = (drivers) d2;
     return this.name.equals(obj.name)&&this.licensePlate.equals(obj.licensePlate);
    }
     
    

    

public static void main(String args[]){

 drivers driver1 = new drivers("7001", "Tom Cruise", "Toyota Corolla", "ABC1234");
 drivers driver2 = new drivers("7002", "Brad Pitt", "Audi S4", "XYZ5678");
 drivers driver3 = new drivers("7003", "Tom Cruise", "Toyota Corolla","ABC1234");
System.out.println(driver1.getId());
System.out.println(driver1.licensePlate);
driver1.setCarModel("Toyota inova");
System.out.println(driver1.carModel);

driver1.getInfo();


System.out.println(driver1.equals(driver3));




}

}



