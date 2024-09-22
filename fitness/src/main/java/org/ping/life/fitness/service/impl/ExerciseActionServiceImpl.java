package org.ping.life.fitness.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.ping.life.fitness.domain.ExerciseAction;
import org.ping.life.fitness.mapper.ExerciseActionMapper;
import org.ping.life.fitness.service.ExerciseActionService;
import org.springframework.stereotype.Service;

/**
 * 针对表【exercise_action(锻炼动作表)】的数据库操作Service实现
 *
 * @author Ping
 */
@Service
public class ExerciseActionServiceImpl extends ServiceImpl<ExerciseActionMapper, ExerciseAction>
        implements ExerciseActionService {

    @Override
    public Page<ExerciseAction> pageByQuery(ExerciseAction exerciseAction, int pageNum, int pageSize) {
        QueryWrapper<ExerciseAction> query = new QueryWrapper<>();
        return page(Page.of(pageNum, pageSize), query);
    }
}




