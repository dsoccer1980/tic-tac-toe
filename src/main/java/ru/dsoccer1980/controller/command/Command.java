package ru.dsoccer1980.controller.command;


public interface Command {
    boolean canProcess(String command);

    void process(String command);

}

