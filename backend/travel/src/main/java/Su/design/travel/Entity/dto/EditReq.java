package Su.design.travel.Entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author Szifeng
 * @date 2020/3/29 15:24
 */
@Data
public class EditReq {

    Long id;

    @ApiModelProperty("用户名")
    String userName;

    @ApiModelProperty("头像")
    String pic;

    @ApiModelProperty("电话")
    long tel;

    @ApiModelProperty("性别")
    Long sex;

    @ApiModelProperty("生日")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    Timestamp birthday;
}
