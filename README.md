# 🚗 Uber-Style Console App (Java)

A console-based ride-hailing simulation in Java, supporting user & driver registration, ride requests (including delivery), and ride lifecycle management.

## 🔍 Overview

- Simple CLI-driven UI via `UI.java`
- Register/login as **User** or **Driver**
- Users can **book rides** or **request deliveries**
- Drivers can **view available jobs**, **accept**, **start**, **complete**
- Core logic in `SystemManager.java`
- Data stored in-memory using `cmap.java`

## 📁 Project Structure

```

uberProject/
├── User.java            # user model & actions
├── drivers.java         # driver model & actions
├── registration.java    # handles login/signup
├── cmap.java            # simple in-memory storage (maps)
├── Ride.java            # base ride attributes & logic
├── Delivery.java        # delivery-specific ride subclass
├── services.java        # definitions for ride types & rates
├── SystemManager.java   # orchestrates users, drivers, rides
└── UI.java              # console menu interface

````

## 💾 Prerequisites

- Java JDK 8+
- Optional: IDE (IntelliJ, Eclipse, VSCode)

## ▶️ Run Instructions

```bash
git clone https://github.com/ripudamanjit/uberProject.git
cd uberProject
javac *.java
java UI
````

### Typical Usage Flow

1. Choose: **User** or **Driver**
2. Register or login
3. **Users**

   * Request ride or delivery
   * View assigned driver & ride status
4. **Drivers**

   * View pending jobs
   * Accept, start, complete rides
5. End of ride shows summary

## ✅ Features

* User & driver registration/login
* Multiple ride types (UberX, delivery, etc.)
* In-memory ride & data management
* Full ride lifecycle via console prompts




---

Copy the above into your `README.md`, tweak features or usage details as needed—especially around console prompts or new classes you've added.
