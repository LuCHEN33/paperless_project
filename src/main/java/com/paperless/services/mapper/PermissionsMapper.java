package com.paperless.services.mapper;

import com.paperless.persistence.entities.*;
import com.paperless.services.dto.Permissions;
import com.paperless.services.dto.PermissionsView;
import org.mapstruct.*;



@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class PermissionsMapper implements BaseMapper<AuthUserEntity, Permissions> {

    @Mapping(target = "view", source = "id", qualifiedByName = "viewEntity")
    @Mapping(target = "change", source = "id", qualifiedByName = "changeEntity")
    abstract public Permissions entityToDto(AuthUserEntity entity);

    @Named("viewEntity")
    PermissionsView map1(Integer id) {
        if(id==null)
            return new PermissionsView();
        return new PermissionsView().addUsersItem(id);
    }

    @Named("changeEntity")
    PermissionsView map2(Integer id) {
        if(id==null)
            return new PermissionsView();
        return new PermissionsView().addUsersItem(id);
    }

}

