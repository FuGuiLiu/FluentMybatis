package com.sky.fluentmybatis.generated;

import cn.org.atool.generator.FileGenerator;
import cn.org.atool.generator.annotation.Table;
import cn.org.atool.generator.annotation.Tables;

public class AppEntityGenerator {
    static final String url = "jdbc:mysql://20.205.136.87:3306/mysql?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=false";

    public static void main(String[] args) {
        FileGenerator.build(Abc.class);
    }

    @Tables(
            /** 数据库连接信息 **/
            url = url, username = "root", password = "543210",
            /** Entity类parent package路径 **/
            basePack = "com.sky.fluentmybatis",
            /** Entity代码源目录 **/
            srcDir = "src/main/java",
            /** Dao代码源目录 **/
            daoDir = "src/main/java",
            /** 如果表定义记录创建，记录修改，逻辑删除字段 **/
            gmtCreated = "gmt_create", gmtModified = "gmt_modified", logicDeleted = "is_deleted",
            /** 需要生成文件的表 **/
            tables = @Table(value = {"fluent_test"})
    )
    static class Abc {
    }
}