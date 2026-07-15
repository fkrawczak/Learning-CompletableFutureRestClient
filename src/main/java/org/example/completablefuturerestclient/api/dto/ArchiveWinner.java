package org.example.completablefuturerestclient.api.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record ArchiveWinner(String name, BigDecimal amount, OffsetDateTime wonAt) {
}
