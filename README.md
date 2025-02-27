# Game List API

## Description
This is a **RESTful API** for managing a game list system, allowing users organize game collections. The project follows best API design practices, using **Spring Boot** and **JPA** to interact with the database.

## Features

### Game List Management:
- List all games
- Search game by ID
- Move games within a list

### Game List Handling:
- List all game lists
- Search game list by ID

### Exception Handling:
- Clear error responses (400, 404) with detailed messages

## Technologies Used

### Backend:
- Spring Boot  
- Spring Data JPA (Hibernate)  
- Jackson
- Postman

### Database:
- **H2 Database**  
- **PostgresSQL**  

## Project Structure
```
/game-list-api
├── src
│   ├── main
│   │   ├── java/com/dslist
│   │   │   ├── controllers
│   │   │   ├── dtos
│   │   │   ├── entities
│   │   │   ├── repositories
│   │   │   ├── services
│   │   ├── resources
│   ├── test
│
├── pom.xml
├── README.md
```

## Endpoints

### **Games**
- `GET /games` - List all games.  
- `GET /games/{id}` - Search for a game by ID.  

### **Game Lists**
- `GET /lists` - List all game lists.  
- `GET /lists/{id}` - Search for a game list by ID.
- `GET /lists/{id}/games` - Search for games from a list by id.  

## How to Run the Project

### **Prerequisites**
- **JDK 21+**  
- **Maven**

### **Steps**
1. Clone this repository:
   ```sh
   git clone https://github.com/Thiaghoul/dslist-springboot-jpa.git
   ```
2. Configure the database in `application.properties` to use **H2**:
   ```properties
   spring.datasource.url=jdbc:h2:mem:testdb
   spring.datasource.driverClassName=org.h2.Driver
   spring.datasource.username=sa
   spring.datasource.password=
   spring.h2.console.enabled=true
   spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
   ```
3. Run the project:
   ```sh
   ./mvnw spring-boot:run
   ```
4. Access the **H2 Console**:
   - **URL:** `http://localhost:8080/h2-console`  
   - **JDBC URL:** `jdbc:h2:mem:testdb`  
   - **User:** `sa`  
   - **Password:** *(empty)*

5. Test the API:
   - `http://localhost:8080/games`  
   - `http://localhost:8080/lists`  

## Request Example

### get a game by id

**Endpoint:**  
`get /games/1`

**Response:**  
```json
{
    "id": 4,
    "title": "Sekiro: Shadows Die Twice",
    "year": 2019,
    "genre": "Role-playing (RPG), Adventure",
    "platforms": "XBox, Playstation, PC",
    "score": 3.8,
    "imgUrl": "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/4.png",
    "shortDescription": "Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit esse officiis corrupti unde repellat non quibusdam! Id nihil itaque ipsum!",
    "longDescription": "Lorem ipsum dolor sit amet consectetur adipisicing elit. Delectus dolorum illum placeat eligendi, quis maiores veniam. Incidunt dolorum, nisi deleniti dicta odit voluptatem nam provident temporibus reprehenderit blanditiis consectetur tenetur. Dignissimos blanditiis quod corporis iste, aliquid perspiciatis architecto quasi tempore ipsam voluptates ea ad distinctio, sapiente qui, amet quidem culpa."
}

```
**Endpoint:**  
`POST /lists/2/replacement`

**Body:**  
```json
{
    "sourceIndex" : 3,
    "destinationIndex" : 1
}

## Author
Developed by Thiago Henriques Nunes

