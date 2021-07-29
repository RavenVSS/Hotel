package com.example.hotel.service.command;

import com.example.hotel.command.core.Command;
import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
public class CommandServiceImpl implements CommandService {

    private Command command;
    private Stack<Command> commandStack;

    public CommandServiceImpl() {
        this.commandStack = new Stack<Command>();
    }

    @Override
    public void execute(Command command) {
        this.command = command;
        command.execute();
        commandStack.push(command);
    }

    @Override
    public void undo() {
        Command command = commandStack.pop();
        command.undo();
    }
}
