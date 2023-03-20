package com.mjc.school.implementation.commands;

import com.mjc.school.controller.interfaces.BaseController;
import com.mjc.school.interfaces.Command;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;

public class NewsGetAll extends NewsBaseCommand implements Command {

    public NewsGetAll(BaseController<NewsDtoRequest, NewsDtoResponse, Long> newsController) {
        super(newsController);
    }

    @Override
    public boolean execute() {
        newsController.readAll().forEach(System.out::println);
        return true;
    }
}
