package com.example.hotel.service.command;

import com.example.hotel.command.core.Command;

public interface CommandService {
    void execute(Command command);
    void undo();
}
