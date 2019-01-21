package com.pinyougou.service;

import com.pinyougou.pojo.TbBrand;
import com.pinyougou.vo.PageResult;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {
    T findOneById(Serializable id);

    List<T> findAll();


    PageResult findPage(Integer pageNum, Integer pageSize);

    PageResult findPageByWhere(Integer pageNum,Integer pageSize,T t);

    List<T> findByWhere(T t);

    void add(T t);

    void deleteById(Serializable []ids);

    void update(T t);


}
