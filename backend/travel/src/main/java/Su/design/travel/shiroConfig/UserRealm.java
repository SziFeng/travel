package Su.design.travel.shiroConfig;

import Su.design.travel.Entity.Role;
import Su.design.travel.Entity.User;
import Su.design.travel.Service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Szifeng
 * @date 2020/3/28 2:57
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {


    //shiro的权限信息配置
    /*在这里写授权逻辑*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("---------------授权验证--------------");
        return null;
    }


    @Autowired
    private UserService userService;

    //根据token获取认证信息authenticationInfo
    /*在这里写认证逻辑*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        log.info("---------------开始验证--------------");
        String username = ((UsernamePasswordToken) token).getUsername();
        Object credentials = token.getCredentials();
        log.info("cred:{}",credentials);
        User user = userService.queryByName(username);
        if (user == null) {
            return null;
        }
        log.info("---------------验证结束-----------");
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }
}
