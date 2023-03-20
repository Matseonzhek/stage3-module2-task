package com.mjc.school.implementation.commands;

import com.mjc.school.controller.interfaces.BaseController;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;

public abstract class AuthorBaseCommand {

    protected final BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> authorController;

    public AuthorBaseCommand(BaseController<AuthorDtoRequest, AuthorDtoResponse, Long> authorController) {
        this.authorController = authorController;
    }
}
