package com.vass.employees.persistence.mapper;

import com.vass.employees.domain.User;
import com.vass.employees.persistence.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "profileEntity", target = "profile")
    User toUser(UserEntity userEntity);

    List<User> toUsers(List<UserEntity> userEntities);

    @InheritInverseConfiguration
    @Mapping(target = "employeeEntity", ignore = true)
    UserEntity toUserEntity(User user);
}
