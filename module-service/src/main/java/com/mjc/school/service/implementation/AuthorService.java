package com.mjc.school.service.implementation;

import com.mjc.school.repository.implementation.AuthorRepository;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;
import com.mjc.school.service.interfaces.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements BaseService<AuthorDtoRequest, AuthorDtoResponse, Long> {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<AuthorDtoResponse> readAll() {
        return null;
    }

    @Override
    public AuthorDtoResponse readById(Long id) {
        return null;
    }

    @Override
    public AuthorDtoResponse create(AuthorDtoRequest createRequest) {
        return null;
    }

    @Override
    public AuthorDtoResponse update(AuthorDtoRequest updateRequest) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
