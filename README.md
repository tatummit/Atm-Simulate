# ATM Simulation

an application that simulates the logic of a cash dispensing Automatic Teller Machine (ATM). This project is propose for
participate program only not for real production use.

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
java -jar target/*.jar
```
you can access application with following link
```
http://localhost:8080/swagger-ut.html
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
java -jar -Dspring.active.profile=mysql target/*.jar
```