package org.example.completablefuturerestclient.application.archive;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record Winner(String name, BigDecimal amount, OffsetDateTime wonAt) {
}
