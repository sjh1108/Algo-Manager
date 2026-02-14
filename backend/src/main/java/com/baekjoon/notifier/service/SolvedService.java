package com.baekjoon.notifier.service;

import com.baekjoon.notifier.dto.SolvedRequest;
import com.baekjoon.notifier.entity.SolvedProblem;
import com.baekjoon.notifier.repository.SolvedProblemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SolvedService {

    private final SolvedProblemRepository repository;

    public void saveSolved(SolvedRequest request) {

        SolvedProblem solved = new SolvedProblem();
        solved.setUserId(request.getUserId());
        solved.setProblemNumber(request.getProblemNumber());
        solved.setSolvedAt(request.getSolvedAt());

        repository.save(solved);
    }

    public List<SolvedProblem> getAll() {
        return repository.findAll();
    }

    public List<SolvedProblem> getByUserId(String userId) {
        return repository.findByUserIdOrderBySolvedAtDesc(userId);
    }
}
