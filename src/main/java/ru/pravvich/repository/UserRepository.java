package ru.pravvich.repository;

import org.springframework.data.repository.CrudRepository;
import ru.pravvich.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}
