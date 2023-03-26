package org.example.commands;

import org.example.exceptions.CommandException;
import org.example.exceptions.FileOpenException;

public abstract class Command {
    public abstract void execute() throws CommandException, FileOpenException;
}
