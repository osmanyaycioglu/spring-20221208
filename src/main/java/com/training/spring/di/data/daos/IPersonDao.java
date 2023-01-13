package com.training.spring.di.data.daos;

import com.training.spring.di.services.models.PersonDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IPersonDao extends JpaRepository<PersonDto, Long> {

    List<PersonDto> findBySurname(String sParam);

    List<PersonDto> findBySurnameAndName(String surname,
                                         String name);

    List<PersonDto> findBySurnameAndNameOrderBySurname(String surname,
                                                       String name);

    @Query("select p from PersonDto p where p.surname=?1")
    List<PersonDto> searchSurname(String sParam);

    @Query("select p from PersonDto p where p.surname=?1 and p.name=?2")
    List<PersonDto> searchSurnameAndName(String surname,
                                         String name);

    @Query("select p from PersonDto p where p.surname=:sn")
    List<PersonDto> searchSurname2(@Param("sn") String sParam);

    @Query("select p from PersonDto p where p.surname=:sn and p.name=:n")
    List<PersonDto> searchSurnameAndName2(@Param("sn") String surname,
                                          @Param("n") String name);

    @Query(value = "select * from person p where p.surname=:sn", nativeQuery = true)
    List<PersonDto> searchSurnameNative(@Param("sn") String sParam);

    @Query("select p.name,p.height from PersonDto p where p.surname=:sn")
    List<Object[]> searchSurname3(@Param("sn") String sParam,
                                  Pageable pageableParam);

    @Modifying
    @Transactional
    @Query("update PersonDto p set p.name=?1 where p.personId=?2")
    void updateName(String name,Long personId);

}
