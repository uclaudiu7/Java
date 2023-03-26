package org.example.exceptions;

public class NullDocumentException extends CommandException {
    public NullDocumentException() {
        super("Document cannot be null or inexistent!");
    }
}
