package com.example.baitap25_4_2026.model.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TodoDTO {
    private Long id;

    @NotBlank(message = "Noi dung khong duoc de trong")
    private String content;

    @NotNull(message = "Ngay het han khong duoc de trong")
    @FutureOrPresent(message = "Ngay het han phai la ngay hien tai hoac tuong lai")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    @NotBlank(message = "Trang thai khong duoc de trong")
    private String status;

    @NotBlank(message = "Do uu tien khong duoc de trong")
    private String priority;
}
