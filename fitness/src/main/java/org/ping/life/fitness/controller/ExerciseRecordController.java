package org.ping.life.fitness.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.ping.life.common.ApiResponse;
import org.ping.life.fitness.domain.ExerciseRecord;
import org.ping.life.fitness.service.ExerciseRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ping
 */
@RestController()
@RequestMapping("/exercise/record")
public class ExerciseRecordController {

    @Autowired
    private ExerciseRecordService exerciseRecordService;

    @PostMapping
    public ApiResponse<Boolean> createExerciseRecord(@RequestBody ExerciseRecord exerciseRecord) {
        return ApiResponse.success(exerciseRecordService.save(exerciseRecord));
    }

    @GetMapping("/{id}")
    public ApiResponse<ExerciseRecord> getExerciseRecord(@PathVariable("id") Long id) {
        return ApiResponse.success(exerciseRecordService.getById(id));
    }

    @GetMapping("/list")
    public ApiResponse<Page<ExerciseRecord>> getExerciseRecordList(ExerciseRecord exerciseRecord, Page<ExerciseRecord> page) {
        return ApiResponse.success(exerciseRecordService.page(page));
    }

    @PutMapping
    public ApiResponse<Boolean> updateExerciseRecord(@RequestBody ExerciseRecord exerciseRecord) {
        return ApiResponse.success(exerciseRecordService.updateById(exerciseRecord));
    }

    @DeleteMapping
    public ApiResponse<Boolean> deleteExerciseRecord(@RequestParam("id") Long id) {
        return ApiResponse.success(exerciseRecordService.removeById(id));
    }

}
