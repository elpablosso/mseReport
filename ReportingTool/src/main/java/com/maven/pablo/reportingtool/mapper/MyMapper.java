package com.maven.pablo.reportingtool.mapper;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface MyMapper<K,V> {

    K newInstanceFromDto(V dtoObject);
    V convertToDto(K object);

    default List<K> newInstanceFromDto(Collection<V> dtoObject){
        return dtoObject.stream().map(this::newInstanceFromDto).collect(Collectors.toList());
    }

    default List<V> convertToDto(Collection<K> objects) {
        return objects.stream().map(this::convertToDto).collect(Collectors.toList());
    }
}
