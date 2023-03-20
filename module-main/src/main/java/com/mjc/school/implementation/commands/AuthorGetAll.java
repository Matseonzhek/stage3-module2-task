package com.mjc.school.implementation.commands;

import com.mjc.school.controller.interfaces.BaseController;
import com.mjc.school.interfaces.Command;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;

public class AuthorGetAll extends AuthorBaseCommand implements Command {

    public AuthorGetAll(BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> authorController) {
        super(authorController);
    }

    @Override
    public boolean execute() {
        authorController.readAll().forEach(System.out::println);
        return true;
    }
}
