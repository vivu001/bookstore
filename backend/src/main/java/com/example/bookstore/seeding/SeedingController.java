package com.example.bookstore.seeding;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeedingController {
    private SeedingService seedingService;

    public SeedingController(SeedingService seedingService) {
        this.seedingService = seedingService;
    }

    @GetMapping("/seeding")
    public String seeding() {
        return this.seedingService.seeding();
    }
}
