package Su.design.travel.Controller;

import Su.design.travel.Entity.User;
import Su.design.travel.Entity.dto.EditReq;
import Su.design.travel.Entity.dto.LoginReq;
import Su.design.travel.Service.UserService;
import Su.design.travel.utils.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Szifeng
 * @date 2020/3/25 00:45
 */
@RestController
@Api(value = "【测试接口】测试接口",tags = "用户控制器")
@RequestMapping("/travel/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation("查询所有")
    @GetMapping("/all")
    public Result<List<User>> queryUser(){
        return Result.ok(userService.list());
    }

    @ApiOperation("登录")
    @PostMapping("/login")
    public Result login( LoginReq loginReq){
       return userService.login(loginReq);
    }


    @ApiOperation("注销")
    @PostMapping("/logout")
    public Result logout() {
        SecurityUtils.getSubject().logout();
        return Result.ok("注销成功");
    }

    @ApiOperation("注册用户")
    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        return userService.register(user);
    }

    @ApiOperation("编辑用户")
    @PostMapping("/edit")
    public Result edit(@RequestBody EditReq editReq) {
        return userService.edit(editReq);
    }

    @ApiOperation("编辑密码")
    @PostMapping("/changePassword")
    public Result changePassword(long id,String psw) {
        return userService.changePassword(id,psw);
    }

    @ApiOperation("获取当前的用户")
    @GetMapping("/getCurrentUser")
    public Result<User> getCurrentUser(){
        return userService.getCurrentUser();
    }
}
