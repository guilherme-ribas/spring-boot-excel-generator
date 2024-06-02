# Project: REST API with Spring Boot

This project is a REST API built with Spring Boot that performs the following functionality:

1. **External API Query**: Uses `RestTemplate` to make a GET request to an external API that returns a JSON containing a list of posts.
2. **Data Deserialization**: Uses the Jackson library to deserialize the received JSON into Java objects.
3. **Excel Spreadsheet Creation**: Uses the Apache POI library to create an Excel spreadsheet from the deserialized data.
4. **Download Endpoint**: Provides an endpoint via `@RestController` that allows the download of the Excel spreadsheet in the appropriate format through a GET request.

## Technologies Used

- **Spring Boot**: Main framework for building the REST API.
- **RestTemplate**: To make HTTP requests to the external API.
- **Jackson**: To deserialize the JSON returned by the external API into Java objects.
- **Apache POI**: To create and manipulate Excel files.
- **Maven**: For dependency management and project building.

## Endpoints

- `GET /api/download/excel`: This endpoint allows the download of the Excel spreadsheet created from the data returned by the external API.

## How to Run the Project

1. **Clone the repository**:

    ```bash
    git clone https://github.com/your-username/your-repository.git
    cd your-repository
    ```

2. **Set up Maven**:

    Ensure that you have Maven installed and configured in your environment.

3. **Add the necessary dependencies**:

    In the `pom.xml` file, the following dependencies should be present:

    ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
    </dependency>
    <dependency>
        <groupId>org.apache.poi</groupId>
        <artifactId>poi-ooxml</artifactId>
        <version>5.2.3</version>
    </dependency>
    ```

4. **Run the application**:

    ```bash
    mvn spring-boot:run
    ```

5. **Access the endpoint**:

    Open your browser or API tool (like Postman) and access the endpoint:

    ```
    http://localhost:8080/api/download/excel
    ```

    This will start the download of the generated Excel spreadsheet.

## Project Structure

- `src/main/java/com/example/myproject/model/Person.java`: Model class to represent the deserialized posts.
- `src/main/java/com/example/myproject/service/ExternalApiService.java`: Service to make the request to the external API and deserialize the data.
- `src/main/java/com/example/myproject/service/ExcelService.java`: Service to generate the Excel spreadsheet from the deserialized data.
- `src/main/java/com/example/myproject/controller/ExcelController.java`: REST controller that exposes the endpoint for downloading the Excel spreadsheet.

## Contribution

Contributions are welcome! Feel free to open issues or submit pull requests for improvements.

## License

This project is licensed under the MIT License. See the `LICENSE` file for more details.
