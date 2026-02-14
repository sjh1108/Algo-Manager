package com.baekjoon.notifier.controller;

import com.baekjoon.notifier.dto.SolvedRequest;
import com.baekjoon.notifier.entity.SolvedProblem;
import com.baekjoon.notifier.service.SolvedService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SolvedController {

    private final SolvedService solvedService;

    @PostMapping("/solved")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveSolved(@Valid @RequestBody SolvedRequest request) {
        solvedService.saveSolved(request);
    }

    @GetMapping("/solved")
    public List<SolvedProblem> getSolved(
            @RequestParam(required = false) String userId) {

        if (userId == null) {
            return solvedService.getAll();
        }

        return solvedService.getByUserId(userId);
    }
}
