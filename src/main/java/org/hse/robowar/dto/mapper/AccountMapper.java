package org.hse.robowar.dto.mapper;

import org.hse.robowar.dto.AccountDTO;
import org.hse.robowar.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper extends EntityMapper<AccountDTO, Account> {

    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "firstName", ignore = true)
    @Mapping(target = "lastName", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Override
    Account toEntity(AccountDTO dto);

    @Override
    AccountDTO toDto(Account entity);
}
