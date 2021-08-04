package com.example.hotel.command.core;

public interface Command<ArgumentT, ResultT> {
    ResultT execute(ArgumentT argumentT);
}
