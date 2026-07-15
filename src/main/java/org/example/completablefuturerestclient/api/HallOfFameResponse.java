package org.example.completablefuturerestclient.api;

import java.util.List;

public record HallOfFameResponse(String lastWinner, List<ArchiveWinner> archiveWinners) {
}
