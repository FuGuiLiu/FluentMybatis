package com.sky.fluentmybatis.controller;

import cn.org.atool.fluent.mybatis.mapper.MapperSql;
import com.google.gson.Gson;
import com.sky.fluentmybatis.Ref;
import com.sky.fluentmybatis.entity.FluentTestEntity;
import com.sky.fluentmybatis.helper.FluentTestMapping;
import com.sky.fluentmybatis.mapper.FluentTestMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @packageName:com.sky.fluentmybatis.controller
 * @ClassName:FluentController
 * @Description:
 * @Author:
 * @Data:2021/11/24@Time:11:13
 */
@Controller
public class FluentController {
	@Resource
	private FluentTestMapper fluentTestMapper;

	@RequestMapping(value = "/test")
	@ResponseBody
	public Object fluent() {
		try {
			List<FluentTestEntity> fluentTestEntities = fluentTestMapper.listEntity(fluentTestMapper.query());

			return new Gson().toJson(fluentTestEntities);
		} catch (Exception e) {
			e.printStackTrace();
			return e.toString();
		}
	}

	@RequestMapping(value = "/insert")
	@ResponseBody
	public Object insert() {
		try {
			return fluentTestMapper.insert(new FluentTestEntity());
		} catch (Exception e) {
			e.printStackTrace();
			return e.toString();
		}
	}

	@RequestMapping(value = "/assembleInsertInsert")
	@ResponseBody
	public Object AssembleInsert() {
		try {
			String sql = dynamicSql(new FluentTestEntity());
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			return e.toString();
		}
	}

	public String dynamicSql(FluentTestEntity entity) {
		MapperSql sql = new MapperSql();
		sql.INSERT_INTO("fluent_test");
		List<String> columns = new ArrayList<>();
		List<String> values = new ArrayList<>();
		FluentTestMapping fluentTestMapping = new Ref.Field.FluentTest();
		if (entity.getId() != null) {
			columns.add("id");
			values.add("#{id}");
		}
		columns.add("gmt_create");
		if (entity.getGmtCreate() != null) {
			values.add("#{gmtCreate}");
		} else {
			values.add("now()");
		}
		columns.add("gmt_modified");
		if (entity.getGmtModified() != null) {
			values.add("#{gmtModified}");
		} else {
			values.add("now()");
		}
		columns.add("is_deleted");
		if (entity.getIsDeleted() != null) {
			values.add("#{isDeleted}");
		} else {
			values.add("0");
		}
		if (entity.getAge() != null) {
			columns.add("age");
			values.add("#{age}");
		}
		if (entity.getEmail() != null) {
			columns.add("email");
			values.add("#{email}");
		}
		if (entity.getName() != null) {
			columns.add("name");
			values.add("#{name}");
		}
		sql.INSERT_COLUMNS(fluentTestMapping, columns);
		sql.VALUES();
		sql.INSERT_COLUMNS(fluentTestMapping, values);

		return sql.toString();
	}

}
