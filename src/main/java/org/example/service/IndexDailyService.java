package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.entity.IndexDaily;

public interface IndexDailyService extends IService<IndexDaily> {
    String getNextDate();
}
