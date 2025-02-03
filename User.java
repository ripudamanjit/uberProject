import java.util.*;

public class User {
    String user_id;
    String name;
    String address;
    double wallet;
    int rides;
    int delivery;

    
    public User(String user_id, String name, String address,double wallet) {
        this.user_id = user_id;
        this.name = name;
        this.address = address;
        this.wallet = wallet;  
        this.rides = 0;  
        this.delivery = 0; 
    }

    
    public String getId() {
        return user_id;
    }

    public void setId(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public int getRides() {
        return rides;
    }

    public void setRides(int rides) {
        this.rides = rides;
    }

    public int getDelivery() {
        return delivery;
    }

    public void setDelivery(int delivery) {
        this.delivery = delivery;
       
    }

    
    public void infoUser() {
        System.out.println("User ID: " + user_id);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Wallet Balance: " + wallet);
        System.out.println("Total Rides: " + rides);
        System.out.println("Total Deliveries: " + delivery);
    }
    @Override
    public boolean equals(Object d2){
   if(this==d2){
    return true;
   }
   if(!(d2 instanceof User)){
    return false;
   }
     User obj = (User) d2;
     return this.name.equals(obj.name)&&this.address.equals(obj.address);
    }
     
    

    

    public static void main(String[] args) {
        User user1 = new User("1001", "Alice Johnson", "123 Main St, Toronto",55);
        User user2 = new User("1002", "Bob Smith", "456 Elm St, Vancouver",150);

        user1.setWallet(50.0);
        user1.setRides(5);
        user1.setDelivery(2);

        user2.setWallet(30.0);
        user2.setRides(3);
        user2.setDelivery(1);

        user1.infoUser();
        System.out.println();
        user2.infoUser();
    }
}

