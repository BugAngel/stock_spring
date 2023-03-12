package org.example.controller;

import org.example.bean.JsonResult;
import org.example.bean.ReturnCode;
import org.example.service.AvgLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 股票均线控制器
 */
@RestController
@RequestMapping("/avg_line")
public class AvgLineController {
    @Autowired
    private AvgLineService avgLineService;

    @GetMapping("/update_all_recent")
    public JsonResult<Boolean> updateAllRecent() {
        try {
            return new JsonResult<>(ReturnCode.SUC, avgLineService.updateRecentAllAvgLine(), "success");
        } catch (Exception e) {
            return new JsonResult<>(ReturnCode.FAIL, e.getLocalizedMessage());
        }
    }

    @GetMapping("/update_five_avg")
    public JsonResult<Boolean> updateFiveAvg(@RequestParam(value = "begin") Integer beginDate,
                                            @RequestParam(value = "end") Integer endDate) {
        try {
            return new JsonResult<>(ReturnCode.SUC, avgLineService.updateFiveAvgLine(beginDate,endDate), "success");
        } catch (Exception e) {
            return new JsonResult<>(ReturnCode.FAIL, e.getLocalizedMessage());
        }
    }

    @GetMapping("/update_ten_avg")
    public JsonResult<Boolean> updateTenAvg(@RequestParam(value = "begin") Integer beginDate,
                                            @RequestParam(value = "end") Integer endDate) {
        try {
            return new JsonResult<>(ReturnCode.SUC, avgLineService.updateTenAvgLine(beginDate,endDate), "success");
        } catch (Exception e) {
            return new JsonResult<>(ReturnCode.FAIL, e.getLocalizedMessage());
        }
    }
}
