package com.pablo.application.entity.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Converter
public class ListToStringConverter implements
        AttributeConverter<Set<String>, String> {

    @Override
    public String convertToDatabaseColumn(Set<String> attribute) {

        if(attribute==null) return null;

        StringBuilder builder = new StringBuilder();
        for (String word : attribute){
            builder.append(word).append(',');
        }
        return builder.toString();
    }

    @Override
    public Set<String> convertToEntityAttribute(String dbData) {
        if(dbData==null) return null;

        String[] separatedProjects= dbData.split(",");

        return new HashSet<>(Arrays.asList(separatedProjects));
    }
}
