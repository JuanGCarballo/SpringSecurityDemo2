package es.neesis.security.controller;

import es.neesis.security.auth.JwtUtil;
import es.neesis.security.entities.UserEntity;
import es.neesis.security.service.UserDetailsServiceImpl;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/private")
public class ListadoController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @RequestMapping(value = "/list", method = RequestMethod.GET,
            consumes = "application/x-www-form-urlencoded")
    protected RedirectView listUsers(HttpServletRequest request, HttpServletResponse response) {
        String rol = null;
        String username = null;

        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if ("jwt".equals(cookie.getName())) {
                    rol = cookie.getAttribute("Rol");
                    username = jwtUtil.extractUsername(cookie.getValue());
                    break;
                }
            }
        }

        List<UserEntity> users = userDetailsService.getAllUsers(rol, username);
        return new RedirectView("/private/list");
    }

}
