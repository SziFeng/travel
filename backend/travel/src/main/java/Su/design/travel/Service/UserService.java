package Su.design.travel.Service;

import Su.design.travel.Entity.User;
import Su.design.travel.Entity.dto.EditReq;
import Su.design.travel.Entity.dto.LoginReq;
import Su.design.travel.Mapper.UserMapper;
import Su.design.travel.utils.result.Result;
import com.baomidou.mybatisplus.core.injector.methods.UpdateById;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * @author Szifeng
 */
@Service
public class UserService extends ServiceImpl<UserMapper,User> {

    /**
     * 通过名字查询用户
     * @param name
     * @return
     */
    public User queryByName(String name) {
        return lambdaQuery().eq(User::getUserName, name).one();
    }

    public Result<User> getCurrentUser() {
        User user =(User) SecurityUtils.getSubject().getPrincipal();
        if (user == null) {
            return Result.fail("未登录");
        }
        return Result.ok(user);
    }

    public Result login(LoginReq loginReq) {
        /**
         * 使用shiro认证
         */
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginReq.getUserName(), loginReq.getPassword());
        try {
            subject.login(token);
            User user =queryByName(loginReq.getUserName());
            user.setLastTime(new Timestamp(System.currentTimeMillis()));
            updateById(user);
            return Result.setInfo(200,"登录成功",queryByName(loginReq.getUserName()));
        } catch (UnknownAccountException e) {
            return Result.fail("用户名不存在");
        } catch (IncorrectCredentialsException e) {
            return Result.fail("密码错误");
        }
    }

    public Result register(User user) {
        User user1 = new User();
        user1.setUserName(user.getUserName())
            .setTrueName(user.getTrueName())
            .setTel(user.getTel())
            .setStatus(0)
            .setSex(user.getSex())
            .setPassword(user.getPassword())
            .setCreatedTime(new Timestamp(System.currentTimeMillis()))
            .setBirthday(user.getBirthday())
            .setRoles(0);
        save(user1);
        return Result.ok(user1);
    }

    public Result edit(EditReq req) {
        User user = getById(req.getId());
        user.setUserName(req.getUserName())
                .setBirthday(req.getBirthday())
                .setPic(req.getPic())
                .setSex(req.getSex())
                .setTel(req.getTel());
        updateById(user);
        return Result.ok(user);
    }

    public Result changePassword(Long id,String psw) {
        User user = getById(id);
        user.setPassword(psw);
        updateById(user);
        return Result.ok(user);
    }
}
