<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Uber-Style Console App (Java)</title>
  <style>
    body {
      background-color: white;
      color: black;
      font-family: Arial, sans-serif;
      line-height: 1.6;
      margin: 40px;
    }
    code, pre {
      background-color: #f4f4f4;
      padding: 5px;
      border-radius: 4px;
      display: block;
      overflow-x: auto;
    }
    pre {
      white-space: pre-wrap;
    }
    h1, h2, h3 {
      color: #333;
    }
    ul {
      list-style: disc inside;
    }
    .structure {
      background-color: #f9f9f9;
      padding: 10px;
      border-left: 5px solid #ccc;
      font-family: monospace;
      white-space: pre;
    }
  </style>
</head>
<body>

<h1>🚗 Uber-Style Console App (Java)</h1>

<p>A console-based ride-hailing simulation in Java, supporting user & driver registration, ride requests (including delivery), and ride lifecycle management.</p>

<h2>🔍 Overview</h2>
<ul>
  <li>Simple CLI-driven UI via <code>UI.java</code></li>
  <li>Register/login as <strong>User</strong> or <strong>Driver</strong></li>
  <li>Users can <strong>book rides</strong> or <strong>request deliveries</strong></li>
  <li>Drivers can <strong>view available jobs</strong>, <strong>accept</strong>, <strong>start</strong>, <strong>complete</strong></li>
  <li>Core logic in <code>SystemManager.java</code></li>
  <li>Data stored in-memory using <code>cmap.java</code></li>
</ul>

<h2>📁 Project Structure</h2>
<div class="structure">
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
</div>

<h2>💾 Prerequisites</h2>
<ul>
  <li>Java JDK 8+</li>
  <li>Optional: IDE (IntelliJ, Eclipse, VSCode)</li>
</ul>

<h2>▶️ Run Instructions</h2>
<pre><code>git clone https://github.com/ripudamanjit/uberProject.git
cd uberProject
javac *.java
java UI
</code></pre>

<h3>Typical Usage Flow</h3>
<ol>
  <li>Choose: <strong>User</strong> or <strong>Driver</strong></li>
  <li>Register or login</li>
  <li><strong>Users</strong>
    <ul>
      <li>Request ride or delivery</li>
      <li>View assigned driver & ride status</li>
    </ul>
  </li>
  <li><strong>Drivers</strong>
    <ul>
      <li>View pending jobs</li>
      <li>Accept, start, complete rides</li>
    </ul>
  </li>
  <li>End of ride shows summary</li>
</ol>

<h2>✅ Features</h2>
<ul>
  <li>User & driver registration/login</li>
  <li>Multiple ride types (UberX, delivery, etc.)</li>
  <li>In-memory ride & data management</li>
  <li>Full ride lifecycle via console prompts</li>
</ul>

<h2>🚀 Getting Started & Enhancement Ideas</h2>
<ul>
  <li>Integrate real-world <strong>distance/fare calculation</strong> (Google Maps API)</li>
  <li>Add <strong>geolocation support</strong> (lat/long simulation)</li>
  <li>Persist data using file I/O or database (SQLite/MySQL)</li>
  <li>Schedule future rides</li>
  <li>Implement <strong>notifications</strong> (console/email mock)</li>
  <li>Add <strong>ratings/reviews</strong></li>
  <li>Unit test using <strong>JUnit</strong></li>
</ul>
<hr>

<p><strong>Author:</strong> Ripudamanjit<br>
📬 Contact via GitHub</p>

</body>
</html>

