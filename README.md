# phase2_end_project

**Creating a database and user**

        create database db_example; -- Creates the new database
        create user 'admin'@'%' identified by 'password'; -- Creates the user
        grant all on db_example.* to 'admin'@'%'; -- Gives all privileges to the new user on the newly created database

**Creating a users table**

        CREATE TABLE `users` (
          `id` int NOT NULL AUTO_INCREMENT,
          `email` varchar(255) NOT NULL,
          `username` varchar(255) DEFAULT NULL,
          `password` varchar(255) NOT NULL,
          PRIMARY KEY (`id`)
        );
        
**Insert data**

        use db_example;
        insert into db_example.users (email, username, password) values ("user1", "user1@email.com", "password1");
        insert into db_example.users (email, username, password) values ("user2", "user2@email.com", "password2");
        
**Testing a select**

        use db_example;
        select * from users;
