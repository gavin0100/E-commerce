package ecommerce.personal.com.interceptors;

import ecommerce.com.lib.constants.AuditMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Objects;

@Component
@RequiredArgsConstructor
@Slf4j
public class AuditInterceptor implements HandlerInterceptor {
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        request.setAttribute("audit", "afterCompletion");
        if (Objects.nonNull(ex)){
            request.setAttribute(AuditMessage.EXCEPTION, ex.getMessage());
        }
    }
}
