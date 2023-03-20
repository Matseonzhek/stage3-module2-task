package com.mjc.school.implementation.commands;

import com.mjc.school.controller.interfaces.BaseController;
import com.mjc.school.interfaces.Command;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;

import java.util.Scanner;

import static com.mjc.school.Constants.Constants.NEWS_ID;

public class NewsGetById extends NewsBaseCommand implements Command {

    private final Scanner scanner;
    public NewsGetById(Scanner scanner,BaseController<NewsDtoRequest, NewsDtoResponse, Long> newsController) {
        super(newsController);
        this.scanner = scanner;
    }

    @Override
    public boolean execute() {
        System.out.println(NEWS_ID);
        Long id = Long.parseLong(scanner.nextLine());
        System.out.println(newsController.readById(id));
        return true;
    }
}
