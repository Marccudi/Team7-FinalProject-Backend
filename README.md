# Team7-FinalProject-Backend

This application is for exchanging games between users or borrowing games from each other. 

The data is hosted in a MySQL database and sent through an API to the Front-end.

We have different objects:

* Developer: Stores the developer's name
* Platform: Stores the platform's name
* Genre: Stores the genre's name
* Game: Stores the information of the game: the title, the duration, the year of publication, the age rating, the description, the date of insertion to the database, the id of the developer, the genre, if it is active and if it is on loan.
* User: Stores the user information, username, email, password, first name, last name and role.
* Borrow: Stores the loans of the game, the game id, the owner id, the borrower id, the loan date, the return date and if it is pending confirmation by the owner.
* Own: Stores game exchanges, the game id, the id of the previous owner, the id of the new owner, the date of the exchange, and if it's pending confirmation by the owner.
* GameHaveGenre: Establishes the relationship between the game and genre tables, has the id of game and owner.

## ENDPOINTS

### Developer

**Sample structure:** { "id": 1, "name": "Nintendo"}

* GET     ->  /api/developers       ->  Returns a list of all the developers
* GET     ->  /api/developers/{id}  ->  Returns the developer that has the given id
* POST    ->  /api/developers       ->  Insert a new developer with the specified data structure
* PUT     ->  /api/developers/{id}  ->  Update a developer indicating the id
* DELETE  ->  /api/developers/{id}  ->  Delete the developer that contains the specified id

### Platform

**Sample structure:** { "id": 1, "name": "PC" }

* GET     ->  /api/platforms       ->  Returns a list of all the platforms
* GET     ->  /api/platforms/{id}  ->  Returns the platform that has the given id
* POST    ->  /api/platforms       ->  Insert a new platform with the specified data structure
* PUT     ->  /api/platforms/{id}  ->  Update a platform indicating the id
* DELETE  ->  /api/platforms/{id}  ->  Delete the platform that contains the specified id

### Genre

**Sample structure:** { "id": 1, "name": "Accion" }

* GET     ->  /api/genres       ->  Returns a list of all the genres
* GET     ->  /api/genres/{id}  ->  Returns the genre that has the given id
* POST    ->  /api/genres       ->  Insert a new genre with the specified data structure
* PUT     ->  /api/genres/{id}  ->  Update a genre indicating the id
* DELETE  ->  /api/genres/{id}  ->  Delete the genre that contains the specified id

### Game

**Sample structure:** { "id": 1, "title": "Super Mario Odyssey", "duration": 12, "yearReleased": 2017, "ageCalification": "PEGI 3", "description": "...", "dateInserted": "2022-08-18T00:00:00.000+00:00", "enabled": true, "borrowed": true, "developer": [developer structure], "platform": [platform structure] }

* GET     ->  /api/games                 ->  Returns a list of all the games
* GET     ->  /api/games/{id}            ->  Returns the game that has the given id
* POST    ->  /api/games                 ->  Insert a new game with the specified data structure
* PUT     ->  /api/games/{id}            ->  Update a game indicating the id
* DELETE  ->  /api/games/{id}            ->  Delete the game that contains the specified id
* GET     ->  /api/games/developer/{id}      ->  Returns a list of all games made by the specified developer
* GET     ->  /api/games/platform/{id}       ->  Returns a list with all the games that have the indicated genre
* GET     ->  /api/games/borrowed/{borrowed} ->  Returns whether the game is borrowed or not
* GET     ->  /api/games/user/{id}       ->  Returns all the games owned by the specified user

### User

**Sample structure:** { "id": 1, "username": "example", "email": "example@example.com", "password": "...", "first_name": "example", "last_name": "example", "role": "user" }

* GET     ->  /api/users       ->  Returns a list of all the users
* GET     ->  /api/users/{id}  ->  Returns the user that has the given id
* POST    ->  /api/users       ->  Insert a new user with the specified data structure
* PUT     ->  /api/users/{id}  ->  Update a user indicating the id
* DELETE  ->  /api/users/{id}  ->  Delete the user that contains the specified id

### Borrow

**Sample structure:** { "id": 1, "game": [game structure], "userOwner": [user structure], "userBorrower": [user structure], "lend_date": "2022-01-15T00:00:00.000+00:00", "return_date": "2022-02-15T00:00:00.000+00:00", "pending": true }

* GET     ->  /api/borrows       ->  Returns a list of all the loans
* GET     ->  /api/borrows/{id}  ->  Returns the loan that has the given id
* POST    ->  /api/borrows       ->  Insert a new loan with the specified data structure
* PUT     ->  /api/borrows/{id}  ->  Update a loan indicating the id
* DELETE  ->  /api/borrows/{id}  ->  Delete the loan that contains the specified id
* GET     ->  /api/borrows/borrower/{id}  ->  Returns a list of games that have been loaned to you
* PUT     ->  /api/acceptborrow/{id}      ->  Accept the loan and indicate the return date.
* GET     ->  /api/borrows/user/{id}      ->  Listing of all loans whether you are the owner or the lender
* GET     ->  /api/borrows/{id}/{state}   ->  Returns loans with the indicated status of a user
* GET     ->  /api/borrows/owner/{id}     ->  Returns loans where the owner is the specified user

### Own

**Sample structure:** { "id": 1,"game": [game structure], "userOldOwner": [user structure], "userNewOwner": [user structure], "exchange_date": "2021-12-03T00:00:00.000+00:00", "pending": false }

* GET     ->  /api/owns       ->  Returns a list of all the exchanges
* GET     ->  /api/owns/{id}  ->  Returns the exchange that has the given id
* POST    ->  /api/owns       ->  Insert a new exchange with the specified data structure
* PUT     ->  /api/owns/{id}  ->  Update a exchange indicating the id
* DELETE  ->  /api/owns/{id}  ->  Delete the exchange that contains the specified id
* GET     ->  /api/owns/{id}/{state}  -> Returns a list of the exchanges of the future former owner asking the status, so that the future former owner can accept or deny the exchange.

### GameHaveGenre

**Sample structure:** { "id": 1, "game": [game structure], "genre": [genre structure] }

* GET     ->  /api/gameHaveGenres             ->  Returns a list of all the gameHaveGenres
* GET     ->  /api/gameHaveGenres/{id}        ->  Returns the gameHaveGenres that has the given id
* POST    ->  /api/gameHaveGenres             ->  Insert a new gameHaveGenres with the specified data structure
* PUT     ->  /api/gameHaveGenres/{id}        ->  Update a developer gameHaveGenres the id
* DELETE  ->  /api/gameHaveGenres/{id}        ->  Delete the gameHaveGenres that contains the specified id
* GET     ->  /api/gameHaveGenres/genre/{id}  ->  Returns all games with the indicated genre
* GET     ->  /api/gameHaveGenres/game/{id}   ->  Returns all ganres with the indicated game
