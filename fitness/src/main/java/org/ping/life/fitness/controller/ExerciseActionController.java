package org.ping.life.fitness.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.ping.life.common.ApiResponse;
import org.ping.life.fitness.domain.ExerciseAction;
import org.ping.life.fitness.service.ExerciseActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ping
 */
@RestController()
@RequestMapping("/exercise/action")
public class ExerciseActionController {

    @Autowired
    private ExerciseActionService exerciseActionService;

    @PostMapping
    public ApiResponse<Boolean> createExerciseAction(@RequestBody ExerciseAction exerciseAction) {
        return ApiResponse.success(exerciseActionService.save(exerciseAction));
    }

    @GetMapping("/{id}")
    public ApiResponse<ExerciseAction> getExerciseAction(@PathVariable("id") Long id) {
        return ApiResponse.success(exerciseActionService.getById(id));
    }

    @GetMapping("/list")
    public ApiResponse<Page<ExerciseAction>> getExerciseActionList(ExerciseAction exerciseAction
            , @RequestParam(required = false) Integer pageNum, @RequestParam(required = false) Integer pageSize) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? Integer.MAX_VALUE : pageSize;
        return ApiResponse.success(exerciseActionService.pageByQuery(exerciseAction, pageNum, pageSize));
    }

    @PutMapping
    public ApiResponse<Boolean> updateExerciseAction(@RequestBody ExerciseAction exerciseAction) {
        return ApiResponse.success(exerciseActionService.updateById(exerciseAction));
    }

    @DeleteMapping
    public ApiResponse<Boolean> deleteExerciseAction(@RequestParam("id") Long id) {
        return ApiResponse.success(exerciseActionService.removeById(id));
    }

}
