package org.example.completablefuturerestclient.infrastructure.lotto;

import org.example.completablefuturerestclient.application.lotto.LottoClientInterface;
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
        HttpBinResponse response = restClient.get()
                .uri("/delay/5")
                .retrieve()
                .body(HttpBinResponse.class);

        if (response == null || response.method() == null || response.url() == null) {
            throw new IllegalStateException(
                    "Lotto service returned an empty response"
            );
        }

        return "Lotto client response from method: %s url: %s".formatted(response.method(), response.url());
    }
}
