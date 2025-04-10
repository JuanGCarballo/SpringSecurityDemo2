package es.neesis.security.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import es.neesis.security.entities.AuthorizedIpsEntity;

@Repository
public interface AuthorizedIpsRepository extends CrudRepository<AuthorizedIpsEntity, Long> {
    public AuthorizedIpsEntity findByIp(String ip);
}
