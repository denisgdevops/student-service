package com.dev.kali.apiservice.repository;

import com.dev.kali.apiservice.model.Tutorial;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

    @Override
    <S extends Tutorial> List<S> findAll(Example<S> example);

    List<Tutorial> findByPublished(boolean published);

    List<Tutorial> findByTitleContaining(String title);


}
