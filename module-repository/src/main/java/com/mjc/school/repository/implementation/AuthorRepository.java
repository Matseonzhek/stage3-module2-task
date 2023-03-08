package com.mjc.school.repository.implementation;

import com.mjc.school.repository.interfaces.BaseRepository;
import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.repository.source.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepository implements BaseRepository<AuthorModel, Long> {

//    @Autowired
    @Qualifier("datasource")
    private final DataSource dataSource;


    public AuthorRepository(DataSource dataSource) {
        this.dataSource = DataSource.getDataSource();
    }

    @Override
    public List<AuthorModel> readAll() {
        return null;
    }

    @Override
    public Optional<AuthorModel> readById(Long id) {
        return Optional.empty();
    }

    @Override
    public AuthorModel create(AuthorModel entity) {
        return null;
    }

    @Override
    public AuthorModel update(AuthorModel entity) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public boolean existById(Long id) {
        return false;
    }
}
