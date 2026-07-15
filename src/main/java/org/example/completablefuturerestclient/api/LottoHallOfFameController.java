package org.example.completablefuturerestclient.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.completablefuturerestclient.application.archive.ArchiveClientInterface;
import org.example.completablefuturerestclient.application.lotto.LottoClientInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        return new HallOfFameResponse(lottoClientInterface.getLastWinnerName(), List.of());
    }
}
