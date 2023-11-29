package practice.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


//http://localhost:8080/request-header?username=hello
@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        printStartLine(req);
        printHeader(req);
        printHeaderUtils(req);

    }

    private void printStartLine(HttpServletRequest request) {
        System.out.println("--- REQUEST-LINE - start ---");
        System.out.println("request.getMethod() = " + request.getMethod());
        System.out.println("request.getProtocol() = " + request.getProtocol());
        System.out.println("request.getScheme() = " + request.getScheme());
        System.out.println("request.getRequestURL() = " + request.getRequestURL());
        System.out.println("request.getRequestURI() = " + request.getRequestURI());
        System.out.println("request.getQueryString() = " + request.getQueryString());
        System.out.println("request.isSecure() = " + request.isSecure());
        System.out.println("--- REQUEST-LINE - end ---");
        System.out.println();
    }

    private void printHeader(HttpServletRequest request) {

        System.out.println("헤더 스타트");
        request.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println(headerName + ":" + request.getHeader(headerName)));
        System.out.println("헤더 엔드");
        System.out.println();
    }

    private void printHeaderUtils(HttpServletRequest request) {

        System.out.println("헤더 편의 조회 스타트");
        System.out.println("[Host 편의 조회]");
        System.out.println("서버네임 : " + request.getServerName());
        System.out.println("서버포트 : " + request.getServerPort());
        System.out.println();

        System.out.println("[Accept-Language 편의 조회]");
        request.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " + locale));
        System.out.println("getLocale() = " + request.getLocale());
        System.out.println();

        System.out.println("[cookie 편의 조회]");
        if(request.getCookies() != null) {
            for(Cookie cookie : request.getCookies()) {
                System.out.println(cookie.getName() + ":" + cookie.getValue());
            }
        }
        System.out.println();

        System.out.println("[Content 편의 조회]");
        System.out.println("콘텐트 타입 : " + request.getContentType());
        System.out.println("콘텐트 길이 : " + request.getContentLength());
        System.out.println("인코딩 : " + request.getCharacterEncoding());

        System.out.println("헤더 편의 조회 엔드");
        System.out.println();
    }
}
