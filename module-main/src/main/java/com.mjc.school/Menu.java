package com.mjc.school;

import com.mjc.school.implementation.comandsManagement.CommandsManagement;
import com.mjc.school.interfaces.Command;
import com.mjc.school.operations.Operations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static com.mjc.school.Constants.Constants.*;

@Component
public class Menu {

    private final CommandsManagement commandsManagement;


    @Autowired
    public Menu(CommandsManagement commandsManagement) {
        this.commandsManagement = commandsManagement;
    }

    public void run() {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);
        while (isRunning) {
            try {
                printMenu();
                int operationNumber = getOperationNumber(scanner);
                if (operationNumber >= FIRST_OPERATION && operationNumber <=LAST_OPERATION) {
                    Command command = commandsManagement.getCommand(scanner,operationNumber);
                    isRunning = command.execute();
                } else System.out.println(WRONG_NUMBER_OF_OPERATION);
            } catch (RuntimeException e) {
                e.getCause().getMessage();
            }
        }
    }

    private void printMenu() {
        System.out.println(ENTER_NUMBER_OF_OPERATION);
        for (Operations operation : Operations.values()) {
            System.out.println(operation.getOperationNumber() + ": " + operation.getOperationName());
        }
    }

    private int getOperationNumber(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }
}
