package org.example.controller;

import org.example.bean.JsonResult;
import org.example.bean.ReturnCode;
import org.example.bean.StockDailyBasic;
import org.example.service.EntanglementTheoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 缠论
 */
@RestController
@RequestMapping("/entanglement")
public class EntanglementTheoryController {
    @Autowired
    private EntanglementTheoryService entanglementTheoryService;

    /**
     * 大趋势上升,小趋势回调
     * 上升判断标准是斜率30度至60度,回调判断标准是连续2个阴线
     *
     * @param date     时间
     * @param range    时间范围
     * @param minSlope 拟合直线最小斜率
     * @param maxSlope 拟合直线最大斜率
     * @param callback 回调幅度
     * @return 股票列表
     */
    @GetMapping("/rising_correction")
    public JsonResult<List<StockDailyBasic>> risingCorrection(@RequestParam(value = "date") Integer date,
                                                              @RequestParam(value = "range", defaultValue = "20") Integer range,
                                                              @RequestParam(value = "minSlope", defaultValue = "0.6") Double minSlope,
                                                              @RequestParam(value = "maxSlope", defaultValue = "1.7") Double maxSlope,
                                                              @RequestParam(value = "callback", defaultValue = "0.05") Double callback) {
        try {
            return new JsonResult<>(ReturnCode.SUC, entanglementTheoryService.getRisingCorrectionList(date, range, minSlope, maxSlope, callback), "获取列表成功");
        } catch (Exception e) {
            return new JsonResult<>(ReturnCode.FAIL, e.getLocalizedMessage());
        }
    }
}
