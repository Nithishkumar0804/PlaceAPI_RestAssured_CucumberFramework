# PlaceAPI RestAssured Cucumber Framework  

## 📌 Overview  
This project demonstrates an **API Test Automation Framework** for the **Place API**, where users can:  
- ➕ Add a Place  
- 📖 Get Place details  
- ✏️ Update a Place  
- ❌ Delete a Place  

The framework is built using **RestAssured, Cucumber (BDD), and JUnit** and generates rich test execution reports with **maven-cucumber-reporting**.  

---

## 🚀 Tech Stack  
- **Java** – Programming language  
- **RestAssured** – API testing library  
- **Cucumber (BDD)** – Behavior Driven Development  
- **JUnit** – Test runner  
- **Maven** – Build & dependency management  
- **maven-cucumber-reporting** – Advanced reporting  

---

## 🎯 Features  
- Full **CRUD operations** on Place API  
- **Cucumber BDD** with feature files & step definitions  
- **Reusable utilities** with Spec Builders & Data Builders  
- **POJO Classes** for request/response mapping  
- **Configurable properties** for test environments  
- **Hooks for setup & teardown**  
- **Detailed HTML Reports** with execution insights  

---

## 📊 Reports  
After execution, detailed HTML reports are generated at:  
target/Reports/cucumber-html-reports/overview-features.html

---


These reports provide insights into:  
- ✅ Scenario and step-wise execution status  
- ⏱️ Execution time details  
- 📈 Overall feature coverage  

---

## 🚀 Future Enhancements  
- ⚡ Parallel execution setup  
- 📈 Extend test coverage for more complex APIs  
- ▶️ Run tests using Maven:  
  ```bash
  mvn clean test verify
