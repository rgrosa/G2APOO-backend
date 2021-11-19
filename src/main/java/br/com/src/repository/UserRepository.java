package br.com.src.repository;

import br.com.src.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findOneByUsernameAndUserStatus(String username,boolean userStatus);
}
