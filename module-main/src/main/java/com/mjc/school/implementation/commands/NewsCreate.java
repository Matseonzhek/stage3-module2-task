package com.mjc.school.implementation.commands;

import com.mjc.school.controller.interfaces.BaseController;
import com.mjc.school.interfaces.Command;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;

import java.util.Scanner;

import static com.mjc.school.Constants.Constants.*;

public class NewsCreate extends NewsBaseCommand implements Command {

    private final Scanner scanner;

    public NewsCreate(Scanner scanner, BaseController<NewsDtoRequest, NewsDtoResponse, Long> newsController) {
        super(newsController);
        this.scanner = scanner;
    }

    @Override
    public boolean execute() {
        System.out.println(NEWS_TITLE);
        String title = scanner.nextLine();
        System.out.println(NEWS_CONTENT);
        String content = scanner.nextLine();
        System.out.println(NEWS_AUTHOR_ID);
        long author_id = Long.parseLong(scanner.nextLine());
        NewsDtoRequest newsDtoRequest = new NewsDtoRequest(null, title, content, author_id);
        System.out.println(newsController.create(newsDtoRequest));
        return true;
    }
}
