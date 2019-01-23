package com.pinyougou.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.dao.BrandDao;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import com.pinyougou.service.Impl.BaseServiceImpl;
import com.pinyougou.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service(interfaceClass = BrandService.class)
public class BrandServiceImpl extends BaseServiceImpl<TbBrand> implements BrandService {
    @Autowired
    private BrandDao brandDao;


    @Override
    public List<TbBrand> testPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return brandDao.selectAll();
    }

    @Override
    public PageResult search(Integer page, Integer rows, TbBrand tbBrand) {
        Example example = new Example(TbBrand.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(tbBrand.getFirstChar())) {
            criteria.andEqualTo("firstChar",tbBrand.getFirstChar());
        }
        if (!StringUtils.isEmpty(tbBrand.getName())) {
            criteria.andLike("name", "%" + tbBrand.getName() + "%");
        }
        PageHelper.startPage(page, rows);
        List<TbBrand> tbBrandList = brandDao.selectByExample(example);
        PageInfo<TbBrand> pageInfo = new PageInfo<>(tbBrandList);
        return new PageResult(pageInfo.getTotal(), pageInfo.getList());
    }
}
