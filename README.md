<div align="center">
  <img src="https://img.icons8.com/color/144/null/hiragana-ma.png" alt="J-Dict Pro Logo" width="100px" />
  <h1>🇯🇵 J-Dict Pro</h1>
  <p>
    <strong>Full-stack Japanese Vocabulary Manager</strong><br>
    Learn • Search • Memorize
  </p>

  <p>
    <a href="https://www.java.com">
      <img src="https://img.shields.io/badge/Java-17%2B-orange?style=flat-square&logo=openjdk" alt="Java Version">
    </a>
    <a href="https://spring.io/projects/spring-boot">
      <img src="https://img.shields.io/badge/Spring%20Boot-3.x-green?style=flat-square&logo=springboot" alt="Spring Boot">
    </a>
    <a href="https://www.mysql.com/">
      <img src="https://img.shields.io/badge/MySQL-8.x-blue?style=flat-square&logo=mysql" alt="MySQL">
    </a>
     <a href="#">
      <img src="https://img.shields.io/badge/Frontend-HTML%2FJS-yellow?style=flat-square&logo=javascript" alt="Frontend">
    </a>
  </p>
</div>

---

## 📖 Introduction

**J-Dict Pro** is a personal full-stack project designed to build a modern Japanese vocabulary management system. The project evolved from a basic Console Application into a complete Web System with a RESTful API.

## ✨ Key Features

* ✅ **Full CRUD Operations:** Create, Read, Update, and Delete vocabulary words.
* 🔎 **Real-time Search:** Filter words by Kanji, Hiragana, or Meaning instantly as you type.
* 🖥️ **Intuitive Web UI:** Built with pure HTML5, CSS3, and JavaScript (Vanilla JS) for a lightweight experience.
* 🚀 **RESTful API:** Backend powered by Spring Boot, providing standard JSON APIs for any client.
* 🗄️ **Persistent Storage:** Data is securely stored using MySQL Database.

---

## 🛠️ Tech Stack

| Component | Technology | Description |
| :--- | :--- | :--- |
| **Backend** | Java 17, Spring Boot 3 | Core logic and REST API Controllers. |
| **Database** | MySQL 8.x | Relational database for vocabulary storage. |
| **Data Access** | JDBC, DAO Pattern | Manual database connection and query handling. |
| **Frontend** | HTML, CSS, JavaScript | User Interface and Fetch API integration. |
| **Build Tool** | Maven | Dependency management. |

---

## 📸 Screenshots

<div align="center">
  <img src="https://github.com/user-attachments/assets/ad68fcf4-d644-4c3d-9957-4bda4060c360" alt="J-Dict Web UI Screenshot" style="border-radius: 10px; box-shadow: 0 4px 8px rgba(0,0,0,0.1);">
  <p><em>Main Dashboard Interface</em></p>
</div>

---

## ⚙️ Installation Guide

### Prerequisites
* Java Development Kit (JDK) 17 or higher.
* MySQL Server 8.0 or higher (running).
* IntelliJ IDEA (recommended) or any Java IDE.
* Maven (usually included in IntelliJ).

### Step 1: Clone the repository
```bash
git clone https://github.com/truong-magnus/JDictMaven.git
cd JDictMaven
```
### Step 2: Database Configuration

* Open the file ```src/main/java/com/example/DatabaseConnection.java```.
* Update the USER and PASSWORD constants to match your local MySQL configuration:
```bash
private static final String USER = "root";
private static final String PASSWORD = "your_password"; // <-- Update if you have a password
```
* Run the database.sql script (located in the root folder) using a database tool (DBeaver, MySQL Workbench) to create the schema and initial data.

### Step 3: Run the Application

* Open the project in IntelliJ IDEA.
* Allow Maven to download all dependencies.
* Run the```JDictApplication.java```file.
* Open your browser and navigate to: http://localhost:8080

# 🤝 Contributing
Contributions are welcome! If you find any bugs or want to add new features, please feel free to submit a Pull Request.

<div align="center"> <strong>Built with ❤️ by Truongmagnus</strong> </div>