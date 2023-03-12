package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.dao.TenAvgMapper;
import org.example.entity.TenAvg;
import org.example.service.TenAvgLineService;
import org.springframework.stereotype.Service;

@Service
public class TenAvgLineServiceImpl extends ServiceImpl<TenAvgMapper, TenAvg> implements TenAvgLineService {
}
