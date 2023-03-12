package org.example.controller;

import org.example.bean.JsonResult;
import org.example.bean.ReturnCode;
import org.example.bean.StartStarInfo;
import org.example.bean.StockDailyBasic;
import org.example.service.JapanCandleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 日本蜡烛图相关指标控制器
 */
@RestController
@RequestMapping("/japan_candle")
public class JapanCandleController {
    @Autowired
    private JapanCandleService japanCandleService;

    @GetMapping("/start_star_list")
    public JsonResult<List<StartStarInfo>> startStarList(@RequestParam(value = "begin") Integer beginDate,
                                                         @RequestParam(value = "end") Integer endDate,
                                                         @RequestParam(value = "firstThreshold", defaultValue = "0.5") Double firstThreshold,
                                                         @RequestParam(value = "thirdThreshold", defaultValue = "0.6") Double thirdThreshold) {
        try {
            return new JsonResult<>(ReturnCode.SUC, japanCandleService.getStartStarList(beginDate, endDate, firstThreshold, thirdThreshold), "获取列表成功");
        } catch (Exception e) {
            return new JsonResult<>(ReturnCode.FAIL, e.getLocalizedMessage());
        }
    }

    @GetMapping("/pre_start_star_list")
    public JsonResult<List<StartStarInfo>> preStartStarList(@RequestParam(value = "begin") Integer beginDate,
                                                            @RequestParam(value = "end") Integer endDate,
                                                            @RequestParam(value = "firstThreshold", defaultValue = "0.5") Double firstThreshold) {
        try {
            return new JsonResult<>(ReturnCode.SUC, japanCandleService.getPreStartStarList(beginDate, endDate, firstThreshold), "获取列表成功");
        } catch (Exception e) {
            return new JsonResult<>(ReturnCode.FAIL, e.getLocalizedMessage());
        }
    }

    @GetMapping("/hammer_list")
    public JsonResult<List<StockDailyBasic>> hammerStockList(@RequestParam(value = "begin") Integer beginDate,
                                                             @RequestParam(value = "end") Integer endDate,
                                                             @RequestParam(value = "threshold", defaultValue = "0.3") Double threshold) {
        try {
            return new JsonResult<>(ReturnCode.SUC, japanCandleService.getHammerStockList(beginDate, endDate, threshold), "获取列表成功");
        } catch (Exception e) {
            return new JsonResult<>(ReturnCode.FAIL, e.getLocalizedMessage());
        }
    }
}
