package com.baekjoon.notifier.repository;

import com.baekjoon.notifier.entity.SolvedProblem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolvedProblemRepository extends JpaRepository<SolvedProblem, Long> {
    List<SolvedProblem> findByUserIdOrderBySolvedAtDesc(String userId);
}
