package org.example.exceptions;

public class InvalidCommandException extends CommandException{
    public InvalidCommandException(){
        super("Invalid command!");
    }
}
