package es.neesis.security.repository;

import es.neesis.security.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>{
    public UserEntity findByUsername(String username);
}
