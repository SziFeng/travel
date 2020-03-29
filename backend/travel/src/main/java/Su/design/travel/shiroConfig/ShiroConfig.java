package Su.design.travel.shiroConfig;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Szifeng
 * @date 2020/3/29 1:54
 */
@Configuration
@Slf4j
public class ShiroConfig {


        @Bean
        public UserRealm userRealm() {
            return new UserRealm();
        }

        @Bean
        public SecurityManager securityManager() {
            return new DefaultWebSecurityManager(userRealm());
        }

        @Bean
        public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
            ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
            shiroFilterFactoryBean.setSecurityManager(securityManager);
            Map<String, String> filterChainMap = new LinkedHashMap<>();
            filterChainMap.put("/css/**", "anon");
            filterChainMap.put("/imgs/**", "anon");
            filterChainMap.put("/js/**", "anon");
            filterChainMap.put("/swagger-*/**", "anon");
            filterChainMap.put("/swagger-ui.html/**", "anon");
            filterChainMap.put("/travel/api/user/all", "authc");
            filterChainMap.put("/travel/api/user/register", "authc");
            filterChainMap.put("/travel/api/user/edit", "authc");
            filterChainMap.put("/travel/api/user/changePassword", "authc");
//            Map<String, Filter> filterMap = new LinkedHashMap<>();
//            filterMap.put("authc", new ShiroFilter());
            shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
//            shiroFilterFactoryBean.setFilters(filterMap);
            shiroFilterFactoryBean.setLoginUrl("login");
            return shiroFilterFactoryBean;
        }

}
