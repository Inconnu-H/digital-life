package org.ping.life.fitness.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.ping.life.fitness.domain.ExerciseAction;

/**
 * 针对表【exercise_action(锻炼动作表)】的数据库操作Service
 *
 * @author Ping
 */
public interface ExerciseActionService extends IService<ExerciseAction> {

    Page<ExerciseAction> pageByQuery(ExerciseAction exerciseAction, int pageNum, int pageSize);
}
