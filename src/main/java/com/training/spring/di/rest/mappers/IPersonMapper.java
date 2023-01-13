package com.training.spring.di.rest.mappers;

import com.training.spring.di.rest.models.Address;
import com.training.spring.di.rest.models.Person;
import com.training.spring.di.rest.models.PersonInfo;
import com.training.spring.di.rest.models.Phone;
import com.training.spring.di.services.models.AddressDto;
import com.training.spring.di.services.models.PersonDto;
import com.training.spring.di.services.models.PhoneDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IPersonMapper {

    IPersonMapper personMapper = Mappers.getMapper(IPersonMapper.class);

    @Mapping(source = "password",target = "secret")
    PersonDto toPersonDto(Person person);

    PersonInfo toPersonInfo(PersonDto person);

    PersonDto toPersonDto(PersonInfo person);

    Address toAddress(AddressDto address);

    AddressDto toAddressDto(Address address);

    PhoneDto toPhoneDto(Phone phone);

    Phone toPhoneDto(PhoneDto phone);


}
