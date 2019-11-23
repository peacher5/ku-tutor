package th.ac.ku.tutor.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import th.ac.ku.tutor.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("X-Token");
        System.out.println(token);
        request.setAttribute("user", new User("peranut.w@ku.th", "f", "l", "n"));
        return true;
    }
}
