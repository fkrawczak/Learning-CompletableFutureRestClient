package org.example.completablefuturerestclient.infrastructure.lotto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record HttpBinResponse(WinnerResponse json) {
    record WinnerResponse(String name) {}
}
