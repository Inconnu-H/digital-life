package org.ping.life.fitness.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.ping.life.fitness.domain.ExerciseRecord;

/**
 * 针对表【exercise_record(锻炼记录表)】的数据库操作Service
 *
 * @author Ping
 */
public interface ExerciseRecordService extends IService<ExerciseRecord> {

    Page<ExerciseRecord> pageByQuery(ExerciseRecord exerciseRecord, int pageNum, int pageSize);
}
