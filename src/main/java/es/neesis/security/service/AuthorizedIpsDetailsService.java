package es.neesis.security.service;

import es.neesis.security.entities.AuthorizedIpsEntity;
import es.neesis.security.repository.AuthorizedIpsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorizedIpsDetailsService {

    @Autowired
    private AuthorizedIpsRepository authorizedIpsRepository;

    public boolean ipIsAuthorized(String ip) {
        AuthorizedIpsEntity ipsEntity = authorizedIpsRepository.findByIp(ip);

        return ipsEntity != null;
    }

}
