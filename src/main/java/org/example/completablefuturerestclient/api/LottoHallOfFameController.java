package org.example.completablefuturerestclient.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.completablefuturerestclient.application.fame.FameServiceInterface;
import org.example.completablefuturerestclient.application.fame.HallOfFameResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
@Tag(name = "Hall of fame", description = "Lotto winners")
public class LottoHallOfFameController {
    private final FameServiceInterface fameService;

    public LottoHallOfFameController(FameServiceInterface fameService) {
        this.fameService = fameService;
    }

    @GetMapping("/fame")
    public HallOfFameResponse getLottoHallOfFame() {
        return fameService.getHallOfFame();
    }
}
