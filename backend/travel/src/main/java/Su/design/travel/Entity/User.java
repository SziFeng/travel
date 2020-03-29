package Su.design.travel.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.sql.Timestamp;
import java.util.Set;

/**
 * @author Szifeng
 */
@ApiModel
@TableName("Su_user")
@Data
@Accessors(chain = true)
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    Long id;

    @ApiModelProperty("用户名")
    @TableField("user_name")
    String userName;

    @ApiModelProperty("名字")
    @TableField("true_name")
    String trueName;

    @ApiModelProperty("密码")
    @TableField("password")
    String password;

    @ApiModelProperty("头像")
    @TableField("pic")
    String pic;

    @ApiModelProperty("是否启用")
    @TableField("status")
    long status;

    @ApiModelProperty("电话")
    @TableField("tel")
    long tel;

    @ApiModelProperty("性别")
    @TableField("sex")
    Long sex;

    @ApiModelProperty("生日")
    @TableField("birthday")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp birthday;

    @ApiModelProperty("创建时间")
    @TableField("created_time")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp createdTime;

    @ApiModelProperty("上次登录时间")
    @TableField("last_time")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp lastTime;

    @ApiModelProperty("用户对应的角色")
    @TableField("roles")
    long roles;
}
