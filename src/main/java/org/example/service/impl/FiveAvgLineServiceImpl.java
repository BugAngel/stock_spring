package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.dao.FiveAvgMapper;
import org.example.entity.FiveAvg;
import org.example.service.FiveAvgLineService;
import org.springframework.stereotype.Service;

@Service
public class FiveAvgLineServiceImpl extends ServiceImpl<FiveAvgMapper, FiveAvg> implements FiveAvgLineService {
}
