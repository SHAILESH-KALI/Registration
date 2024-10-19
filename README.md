  # Registration

# For Frontend (Registration.java and User.java file)
 
# For Backend(UserDao.java file)
 

#  My java application are create using java, java swing(GUI), MySQL.

This is a simple Java Swing application for user registration.

## Features
- User registration form with fields: 
  - ID (Primary Key)
  - Name
  - Email
  - Phone Number
  - Date of Birth
  - Address

## Requirements
- Java JDK 8 or above

## Running the Application

1. Clone the repository or download the source files.
2. Open a terminal/command prompt and navigate to the `src` directory.
3. Compile the Java files:
   ```bash
   javac com/example/registration/*.java
Run the application:

bash
Copy code
Fill in the registration form and submit.

markdown
Copy code

 
Notes : 
This application will display a registration form with the specified fields.
It includes basic validation to ensure that all fields are filled and the email format is correct.
You can enhance the application further by adding functionality to save the registration data to a database.


USE DATABASE TO STORE DATA USING CRUD

Testing the CRUD Operations
You can test the CRUD operations 

Create a Registration:

http
Copy code
POST /api/registrations
Content-Type: application/json

{
    "name": "Shailesh Kumar Yadav",
    "email": "shailesh962865@example.com",
    "dateOfBirth": "2003-08-15",
    "phoneNumber": "9628657677",
    "address": "Noida"
}
Read All Registrations:

http
Copy code
GET /api/registrations
Read Registration by ID:

http
Copy code
GET /api/registrations/{id}
Update Registration:

http
Copy code
PUT /api/registrations/{id}
Content-Type: application/json

{
    "name": "Shailesh Kumar Yadav",
    "email": "shailesh962865@example.com",
    "dateOfBirth": "2003-08-15",
    "phoneNumber": "9628657677",
    "address": "Noida"
}
Delete Registration:

http
Copy code
DELETE /api/registrations/{id}


all data are stored in MySQL Workbench if you can register the same data then data are not stored in MySQL because we are implement CRUD oparation.
I hope you can understand easily. Thank you
