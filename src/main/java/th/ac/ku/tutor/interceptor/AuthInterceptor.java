package th.ac.ku.tutor.interceptor;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import th.ac.ku.tutor.service.UserService;
import th.ac.ku.tutor.store.TokenStore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    private UserService userService;

    @Autowired
    public AuthInterceptor(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("X-Token");

        if (token == null || token.isEmpty()) {
            response.setStatus(HttpStatus.SC_UNAUTHORIZED);
            return false;
        }

        String email = TokenStore.getInstance().getEmail(token);
        request.setAttribute("user", userService.getUserFromEmail(email));

        return true;
    }
}
