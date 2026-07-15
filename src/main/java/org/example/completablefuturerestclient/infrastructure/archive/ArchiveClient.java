package org.example.completablefuturerestclient.infrastructure.archive;

import org.example.completablefuturerestclient.application.archive.ArchiveClientInterface;
import org.example.completablefuturerestclient.application.archive.Winner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

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
        return List.of();
    }
}
