import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class CreateNewPost {

    @Test
    @DisplayName("Тест-кейс №1: Добавить новый пост")
    void createPost() {
        given()
                .when()
                .log()
                .all()
                .header("Content-Type", "text/html; charset=utf-8")
                .post("https://jsonplaceholder.typicode.com/posts?title=foo&body=bar&userId=1")
                .then()
                .log()
                .all()
                .assertThat()
                .body("id", is(101));
    }

    @Test
    @DisplayName("Тест-кейс №2: Получить валидный код состояния")
    void getValidStatusCode() {
        given()
                .when()
                .log()
                .all()
                .header("Content-Type", "text/html; charset=utf-8")
                .post("https://jsonplaceholder.typicode.com/posts?title=foo&body=bar&userId=2")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(201);
    }

    @Test
    @DisplayName("Тест-кейс №8: Проверить значение заголовка Content-Type в ответе")
    void checkContentTypeValue() {
        given()
                .when()
                .log()
                .all()
                .post("https://jsonplaceholder.typicode.com/posts?title=foo&body=bar&userId=1")
                .then()
                .log()
                .all()
                .assertThat()
                .header("Content-Type", "text/html; charset=utf-8");
    }

}
