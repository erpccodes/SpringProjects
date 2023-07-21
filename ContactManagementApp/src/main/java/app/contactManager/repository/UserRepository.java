package app.contactManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.contactManager.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
