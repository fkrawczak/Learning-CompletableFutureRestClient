package org.example.completablefuturerestclient.infrastructure.archive;

import org.example.completablefuturerestclient.application.archive.ArchiveClientInterface;
import org.example.completablefuturerestclient.application.archive.Winner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Component
public class ArchiveClient implements ArchiveClientInterface {
    // TODO - in prod inject from env variables
    private static final String BASE_URL = "http://localhost:8081";

    private final RestClient restClient;

    public ArchiveClient(RestClient.Builder builder) {
        this.restClient = builder
                .baseUrl(BASE_URL)
                .build();
    }

    @Override
    public List<Winner> getArchiveWinners() {
        HttpBinResponse response = restClient.get()
                .uri("/delay/5")
                .retrieve()
                .body(HttpBinResponse.class);

        if (response == null || response.method() == null || response.url() == null) {
            throw new IllegalStateException(
                    "Archive service returned an empty response"
            );
        }

        String name = "Archive client response from method: %s url: %s".formatted(response.method(), response.url());
        char lastSign = response.url().charAt(response.url().length() - 1);
        int lastDigit = Character.getNumericValue(lastSign);

        return List.of(new Winner(name, BigDecimal.valueOf(lastDigit), OffsetDateTime.now(ZoneOffset.UTC)));
    }
}
