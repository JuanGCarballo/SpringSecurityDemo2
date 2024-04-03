package es.neesis.security.controller;

import es.neesis.security.auth.JwtUtil;
import es.neesis.security.model.AuthRequestDTO;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @RequestMapping(value = "/login", method = RequestMethod.POST,
            consumes = "application/x-www-form-urlencoded")
    public RedirectView login(AuthRequestDTO request, HttpServletResponse response) {
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        if(auth.isAuthenticated()){
            String token = jwtUtil.generateToken(request.getUsername());
            RedirectView redirectView = new RedirectView("/hello");
            redirectView.addStaticAttribute("token", token);
            response.setHeader("Authorization", "Bearer " + token);
            if(auth.getAuthorities().stream().filter(a -> a.getAuthority().equalsIgnoreCase("ADMIN")).findFirst().isPresent())
                return new RedirectView("/private/helloAdmin");
            return new RedirectView("/private/hello");
        }
        return new RedirectView("/login");
    }

}
