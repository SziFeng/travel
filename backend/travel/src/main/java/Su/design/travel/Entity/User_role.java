package Su.design.travel.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Szifeng
 * @date 2020/3/29 0:14
 */
@ApiModel
@Data
@TableName("su_user_role")
public class User_role {

    @TableId(value = "id", type = IdType.AUTO)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    Long id;

    @ApiModelProperty("用户id")
    @TableField("uid")
    String uid;

    @ApiModelProperty("角色id")
    @TableField("role_id")
    String  roleId;
}
