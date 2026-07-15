package org.example.completablefuturerestclient.infrastructure.lotto;

import org.example.completablefuturerestclient.application.lotto.LottoClientInterface;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class LottoClient implements LottoClientInterface {
    // TODO - in prod inject from env variables
    private static final String BASE_URL = "http://localhost:8081";

    private final RestClient restClient;

    public LottoClient(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl(BASE_URL)
                .build();
    }

    @Override
    public String getLastWinnerName() {
        String response = restClient.post()
                .uri("/delay/5")
                .contentType(MediaType.APPLICATION_JSON)
                .body(new WinnerRequest("Jan Kowalski"))
                .retrieve()
                .body(String.class);

//        if (response == null || response.json() == null) {
//            throw new IllegalStateException(
//                    "Lotto service returned an empty response"
//            );
//        }

//        return response.json().name();
        return response;
    }

    private record WinnerRequest(String name) {}
}

