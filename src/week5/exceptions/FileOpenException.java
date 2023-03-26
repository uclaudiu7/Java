package org.example.exceptions;

public class FileOpenException extends Exception{
    public FileOpenException(){
        super("Couldn't open file!");
    }
}
