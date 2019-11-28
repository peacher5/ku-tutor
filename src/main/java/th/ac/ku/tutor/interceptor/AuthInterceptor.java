package th.ac.ku.tutor.interceptor;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import th.ac.ku.tutor.model.User;
import th.ac.ku.tutor.service.AuthService;
import th.ac.ku.tutor.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    private UserService userService;
    private AuthService authService;

    @Autowired
    public AuthInterceptor(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("X-Token");

        String email;
        if (token == null || token.isEmpty() || (email = authService.getEmail(token)) == null) {
            response.setStatus(HttpStatus.SC_UNAUTHORIZED);
            return false;
        }

        User user = userService.getUserFromEmail(email);
        if (user == null) {
            response.setStatus(HttpStatus.SC_BAD_REQUEST);
            return false;
        }

        request.setAttribute("user", user);
        return true;
    }
}
