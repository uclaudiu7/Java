package org.example.commands;

public class HelpCommand extends Command{
    @Override
    public void execute() {
        System.out.println("Available commands: ");
        System.out.println("list - lists all documents from the catalog");
        System.out.println("view - opens a document from the catalog");
        System.out.println("load - loads a catalog from a file");
        System.out.println("report - generates a report for a document");
        System.out.println("exit - exits the application");
    }
}
