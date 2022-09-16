# Team7-FinalProject-Backend

This application is for exchanging games between users or borrowing games from each other. 

The data is hosted in a MySQL database and sent through an API to the Fornt-end.

We have different objects:

* Developer: Here we store the developer's name
* Platform: Here we store the platform's name
* Genre: Here we store the genre's name
* Game: Here we store all the information of the game: the title, the duration, the year of publication, the age rating, the description, the date of insertion to the database, the id of the developer, the genre, if it is active and if it is on loan.
* User: Here we store all the user information, user name, email, password, first name, last name and role.
* Borrow: Here we store all the loans of the game, the game id, the owner id, the borrower id, the loan date, the return date and if it is pending confirmation by the owner.
* Own: Here we store all game exchanges, the id of the game, the id of the old owner, the id of the new owner, the date of the exchange, and if it is pending confirmation by the owner.
* GameHaveGenre: Here we make the relationship between the game table and the genre table, we have the id of the game and the id of the genre.

## ENDPOINTS

### Developer

GET -> /api/developers

GET -> /api/developers/{id}

POST -> 

### Platform

### Genre

### Game

### User

### Borrow

### Own

### GameHaveGenre

