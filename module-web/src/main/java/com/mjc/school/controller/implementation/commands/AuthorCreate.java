package com.mjc.school.controller.implementation.commands;

import com.mjc.school.controller.constants.Constants;
import com.mjc.school.controller.BaseController;
import com.mjc.school.controller.interfaces.Command;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;

import java.util.Scanner;


public class AuthorCreate extends AuthorBaseCommand implements Command {

    private final Scanner scanner;

    public AuthorCreate(Scanner scanner, BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> authorController) {
        super(authorController);
        this.scanner = scanner;
    }

    @Override
    public boolean execute() {
        System.out.println(Constants.AUTHOR_NAME);
        String name = scanner.nextLine();
        AuthorDtoRequest authorDtoRequest = new AuthorDtoRequest(null, name);
        System.out.println(authorController.create(authorDtoRequest));
        return true;
    }
}
