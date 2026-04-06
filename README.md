# 🤖 Selenium Automation Project - SauceDemo

## 📌 Objective
To automate test scenarios of a web-based e-commerce application using Selenium WebDriver with Java.

## 🌐 Application Under Test
https://www.saucedemo.com/

## 🛠️ Tools & Technologies
- Java
- Selenium WebDriver
- TestNG
- Maven
- IntelliJ IDEA

## 🏗️ Framework Design
- Page Object Model (POM)
- Reusable test components
- Organized folder structure (base, pages, tests)

## 📂 Project Structure
src/
├── main/java/pages → Page classes
├── main/java/base → BaseTest setup
├── test/java/tests → Test classes

## 🧪 Test Scenarios Automated
- Login with valid user
- Login with invalid (locked) user
- Empty login validation
- Product sorting (Name Z-A, Price Low-High)
- Add items to cart
- Navigate to cart page
- Complete checkout process
- Verify direct URL access without login (security check)

## ✅ Assertions Used
- URL validation
- Error message validation
- Product sorting verification
- Checkout success message validation

## ▶️ Execution
Tests are executed using TestNG annotations.
Example:
@Test
public void validUserLoginTest()

## 📊 Key Features
- Automated UI testing
- Validation of business logic
- Reusable methods for maintainability
- Clean and scalable framework

## 🚀 How to Run
1. Clone the repository
2. Open in IntelliJ IDEA
3. Run test classes using TestNG

## 📌 Conclusion
Automation testing was successfully implemented for major functionalities, ensuring faster and reliable validation of the application.

## 👤 Author
Utsav Raj Kharel
