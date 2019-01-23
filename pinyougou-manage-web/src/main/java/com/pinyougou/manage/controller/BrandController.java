package com.pinyougou.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import com.pinyougou.vo.PageResult;
import com.pinyougou.vo.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/brand")
//controller+responseBody
@RestController
public class BrandController {
    @Reference
    private BrandService brandService;


    @GetMapping("/findPage")
    public PageResult queryAllBrands(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer rows) {
        return brandService.findPage(page, rows);
    }

    @PostMapping("/add")
    public Result addBrand(@RequestBody TbBrand tbBrand) {
        try {
            brandService.add(tbBrand);
            return Result.ok("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("添加失败");
        }
    }

    @GetMapping("/findOne")
    public TbBrand findOne(Long id) {
        return brandService.findOneById(id);
    }

    @PostMapping("/update")
    public Result update(@RequestBody TbBrand tbBrand) {
        try {
            brandService.update(tbBrand);
            return Result.ok("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("修改失败");
        }
    }

    @GetMapping("/delete")
    public Result delete(Long[] ids) {
        try {
            brandService.deleteById(ids);
            return Result.ok("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("删除失败");
        }
    }
    @PostMapping("/search")
    public PageResult search(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer rows,@RequestBody TbBrand tbBrand){
        return brandService.search(page,rows,tbBrand);
    }
}
