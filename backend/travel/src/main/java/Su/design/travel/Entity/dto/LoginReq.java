package Su.design.travel.Entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Szifeng
 * @date 2020/3/29 2:58
 */
@Data
public class LoginReq {

    @ApiModelProperty("用户名")
    String userName;

    @ApiModelProperty("密码")
    String password;
}
