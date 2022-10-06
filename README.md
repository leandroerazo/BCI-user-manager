## Local deployment
### Dependencies for Local Development
this application uses spring boot embed server and runs in 8080 port.
Just run the AssignmentApplication class

#### Database:
This application uses an H2 in memory database, once application is running the database is created.
Database credentials and properties(db name, user, password, connection) are in the application.yml file
Once the application stops the Database will be deleted.


#### cURLs:
####Create user
Import this cURL in postman and try to create a new user
```
curl --location --request POST 'localhost:8080/createUser' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Juan Rodriguez",
    "email": "juan@gmail.com",
    "password": "MariaCamila1909*",
    "phones": [
        {
            "number": "1234567",
            "cityCode": "1",
            "countryCode": "57"
        }
    ]
}

'
```