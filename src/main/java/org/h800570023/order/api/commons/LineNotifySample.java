package org.h800570023.order.api.commons;//package org.h800570023.order.api.commons;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.io.IOException;
//import java.net.URI;
//import java.net.URLEncoder;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//import java.nio.charset.StandardCharsets;
//
//public class LineNotifySample {
//
//
//    private static final String CLIENT_ID = "88kDIn539twSiZ4XrukC2W";
//    private static final String CLIENT_SECRET = "nCGH27NX66Z4WkabMRePA8SzrrFkQMKELSSsVjnC4qu";
//    private static final String REDIRECT_URI = "https://valid-fly-andytsia-ca62b3f7.koyeb.app";
//    private static final String AUTHORIZATION_URL = "https://notify-bot.line.me/oauth/authorize";
//    private static final String TOKEN_URL = "https://notify-bot.line.me/oauth/token";
//
//    public static void main(String[] args) throws IOException, InterruptedException {
//        // Step 1: Generate the authorization URL
//        String authorizationUrl = AUTHORIZATION_URL + "?" +
//                "response_type=code&" +
//                "client_id=" + CLIENT_ID + "&" +
//                "redirect_uri=" + URLEncoder.encode(REDIRECT_URI, StandardCharsets.UTF_8) + "&" +
//                "scope=notify&" +
//                "state=xyz";
//
//        System.out.println("Go to the following URL to authorize the application:");
//        System.out.println(authorizationUrl);
//
//        // Step 2: After the user authorizes the application, they will be redirected to your redirect URI with a code
//        // For example, let's assume we have received the following code:
//        String authorizationCode = "received_authorization_code";
//
//        // Step 3: Exchange the authorization code for an access token
//        HttpClient httpClient = HttpClient.newHttpClient();
//
//        String requestBody = "grant_type=authorization_code&" +
//                "code=" + authorizationCode + "&" +
//                "redirect_uri=" + URLEncoder.encode(REDIRECT_URI, StandardCharsets.UTF_8) + "&" +
//                "client_id=" + CLIENT_ID + "&" +
//                "client_secret=" + CLIENT_SECRET;
//
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(TOKEN_URL))
//                .header("Content-Type", "application/x-www-form-urlencoded")
//                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
//                .build();
//
//        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
//
//        // Parse the JSON response to get the access token
//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode jsonResponse = mapper.readTree(response.body());
//        String accessToken = jsonResponse.get("access_token").asText();
//
//        System.out.println("Access Token: " + accessToken);
//    }
//}
