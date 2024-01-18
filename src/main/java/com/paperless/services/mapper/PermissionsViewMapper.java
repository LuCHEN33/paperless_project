package com.paperless.services.mapper;

import com.paperless.persistence.entities.*;
import com.paperless.persistence.repositories.*;
import com.paperless.services.dto.PermissionsView;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class PermissionsViewMapper implements BaseMapper<AuthPermissionEntity, PermissionsView> {

    @Autowired
    private AuthUserRepository authUserRepository;
    @Autowired
    private AuthUserGroupRepository authUserGroupRepository;


    @Mapping(target = "authUserPermissions", source = "users", qualifiedByName = "usersDto")
    @Mapping(target = "authGroupPermissions", source = "groups", qualifiedByName = "groupsDto")
    abstract public AuthPermissionEntity dtoToEntity(PermissionsView dto);

    @Mapping(target = "users", source = "authUserPermissions", qualifiedByName = "usersEntity")
    @Mapping(target = "groups", source = "authGroupPermissions", qualifiedByName = "groupsEntity")
    abstract public PermissionsView entityToDto(AuthPermissionEntity entity);

    @Named("usersEntity")
    List<Integer> map1(Set<AuthUserUserPermissionsEntity> userPermissions) {
        return userPermissions.stream().map( userPermission->(int)userPermission.getUser().getId() ).toList();
    }

    @Named("groupsEntity")
    List<Integer> map2(Set<AuthGroupPermissionsEntity> groupPermissions) {
        return groupPermissions.stream().map( groupPermission->(int)groupPermission.getGroup().getId() ).toList();
    }

    @Named("usersDto")
    Set<AuthUserUserPermissionsEntity> map3(List<Integer> users) {
        Set<AuthUserUserPermissionsEntity> userPermissions = new HashSet<>();
        for (Integer user : users) {
            AuthUserUserPermissionsEntity userPermission = new AuthUserUserPermissionsEntity();
            userPermission.setUser(authUserRepository.getReferenceById(user));
            userPermissions.add(userPermission);
        }
        return userPermissions;
    }

    @Named("groupsDto")
    Set<AuthGroupPermissionsEntity> map4(List<Integer> groups) {
        Set<AuthGroupPermissionsEntity> groupPermissions = new HashSet<>();
        for (Integer group : groups) {
            AuthGroupPermissionsEntity groupPermission = new AuthGroupPermissionsEntity();
            groupPermission.setGroup(authUserGroupRepository.getReferenceById(group));
            groupPermissions.add(groupPermission);
        }
        return groupPermissions;
    }

}

