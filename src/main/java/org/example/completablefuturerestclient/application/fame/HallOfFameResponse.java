package org.example.completablefuturerestclient.application.fame;

import java.util.List;

public record HallOfFameResponse(String lastWinner, List<ArchiveWinner> archiveWinners, double requestDuration) {
}
