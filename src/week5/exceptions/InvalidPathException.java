package org.example.exceptions;

public class InvalidPathException extends CommandException {
    public InvalidPathException() {
        super("Invalid path!");
    }
}
