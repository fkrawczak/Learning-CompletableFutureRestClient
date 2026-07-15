package org.example.completablefuturerestclient.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.completablefuturerestclient.api.dto.ArchiveWinner;
import org.example.completablefuturerestclient.api.dto.HallOfFameResponse;
import org.example.completablefuturerestclient.application.archive.ArchiveClientInterface;
import org.example.completablefuturerestclient.application.lotto.LottoClientInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
@Tag(name = "Hall of fame", description = "Lotto winners")
public class LottoHallOfFameController {
    private final LottoClientInterface lottoClientInterface;
    private final ArchiveClientInterface archiveClientInterface;

    public LottoHallOfFameController(LottoClientInterface lottoClientInterface, ArchiveClientInterface archiveClientInterface) {
        this.lottoClientInterface = lottoClientInterface;
        this.archiveClientInterface = archiveClientInterface;
    }

    @GetMapping("/fame")
    public HallOfFameResponse getLottoHallOfFame() {
        // TODO - move those clients behind interface implementations:
        //  plan to create 2 implementations - one as below, second with CompletableFuture
        //  and learn how to easily switch interface implementations
        return new HallOfFameResponse(
                lottoClientInterface.getLastWinnerName(),
                archiveClientInterface.getArchiveWinners()
                        .stream()
                        .map(w -> new ArchiveWinner(w.name(), w.amount(), w.wonAt()))
                        .toList()
        );
    }
}
