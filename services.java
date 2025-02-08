import java.util.*;


abstract public class services implements Comparable<services> {
drivers driver;
String from;
String to;
User user;
String type;
int distance;
double cost;

public services(drivers driver, String from, String to, User user, String type, int distance, double cost) {
        this.driver = driver;
        this.from = from;
        this.to = to;
        this.user = user;
        this.type = type;
        this.distance = distance;
        this.cost = cost;
    }

abstract public String getServiceType();
    
public drivers getDriver() {
    return driver;
}

public String getFrom() {
    return from;
}

public String getTo() {
    return to;
}

public User getUser() {
    return user;
}



public int getDistance() {
    return distance;
}

public double getCost() {
    return cost;
}


public void setDriver(drivers driver) {
    this.driver = driver;
}

public void setFrom(String from) {
    this.from = from;
}

public void setTo(String to) {
    this.to = to;
}

public void setUser(User user) {
    this.user = user;
}


public void setDistance(int distance) {
    this.distance = distance;
}

public void setCost(double cost) {
    this.cost = cost;
}

@Override
    public int compareTo(services other) {
        
        return Integer.compare(this.distance, other.distance);
}

public void PrintInfo() {
    System.out.println("Service Type: " + getServiceType());
    System.out.println("Driver: " +driver.getName());
    System.out.println("From: " + from);
    System.out.println("To: " + to);
    System.out.println("User: " +  user.getName());
    System.out.println("Distance: " + distance + " km");
    System.out.println("Cost: $" + cost);
}

    
}
