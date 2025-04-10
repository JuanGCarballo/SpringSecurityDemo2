package es.neesis.security.repository;

import es.neesis.security.entities.UserEntity;
import es.neesis.security.entities.UserRoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>{
    public UserEntity findByUsername(String username);
    public List<UserEntity> findAll();
}
