package com.mjc.school.service;

import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.exception.ValidationException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import static com.mjc.school.service.constants.Constants.*;

@Aspect
@Component
public class Validation {


    @Pointcut("execution(* com.mjc.school.service.implementation.NewsService.create(..))&&args(newsDtoRequest)")
    private void newsDtoRequestAccess(NewsDtoRequest newsDtoRequest) {
    }

    @Before(value = "@annotation(com.mjc.school.service.annotation.Validate)&&args(id)")
    private void checkAuthorId(Long id) {
        validateNumber(id, AUTHOR_ID);
        if (id > MAX_AUTHOR_ID) {
            throw new ValidationException(ERROR_VALUE_NUMBER + " " + id);
        }
    }

    @Before(value = "@annotation(com.mjc.school.service.annotation.Validate)&&args(id)")
    public void checkNewsId(Long id) {
        validateNumber(id, NEWS_ID);
    }


    //    @Before(value = "@annotation(com.mjc.school.service.annotation.Validate)&&args(newsDtoRequest)")
    @Before(value = "newsDtoRequestAccess(newsDtoRequest)", argNames = "newsDtoRequest")
    public void checkNewsDtoRequest(NewsDtoRequest newsDtoRequest) {
        validateString(newsDtoRequest.getTitle(), NEWS_ID, NEWS_TITLE_MIN, NEWS_TITLE_MAX);
        validateString(newsDtoRequest.getContent(), NEWS_ID, NEWS_CONTENT_MIN, NEWS_CONTENT_MAX);
        checkAuthorId(newsDtoRequest.getAuthorId());
    }

    @Before(value = "@annotation(com.mjc.school.service.annotation.Validate)&&args(authorDtoRequest)")
    public void checkAuthorDtoRequest(AuthorDtoRequest authorDtoRequest) {
        validateString(authorDtoRequest.getName(), AUTHOR_ID, AUTHOR_NAME_MIN, AUTHOR_NAME_MAX);
    }


    private void validateString(String value, String parameter, int minNumber, int maxNumber) {
        if (value == null) {
            throw new ValidationException(ERROR_VALUE_STRING + "(" + parameter + ")");
        }
        if (value.trim().length() < minNumber || value.trim().length() > maxNumber) {
            throw new ValidationException(ERROR_VALUE_STRING + "(" + parameter + ")");
        }
    }

    private void validateNumber(Long id, String parameter) {
        if (id == null || id < 1) {
            throw new ValidationException(ERROR_VALUE_NUMBER + "(" + parameter + ")");
        }
    }


}
