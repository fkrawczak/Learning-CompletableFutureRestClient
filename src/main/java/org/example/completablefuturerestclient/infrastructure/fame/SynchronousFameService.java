package org.example.completablefuturerestclient.infrastructure.fame;

import org.example.completablefuturerestclient.application.archive.ArchiveClientInterface;
import org.example.completablefuturerestclient.application.fame.ArchiveWinner;
import org.example.completablefuturerestclient.application.fame.FameServiceInterface;
import org.example.completablefuturerestclient.application.fame.HallOfFameResponse;
import org.example.completablefuturerestclient.application.lotto.LottoClientInterface;
import org.springframework.stereotype.Service;

@Service
public class SynchronousFameService implements FameServiceInterface {
    private final LottoClientInterface lottoClientInterface;
    private final ArchiveClientInterface archiveClientInterface;

    public SynchronousFameService(LottoClientInterface lottoClientInterface, ArchiveClientInterface archiveClientInterface) {
        this.lottoClientInterface = lottoClientInterface;
        this.archiveClientInterface = archiveClientInterface;
    }

    @Override
    public HallOfFameResponse getHallOfFame() {
        long start = System.nanoTime();

        return new HallOfFameResponse(
                lottoClientInterface.getLastWinnerName(),
                archiveClientInterface.getArchiveWinners()
                        .stream()
                        .map(w -> new ArchiveWinner(w.name(), w.amount(), w.wonAt()))
                        .toList(),
                (System.nanoTime() - start) / 1_000_000_000.0
        );
    }
}
