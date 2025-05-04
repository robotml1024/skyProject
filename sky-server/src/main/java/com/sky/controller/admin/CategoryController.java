package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/category")
@Slf4j
@Api(tags = "菜品分类相关接口")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    @ApiOperation("新增菜品分类")
    public Result addCategory(@RequestBody CategoryDTO categoryDTO) {
        categoryService.addCategory(categoryDTO);
        return Result.success();
    }

    @GetMapping("/list")
    @ApiOperation("根据类型查询分类")
    public Result<List<Category>> listCategory(Integer type) {
        List<Category> list = categoryService.listCategory(type);

        return Result.success(list);
    }

    @GetMapping("/page")
    @ApiOperation("分类分页查询")
    public Result<PageResult> getCategoryPage(CategoryPageQueryDTO categoryPageQueryDTO) {
        PageResult pageResult = categoryService.getCategoryPage(categoryPageQueryDTO);
        return Result.success(pageResult);
    }

    @PostMapping("/status/{status}")
    @ApiOperation("启用禁用分类")
    public Result<String> updateCategoryStatus(@PathVariable Integer status, Long id) {
        categoryService.updateCategoryStatus(status, id);
        return Result.success();
    }

    @PutMapping
    @ApiOperation("修改分类")
    public Result updateCategory(@RequestBody CategoryDTO categoryDTO) {
        categoryService.updateCategory(categoryDTO);
        return Result.success();
    }

    @DeleteMapping
    @ApiOperation("根据id删除分类")
    public Result deleteCategory(Long id) {
        categoryService.deleteCategory(id);
        return Result.success();
    }

}
