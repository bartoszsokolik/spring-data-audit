package pl.solutions.software.sokolik.bartosz.movie.domain;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.http.HttpStatus.OK;

import io.restassured.RestAssured;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import pl.solutions.software.sokolik.bartosz.movie.util.OauthTokenResponse;

@RunWith(JUnitParamsRunner.class)
public class MovieControllerIT {

  @Test
  @Parameters
  public void shouldReturnMovieWithGivenId(String title) {
    OauthTokenResponse oauthResponse = OauthTokenResponse.getOauthToken();

    RestAssured.given()
        .auth()
        .oauth2(oauthResponse.getAccessToken())
        .when()
        .get("http://localhost:8080/api/movies/title/" + title)
        .then()
        .statusCode(OK.value())
        .body("title", equalTo(title));
  }

  @Test
  public void testFindAllMovies() {
    OauthTokenResponse oauthResponse = OauthTokenResponse.getOauthToken();

    RestAssured.given()
        .auth()
        .oauth2(oauthResponse.getAccessToken())
        .when()
        .get("http://localhost:8080/api/movies")
        .then()
        .statusCode(OK.value())
        .body("totalCount", equalTo(2),
            "data.title", containsInAnyOrder("Star Wars", "Harry Potter"));

  }

  private Object parametersForShouldReturnMovieWithGivenId() {
    return new Object[]{
        new Object[]{"Star Wars"},
        new Object[]{"Harry Potter"}
    };
  }
}
