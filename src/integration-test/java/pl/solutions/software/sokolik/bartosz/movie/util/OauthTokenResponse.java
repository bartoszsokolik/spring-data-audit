package pl.solutions.software.sokolik.bartosz.movie.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.restassured.RestAssured;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OauthTokenResponse {

  @JsonProperty("access_token")
  private String accessToken;

  @JsonProperty("token_type")
  private String tokenType;

  @JsonProperty("refresh_token")
  private String refreshToken;

  @JsonProperty("expires_in")
  private int expiresIn;

  @JsonProperty("scope")
  private String scope;

  public static OauthTokenResponse getOauthToken() {
    return RestAssured.given()
        .auth()
        .basic("sampleClientId", "sampleClientSecret")
        .header("Content-Type", "application/x-www-form-urlencoded")
        .formParam("grant_type", "password")
        .formParam("username", "user")
        .formParam("password", "password")
        .when()
        .post("http://localhost:8080/oauth/token")
        .as(OauthTokenResponse.class);
  }
}
