package com.training.spring.di.data.daos;

import com.training.spring.di.services.models.PersonDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonDao extends JpaRepository<PersonDto,Long> {
}
