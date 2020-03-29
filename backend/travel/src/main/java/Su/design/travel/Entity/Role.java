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

/**
 * @author Szifeng
 * @date 2020/3/27 1:22
 */
@ApiModel
@TableName("Su_role")
@Data
@Accessors(chain = true)
public class Role {

    @TableId(value = "id", type = IdType.AUTO)
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    Long id;

    @ApiModelProperty("角色名")
    @TableField("name")
    String name;

    @ApiModelProperty("角色描述")
    @TableField("description")
    String description;

}
