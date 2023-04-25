# JDBC
Write an application that allows to connect to a relational database by using JDBC, submit SQL statements and display the results.

The main specifications of the application are:

## Compulsory
 - Create a relational database using any RDBMS (Oracle, Postgres, MySql, Java DB, etc.).
 - Write an SQL script that will create the following tables:
    - albums: id, release year, title, artist, genre(s)
    - artists: id, name (for example: Beatles)
    - an associative (junction) table in order to store each album genres
 - Update pom.xml, in order to add the database driver to the project libraries.
 - Create a singleton class in order to manage a connection to the database.
 - Create DAO classes that offer methods for managing artists, genres and albums (at least one).
 - Implement a simple test using your classes.

## Optional
 - Create an object-oriented model of the data managed by the Java application.
 - Implement all the DAO classes.
 - Use a connection pool in order to manage database connections, such as C3PO, HikariCP or Apache Commons DBCP.
 - Create a tool to import data from a real dataset, such as Rolling Stone's 500 Greatest Albums of All Time (or other)
