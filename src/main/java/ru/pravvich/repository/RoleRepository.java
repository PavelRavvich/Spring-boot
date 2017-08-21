package ru.pravvich.repository;

import org.springframework.data.repository.CrudRepository;
import ru.pravvich.domain.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
}
