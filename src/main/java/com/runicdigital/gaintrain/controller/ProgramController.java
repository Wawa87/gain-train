package com.runicdigital.gaintrain.controller;

import com.runicdigital.gaintrain.model.Program;

import java.time.Instant;

public class ProgramController {
    public Program createProgram(long userId, String name, Instant startAt, Instant endAt) {
        Program program = new Program();
        if (userId > 0) program.setUserId(userId);
        else throw new RuntimeException("Invalid userId");
        if (validName(name)) program.setName(name);
        else throw new RuntimeException("Invalid name");
        program.setStartAt(startAt);
        program.setEndAt(endAt);
        return program;
    }

    private boolean validName(String name) {
        return !name.isEmpty();
    }
}
