package Su.design.travel.shiroConfig;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Leong
 * shiro过滤器
 */
@Slf4j
public class ShiroFilter extends PermissionsAuthorizationFilter {


    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
        Subject subject = getSubject(request, response);
        // 验证是否已登录
        HttpServletRequest req = (HttpServletRequest) request;
        String sessionKey = req.getHeader("Authorization");
        log.info("Authorization:{}", sessionKey);
        String url = getPathWithinApplication(request);
        log.info("[shiroFilter isAccessAllowed]当前用户正在访问的url为 " + url);
        log.info("是否允许访问" + subject.isAuthenticated());
        if (!subject.isAuthenticated()) {
//            throw new AuthorizationException("未登录");
            return false;
        }
        return true;
    }


}
