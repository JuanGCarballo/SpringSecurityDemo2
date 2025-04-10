package es.neesis.security.service;

import es.neesis.security.entities.AuthorizedIpsEntity;
import es.neesis.security.entities.UserEntity;
import es.neesis.security.model.CustomUserDetails;
import es.neesis.security.repository.AuthorizedIpsRepository;
import es.neesis.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }

    public List<UserEntity> getAllUsers(String rol, String username) {
        List<UserEntity> users = userRepository.findAll();

        if (rol.equalsIgnoreCase("ADMIN")) {
            return users;
        } else if (rol.equalsIgnoreCase("GESTION")) {
            return users.stream().filter(u -> !u.getRoles().toString().equalsIgnoreCase("ADMIN")).toList();
        } else if (rol.equalsIgnoreCase("CONSULTA")) {
            return List.of(userRepository.findByUsername(username));
        } else {
            return List.of();
        }
    }

}
