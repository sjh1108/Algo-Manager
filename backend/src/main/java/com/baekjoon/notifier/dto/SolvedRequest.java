package com.baekjoon.notifier.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SolvedRequest {
    @NotBlank(message = "userId는 필수입니다")
    private String userId;
    @NotNull(message = "problemNumber는 필수입니다")
    private Integer problemNumber;
    @NotNull(message = "solvedAt는 필수입니다")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private LocalDateTime solvedAt;
}
