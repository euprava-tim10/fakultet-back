package com.borisavz.redditcloneback.common.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ListMapper {

    private final ModelMapper modelMapper;

    public <S, D> List<D> mapCollection(Collection<S> sourceList, Class<D> destinationType) {
        return sourceList.stream()
                        .map(s -> modelMapper.map(s, destinationType))
                        .collect(Collectors.toList());
    }
}
