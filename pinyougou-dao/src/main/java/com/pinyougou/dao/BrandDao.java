package com.pinyougou.dao;

import com.pinyougou.pojo.TbBrand;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BrandDao extends Mapper<TbBrand> {

    List<TbBrand> queryAll();

}
