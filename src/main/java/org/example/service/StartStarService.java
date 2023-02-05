package org.example.service;

import org.example.bean.StartStarInfo;

import java.util.List;

public interface StartStarService {
    List<StartStarInfo> list(Integer beginDate,
                             Integer endDate,
                             Double firstThreshold,
                             Double thirdThreshold);

    List<StartStarInfo> preList(Integer beginDate,
                                Integer endDate,
                                Double firstThreshold);
}
