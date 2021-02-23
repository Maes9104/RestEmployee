package com.vass.employees.persistence.mapper;

import com.vass.employees.domain.Profile;
import com.vass.employees.persistence.entity.ProfileEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    Profile toProfile(ProfileEntity profileEntity);

    @InheritInverseConfiguration
    @Mapping(target = "userEntities", ignore = true)
    ProfileEntity toProfileEntity(Profile profile);

}
