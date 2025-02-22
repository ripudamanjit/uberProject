import java.util.Scanner;

public class UI {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SystemManager obj = new SystemManager();

        System.out.println(">");

        while (sc.hasNextLine()) { 
            String action = sc.nextLine();

            if (action.isEmpty()) {
                System.out.println("\n");
                continue;
            } else if (action.equalsIgnoreCase("Q")) {
                System.out.println("Exiting...");
                System.exit(0);
            } else if (action.equalsIgnoreCase("Drivers")) {
                obj.listAllDrivers();
            } else if (action.equalsIgnoreCase("Requests")) {
                obj.listAllServices();
            } else if (action.equalsIgnoreCase("Register Drivers")) {
                System.out.println("Name:");
                String name = sc.nextLine();

                System.out.println("Car Model:");
                String carModel = sc.nextLine();

                System.out.println("License Plate:");
                String licensePlate = sc.nextLine();

                if (!obj.registerNewDriver(name, carModel, licensePlate)) {
                    System.out.println(obj.getErrorMessage());
                } else {
                    System.out.println("Saved Successfully!");
                }
            } 
            else if (action.equalsIgnoreCase("Register User")) {
                System.out.println("Name:");
                String name = sc.nextLine();

                System.out.println("Address");
                String Address = sc.nextLine();
                System.out.println("Wallet");

                double wallet = sc.nextInt();

              

                if (!obj.registerUser(name, Address,wallet)) {
                    System.out.println(obj.getErrorMessage());
                } else {
                    System.out.println("User Registered Successfully!");
                }
            }



                else if (action.equalsIgnoreCase("Request Ride")) {
                    System.out.print("User ID: ");
                    String userId = sc.nextLine();
    
                    System.out.print("Pickup Location: ");
                    String pickup = sc.nextLine();
    
                    System.out.print("Drop-off Location: ");
                    String dropOff = sc.nextLine();
    
                    if (!obj.requestRide(userId, pickup, dropOff)) {
                        System.out.println(obj.getErrorMessage());
                    } else {
                        System.out.println("Ride Requested Successfully!");
                    }
                } 
                else if (action.equalsIgnoreCase("Request Delivery")) {
                    System.out.print("User ID: ");
                    String userId = sc.nextLine();
    
                    System.out.print("Pickup Location: ");
                    String from = sc.nextLine();
    
                    System.out.print("Destination: ");
                    String to = sc.nextLine();
    
                    System.out.print("Restaurant: ");
                    String restaurant = sc.nextLine();
    
                    System.out.print("Food Order ID: ");
                    String foodOrderId = sc.nextLine();
    
                    if (!obj.requestDelivery(userId, from, to, restaurant, foodOrderId)) {
                        System.out.println(obj.getErrorMessage());
                    } else {
                        System.out.println("Delivery Requested Successfully!");
                    }

                } 
                else if (action.equalsIgnoreCase("Cancel Request")) {
                    System.out.print("Request Number: ");
                    int reqId = sc.nextInt();
                    sc.nextLine();
    
                    if (!obj.cancelReq(reqId)) {
                        System.out.println(obj.getErrorMessage());
                    } else {
                        System.out.println("Request Cancelled Successfully!");
                    }
                }

                else if (action.equalsIgnoreCase("Drop Off")) {
                    System.out.print("Request Number: ");
                    int reqId = sc.nextInt();
                    sc.nextLine();
    
                    if (!obj.dropOff(reqId)) {
                        System.out.println(obj.getErrorMessage());
                    } else {
                        System.out.println("Drop-Off Completed Successfully!");
                    }
                }




               
            else {
                System.out.println("Invalid command. Try again.");
            }
        }
    }
}
