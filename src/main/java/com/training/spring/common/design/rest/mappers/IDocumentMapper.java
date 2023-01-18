package com.training.spring.common.design.rest.mappers;

import com.training.spring.common.design.Document;
import com.training.spring.common.design.rest.models.DocumentRest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IDocumentMapper {

    IDocumentMapper documentMapper = Mappers.getMapper(IDocumentMapper.class);

    Document toDocument(DocumentRest document);

}
