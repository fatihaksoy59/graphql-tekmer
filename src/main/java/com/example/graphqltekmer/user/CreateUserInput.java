package com.example.graphqltekmer.user;

import java.time.LocalDate;

public record CreateUserInput(String name, LocalDate birthDate) {}
