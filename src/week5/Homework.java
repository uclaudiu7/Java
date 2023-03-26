package org.example;

import org.example.commands.*;
import org.example.exceptions.*;

import java.util.Scanner;

public class Homework {
    public static void main(String[] args) throws FileOpenException, CommandException {
        String currentPath = System.getProperty("user.dir") + "/src/main/java/org/example";

        Catalog catalog = new Catalog("Catalog1");
        Document document1 = new Document(1, "Document1", currentPath + "/documents/document1.txt");
        Document document2 = new Document(2, "Document2", currentPath + "/documents/document2.txt");
        Document document3 = new Document(3, "Document3", currentPath + "/documents/document3.txt");
        Document document4 = new Document(4, "Document4", currentPath + "/documents/document4.txt");
        document1.addTag("tag1", "value1");

        catalog.add(document1);
        catalog.add(document2);

        System.out.println("Type 'help' for a list of commands!");
        System.out.println("Waiting for your commands...");
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("---> ");
            String line = scanner.nextLine();
            if(line.equals("exit")){
                break;
            }
            try {
                Command command = parseInput(line, catalog, currentPath);
                command.execute();
                if(command instanceof LoadCommand){
                    catalog = LoadCommand.load();
                }
            }
            catch (CommandException e){
                System.out.println(e.getMessage());
            }
        }

    }

    private static Command parseInput(String line, Catalog catalog, String currentPath) throws CommandException{
        String[] tokens = line.split(" ");
        if(tokens.length == 0){
            throw new InvalidCommandException();
        }
        String commandName = tokens[0];
        switch (commandName){
            case "load":
                if(tokens.length != 2)
                    throw new InvalidPathException();
                return new LoadCommand(catalog, currentPath + "/saves/" + tokens[1]);
            case "list":
                return new ListCommand(catalog);
            case "view":
                if(tokens.length != 2)
                    throw new NullDocumentException();
                Document tempDocument = catalog.getDocumentById(Integer.parseInt(tokens[1]));
                return new ViewCommand(catalog, tempDocument);
            case "report":
                return new ReportCommand(catalog);
            case "help":
                return new HelpCommand();
            default:
                throw new InvalidCommandException();
        }
    }

}
