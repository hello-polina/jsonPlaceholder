import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.concurrent.TimeUnit;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class GetListTest {

    @Test
    @DisplayName("Тест-кейс №14: Проверить статус код при отправке id поста в запросе и фильтрации по невалидному userId")
    void checkCodeWithFilteringByInvalidUserId() {
        given()
                .when()
                .log()
                .all()
                .get("https://jsonplaceholder.typicode.com/posts/2?userId=3")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(404)
                .statusLine("Not Found");
    }

    @Test
    @DisplayName("Тест-кейс №16: Проверить производительность при применении в запросе фильтрации и сортировки")
    void checkPerformanceWithFilteringAndSorting() {
        given()
                .when()
                .log()
                .all()
                .get("https://jsonplaceholder.typicode.com/posts/2?userId=3")
                .then()
                .log()
                .all()
                .assertThat()
                .time(lessThan(60L), TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Тест-кейс №25: Проверить статус код при передаче невалидного заголовка ")
    void applyFilteringById() {
        given()
                .when()
                .log()
                .all()
                .header("token", "123camt461")
                .get("https://jsonplaceholder.typicode.com/posts")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(400)
                .statusLine("Bad Request");
    }

}
