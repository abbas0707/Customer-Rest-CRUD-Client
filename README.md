# Customer-Rest-CRUD-Client
Rest API Client with fixed delay
The application is Rest API client, which consumes the service after 5 mintes delay. Rest API source is at https://github.com/abbas0707/Customer-Rest-CRUD
This client consumes /listCustomers functionality and saves the response under under data folder in JSON format.
In order to the run the client, please follow the below instructions

Pre-Requisites

1)- Java 8 installed on the system

2)- Maven must be installed and configure greater than version 3, Configure environment variable M2_HOME and add PATH variable (Please follow the instruction from maven site incase of any issue on how how to configure maven) 



Running the client

1)- Download the source code

2)- cd to home folder  Customer-Rest-CRUD-Client

3)- Run command 

   mvn spring-boot:run
   
4)- It can be seen from log, client is consuming the SERVICE after 5 mins of delay.

5)- All the responses are saved in file under data folder in JSON format.

