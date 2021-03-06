# ATM Simulation

an application that simulates the logic of a cash dispensing Automatic Teller Machine (ATM). **This project is propose for
participate program only not for real production use**.

## Feature

1. support only support ฿20 and ฿50 notes.
2. support withdraw money feature
3. support update notes in atm.
4. not support add more atm via api.

## Getting Start


### Prerequisites
Need to install following package
1. java8
2. maven
3. mysql 5.6 or later (optional)
### Installing
clone this project and run maven to build project with following command:
```
cd <project_name>
mvn clean install
```
to run application.
```
java -jar target/*.jar
```
you can access application with following link
```
http://localhost:8080/
```
*NOTE* An application will run with In-memory database as a default datasource. If you want to start application with mysql
you need to install mysql and create schema and username with following command
``` sql

create database atm;
grant all on atm.* to atm IDENTIFIED BY  '123456';
flush privileges;

```
and start application with following command
```
java -jar -Dspring.profile.active=mysql target/*.jar
```

### Testing

update note in atm with following command:

```
curl -X PUT --header 'Content-Type: application/json' --header 'Accept: application/json' \
-d '{ "id": 1, "numOfBath20": 100, "numOfBath50": 100 }' 'http://localhost:8080/api/v1/atm/1'

```
withdraw money with following command:
```
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{
  "amount": 100
}' 'http://localhost:8080/api/v1/atm/1/withdraw'
```
get current atm profile with following command:
```
curl -X GET --header 'Accept: application/json' 'http://localhost:8080/api/v1/atm/1'

```

or you can test apis with swagger by open following url: 
```
http://localhost:8080/swagger-ut.html
```

### Package
1. config : provide configuration class
1. controller : provide handle request logic.
1. exception : provide error and handle error class.
1. model : provide transport and dto class.
1. repository : provide layer to working with database.
1. service : provide business logic class.
1. util : provide helper function and static method.

### Framework
**Backend**
1. spring-boost
   1. jpa : handle database
   1. liquibase : database version control
   1. freemarker : template engine
   1. dev-tool : quick restart service
   1. mysql-jdbc : database driver
   1. h2-jdbc : database driver
   1. spring-test : junit & mockito for unit-test
1. spring-fox : generate document by swagger

**Fontend**

1. freemarker
1. jquery 3
1. bootstrap 4 
1. html5