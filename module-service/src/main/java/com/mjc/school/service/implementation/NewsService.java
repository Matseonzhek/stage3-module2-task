package com.mjc.school.service.implementation;

import com.mjc.school.repository.implementation.NewsRepository;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;
import com.mjc.school.service.interfaces.BaseService;
import com.mjc.school.service.interfaces.NewsMapper;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class
NewsService implements BaseService<NewsDtoRequest, NewsDtoResponse,Long> {

    private final NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<NewsDtoResponse> readAll() {
        return NewsMapper.INSTANCE.listNewsToNewsDtoResponse(newsRepository.readAll());
    }

    @Override
    public NewsDtoResponse readById(Long id) {
        return null;
    }

    @Override
    public NewsDtoResponse create(NewsDtoRequest createRequest) {
        return null;
    }

    @Override
    public NewsDtoResponse update(NewsDtoRequest updateRequest) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }
}
