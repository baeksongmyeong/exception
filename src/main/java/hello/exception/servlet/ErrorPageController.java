package hello.exception.servlet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.PatternMatchUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.PatternUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Slf4j
@Controller
@RequestMapping("/error-page")
public class ErrorPageController {

    @GetMapping("/404")

    public String errorPage404(HttpServletRequest request) {
        //log.info("errorPage404 컨트롤러");
        printErrorInfo(request);
        return "error-page/404";
    }

    @GetMapping("/500")
    public String errorPage500(HttpServletRequest request) {
        //log.info("errorPage500 컨트롤러");
        printErrorInfo(request);
        return "error-page/500";
    }

    private void printErrorInfo(HttpServletRequest request) {
        log.info("ERROR_EXCEPTION : ex=", request.getAttribute(RequestDispatcher.ERROR_EXCEPTION));
        log.info("ERROR_EXCEPTION_TYPE : [{}]", request.getAttribute(RequestDispatcher.ERROR_EXCEPTION_TYPE));
        log.info("ERROR_MESSAGE : [{}]", request.getAttribute(RequestDispatcher.ERROR_MESSAGE));
        log.info("ERROR_REQUEST_URI : [{}]", request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI));
        log.info("ERROR_SERVLET_NAME : [{}]", request.getAttribute(RequestDispatcher.ERROR_SERVLET_NAME));
        log.info("ERROR_STATUS_CODE : [{}]", request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
        log.info("dispatcherType : [{}]", request.getDispatcherType());
//        request.getAttributeNames().asIterator().forEachRemaining(name -> {
//            if (name.contains("javax.servlet.error")) {
//                log.info("[{}] : [{}]", name, request.getAttribute(name));
//            }
//        });
    }
}