package com.example.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/dates")
@CrossOrigin("*")
public class DateController {

    @PostMapping("/days")
    public ResponseEntity<?> getDays(@RequestBody DateRequest request) {

        int days = DateService.calculateDaysBetween(
                request.getStartDate(),
                request.getEndDate()
        );

        return ResponseEntity.ok(new DateResponse(days));
    }

    // TEST API (very important)
    @GetMapping("/test")
    public String test() {
        return "Working";
    }
}