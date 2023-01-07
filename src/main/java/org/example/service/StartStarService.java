package org.example.service;

import com.github.pagehelper.PageInfo;
import org.example.bean.StartStarInfo;

public interface StartStarService {
    PageInfo<StartStarInfo> list(String date,
                                 Double firstThreshold,
                                 Double thirdThreshold,
                                 Integer pageNum,
                                 Integer pageSize);
}
