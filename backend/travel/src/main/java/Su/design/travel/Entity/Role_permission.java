package Su.design.travel.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Szifeng
 * @date 2020/3/29 0:10
 */
@ApiModel
@TableName("su_role_permission")
@Data
@Accessors(chain = true)
public class Role_permission {

    @TableId(value = "id", type = IdType.AUTO)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    Long id;

    @ApiModelProperty("权限id")
    @TableField("permission_id")
    String permissionId;

    @ApiModelProperty("角色id")
    @TableField("role_id")
    String roleId;
}
