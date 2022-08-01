package hello.exception.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.DispatcherType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        DispatcherType dispatcherType = request.getDispatcherType();
        log.info("로그 인터셉터 - REQUEST - [{}] [{}]", requestURI, dispatcherType);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String requestURI = request.getRequestURI();
        DispatcherType dispatcherType = request.getDispatcherType();
        log.info("로그 인터셉터 - RESPONSE - [{}] [{}]", requestURI, dispatcherType);
        if (ex != null) {
            log.error("afterCompletion error!!", ex);
        }
    }
}
