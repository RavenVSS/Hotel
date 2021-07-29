package com.example.hotel.command.core;

public interface Command {
    void execute();
    void undo();
}
