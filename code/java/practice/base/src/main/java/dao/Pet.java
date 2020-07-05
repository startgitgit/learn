package dao;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/7/5 18:03
 */
@Data
@Builder
public class Pet {
    private Integer id;
    private Integer ownerId;    //主人ID
    private Integer storeId;    //商店ID
    private String name;    //姓名
    private String typeName;    //类型
    private int health;    //健康值
    private int love;    //爱心值
    private Date birthday;    //生日
}
