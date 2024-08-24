package org.ping.life.sys.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.ping.life.common.ApiResponse;
import org.ping.life.sys.domain.SysDict;
import org.ping.life.sys.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 系统字典表
 *
 * @author Ping
 */
@RestController()
@RequestMapping("/sys/dict")
public class SysDictController {

    @Autowired
    private SysDictService sysDictService;

    @PostMapping
    public ApiResponse<Boolean> createSysDict(@RequestBody SysDict sysDict) {
        return ApiResponse.success(sysDictService.save(sysDict));
    }

    @GetMapping("/{id}")
    public ApiResponse<SysDict> listSysDict(@PathVariable("id") Long id) {
        return ApiResponse.success(sysDictService.getById(id));
    }

    @GetMapping("/list")
    public ApiResponse<Page<SysDict>> getSysDictList(SysDict sysDict, Page<SysDict> page) {
        return ApiResponse.success(sysDictService.page(page));
    }

    @PutMapping
    public ApiResponse<Boolean> updateSysDict(@RequestBody SysDict sysDict) {
        return ApiResponse.success(sysDictService.updateById(sysDict));
    }

    @DeleteMapping
    public ApiResponse<Boolean> deleteSysDict(@RequestParam("id") Long id) {
        return ApiResponse.success(sysDictService.removeById(id));
    }

}
