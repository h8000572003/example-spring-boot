package org.h800570023.order.api.rest.line;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.h800570023.order.api.rest.user.notice.NotifyRequestDTO;
import org.h800570023.order.api.rest.user.notice.NotifyService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;


@RestController
@RequiredArgsConstructor
public class LineController {

    private static final String CLIENT_ID = "88kDIn539twSiZ4XrukC2W";
    private static final String CLIENT_SECRET = "nCGH27NX66Z4WkabMRePA8SzrrFkQMKELSSsVjnC4qu";
    private static final String AUTHORIZATION_URL = "https://notify-bot.line.me/oauth/authorize";
    private static final String TOKEN_URL = "https://notify-bot.line.me/oauth/token";
    public static final String URL = "https://example-spring-boot-k5ty.onrender.com/api/callback";

    private final NotifyService notifyService;

    @GetMapping("/api/authorize")
    public ResponseEntity<Void> authorize() {
        String authorizationUrl = AUTHORIZATION_URL + "?" +
                "response_type=code&" +
                "client_id=" + CLIENT_ID + "&" +
                "redirect_uri=" + URLEncoder.encode(URL, StandardCharsets.UTF_8) + "&" +
                "scope=notify&" +
                "state=xyz";

        return ResponseEntity.status(302).location(URI.create(authorizationUrl)).build();
    }


    @GetMapping("/api/callback")
    public ResponseEntity<String> callback(@RequestParam("code") String authorizationCode) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();

        String requestBody = "grant_type=authorization_code&" +
                "code=" + authorizationCode + "&" +
                "redirect_uri=" + URLEncoder.encode(URL, StandardCharsets.UTF_8) + "&" +
                "client_id=" + CLIENT_ID + "&" +
                "client_secret=" + CLIENT_SECRET;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(TOKEN_URL))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // Parse the JSON response to get the access token
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonResponse = mapper.readTree(response.body());
        String accessToken = jsonResponse.get("access_token").asText();

        NotifyRequestDTO notifyRequestDTO = new NotifyRequestDTO();
        notifyRequestDTO.setToke(accessToken);
        notifyService.update(notifyRequestDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/"));
        return ResponseEntity.status(302).headers(headers).build();
    }
}
