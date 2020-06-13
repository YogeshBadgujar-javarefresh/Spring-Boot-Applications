# Spring-Boot-Applications

# Application 1 - Spring-Boot-H2-JPA-Re-XmlJsonPdf
Description - Generate the HTTP Response in different format such as XML, JSON and PDF format. By using Spring MVC and JPA(CrudRepository in-build CRUD operation) dynamically pick data from H2 Database i.e. in-memory database.
Technologies - Java 8, Spring Boot, Spring MVC, JPA, H2 database, itext(pdf generator), jackson dataformat for xml, Junit(MVC controller)
Note - At the time of server start data will be uploaded into H2 database through SQL script.

H2 Database console - http://localhost:8080/doctorApp/h2-console

Get all records -
XML data - http://localhost:8080/doctorApp/doctorsInXML

JSON data - http://localhost:8080/doctorApp/doctorsInJSON

PDF data - http://localhost:8080/doctorApp/doctorsInPdf

Get particular data based on id

XML data - http://localhost:8080/doctorApp/doctorInXML/3

JSON data - 


