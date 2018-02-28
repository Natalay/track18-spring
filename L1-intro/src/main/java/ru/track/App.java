package ru.track;

import com.mashape.unirest.http.*;


/**
 * TASK:
 * POST request to  https://guarded-mesa-31536.herokuapp.com/track
 * fields: name,github,email
 *
 * LIB: http://unirest.io/java.html
 *
 *
 */
public class App {

    public static final String URL = "http://guarded-mesa-31536.herokuapp.com/track";
    public static final String FIELD_NAME = "Natalay";
    public static final String FIELD_GITHUB = "Natalay";
    public static final String FIELD_EMAIL = "sorokinan86@outlook.com";

    public static void main(String[] args) throws Exception {
       // 1) Use Unirest.post()
        HttpResponse<JsonNode> jsonResponse = Unirest.post(URL)
                //  .header("accept", "application/json")
                .queryString("name", FIELD_NAME)
                .field("github", FIELD_GITHUB)
                .field("email", FIELD_EMAIL)
                .asJson();

        // 2) Get response .asJson()
        System.out.println(jsonResponse.getBody());
        // 3) Get json body and JsonObject
        System.out.println(jsonResponse.getBody().getObject().get("success"));

        // 4) Get field "success" from JsonObject

        boolean success = false;
        Unirest.shutdown();
    }

}
