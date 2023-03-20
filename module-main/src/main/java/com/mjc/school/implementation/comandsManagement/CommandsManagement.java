package com.mjc.school.implementation.comandsManagement;

import com.mjc.school.controller.interfaces.BaseController;
import com.mjc.school.implementation.commands.ExitCommand;
import com.mjc.school.interfaces.Command;
import com.mjc.school.operations.Operations;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

import static com.mjc.school.Constants.Constants.*;

@Component
public class CommandsManagement {

    private final BaseController<NewsDtoRequest, NewsDtoResponse, Long> newsController;
    private final BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> authorController;
    private Command command;

    @Autowired
    public CommandsManagement(BaseController<NewsDtoRequest, NewsDtoResponse, Long> newsController, BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> authorController) {
        this.newsController = newsController;
        this.authorController = authorController;
    }

    public Command getCommand(Scanner scanner, Integer operationNumber) {
        Operations operations;

        operations = Arrays.stream(Operations.values())
                .filter(operation -> Objects.equals(operation.getOperationNumber(), operationNumber)).
                findFirst().get();

        if (operationNumber >= NEWS_FIRST_OPERATION && operationNumber <= NEWS_LAST_OPERATION) {
            return operations.getOperation(scanner, newsController);
        }
        if (operationNumber >= AUTHOR_FIRST_OPERATION && operationNumber <= AUTHOR_LAST_OPERATION) {
            return operations.getOperation(scanner, authorController);
        }
        return new ExitCommand();
    }
}
