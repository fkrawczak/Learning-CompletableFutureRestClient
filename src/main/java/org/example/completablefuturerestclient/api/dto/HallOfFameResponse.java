package org.example.completablefuturerestclient.api.dto;

import java.util.List;

public record HallOfFameResponse(String lastWinner, List<ArchiveWinner> archiveWinners) {
}
