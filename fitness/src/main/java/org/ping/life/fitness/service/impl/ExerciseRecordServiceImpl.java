package org.ping.life.fitness.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.ping.life.fitness.domain.ExerciseRecord;
import org.ping.life.fitness.mapper.ExerciseRecordMapper;
import org.ping.life.fitness.service.ExerciseRecordService;
import org.springframework.stereotype.Service;

/**
 * 针对表【exercise_record(锻炼记录表)】的数据库操作Service实现
 *
 * @author Ping
 */
@Service
public class ExerciseRecordServiceImpl extends ServiceImpl<ExerciseRecordMapper, ExerciseRecord>
        implements ExerciseRecordService {

    @Override
    public Page<ExerciseRecord> pageByQuery(ExerciseRecord exerciseRecord, int pageNum, int pageSize) {
        QueryWrapper<ExerciseRecord> query = new QueryWrapper<>();
        query.orderByDesc("time");
        return page(Page.of(pageNum, pageSize), query);
    }
}




