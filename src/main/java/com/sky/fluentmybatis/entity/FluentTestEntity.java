package com.sky.fluentmybatis.entity;

import cn.org.atool.fluent.mybatis.annotation.FluentMybatis;
import cn.org.atool.fluent.mybatis.annotation.LogicDelete;
import cn.org.atool.fluent.mybatis.annotation.TableField;
import cn.org.atool.fluent.mybatis.annotation.TableId;
import cn.org.atool.fluent.mybatis.base.RichEntity;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * FluentTestEntity: 数据映射实体定义
 *
 * @author Powered By Fluent Mybatis
 */
@SuppressWarnings({"rawtypes", "unchecked"})
@Data
@Accessors(
    chain = true
)
@EqualsAndHashCode(
    callSuper = false
)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FluentMybatis(
    table = "fluent_test",
    schema = "mysql"
)
public class FluentTestEntity extends RichEntity {
  private static final long serialVersionUID = 1L;

  /**
   * 主键ID
   */
  @TableId("id")
  private Long id;

  /**
   * 记录创建时间
   */
  @TableField(
      value = "gmt_create",
      insert = "now()"
  )
  private Date gmtCreate;

  /**
   * 记录最后修改时间
   */
  @TableField(
      value = "gmt_modified",
      insert = "now()",
      update = "now()"
  )
  private Date gmtModified;

  /**
   * 逻辑删除标识
   */
  @TableField(
      value = "is_deleted",
      insert = "0"
  )
  @LogicDelete
  private Boolean isDeleted;

  /**
   * 年龄
   */
  @TableField("age")
  private Integer age;

  /**
   * 邮箱
   */
  @TableField("email")
  private String email;

  /**
   * 姓名
   */
  @TableField("name")
  private String name;

  @Override
  public final Class entityClass() {
    return FluentTestEntity.class;
  }
}
