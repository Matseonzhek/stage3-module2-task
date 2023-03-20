package com.mjc.school.implementation.commands;

import com.mjc.school.controller.interfaces.BaseController;
import com.mjc.school.interfaces.Command;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;

import java.util.Scanner;

import static com.mjc.school.Constants.Constants.AUTHOR_ID;

public class AuthorGetById extends AuthorBaseCommand implements Command {

    private final Scanner scanner;

    public AuthorGetById(Scanner scanner, BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> authorController) {
        super(authorController);
        this.scanner = scanner;
    }

    @Override
    public boolean execute() {
        System.out.println(AUTHOR_ID);
        long id = Long.parseLong(scanner.nextLine());
        System.out.println(authorController.readById(id));
        return true;
    }
}
