package org.example.controller;

import org.example.bean.JsonResult;
import org.example.bean.ReturnCode;
import org.example.bean.StockDailyBasic;
import org.example.entity.IndexDaily;
import org.example.service.IndexDailyService;
import org.example.service.StockDailyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stock_daily")
public class StockDailyInfoController {
    @Autowired
    StockDailyInfoService stockDailyInfoService;
    @Autowired
    IndexDailyService indexDailyService;

    @GetMapping("/daily_info")
    public JsonResult<List<StockDailyBasic>> getStockDailyInfo(@RequestParam(value = "begin") String beginDate,
                                                               @RequestParam(value = "end") String endDate,
                                                               @RequestParam(value = "ts_code", required = false, defaultValue = "") String tsCode,
                                                               @RequestParam(value = "symbol", required = false, defaultValue = "") String symbol,
                                                               @RequestParam(value = "name", required = false, defaultValue = "") String name,
                                                               @RequestParam(value = "industry", required = false, defaultValue = "") String industry) {
        try {
            return new JsonResult<>(ReturnCode.SUC, stockDailyInfoService.getStockDailyInfo(beginDate, endDate, tsCode, symbol, name, industry), "success");
        } catch (Exception e) {
            return new JsonResult<>(ReturnCode.FAIL, e.getLocalizedMessage());
        }
    }

    @GetMapping("/sh_info")
    public JsonResult<List<IndexDaily>> getShInfo(@RequestParam(value = "begin") String beginDate,
                                                  @RequestParam(value = "end") String endDate) {
        try {
            return new JsonResult<>(ReturnCode.SUC, indexDailyService.getShByTradeDate(beginDate, endDate), "success");
        } catch (Exception e) {
            return new JsonResult<>(ReturnCode.FAIL, e.getLocalizedMessage());
        }
    }

    @GetMapping("/hfq_daily_info")
    public JsonResult<List<StockDailyBasic>> getStockHfqDailyInfo(@RequestParam(value = "begin") String beginDate,
                                                                  @RequestParam(value = "end") String endDate,
                                                                  @RequestParam(value = "ts_code", required = false, defaultValue = "") String tsCode,
                                                                  @RequestParam(value = "name", required = false, defaultValue = "") String name,
                                                                  @RequestParam(value = "industry", required = false, defaultValue = "") String industry) {
        try {
            return new JsonResult<>(ReturnCode.SUC, stockDailyInfoService.getStockHfqDailyInfo(beginDate, endDate, tsCode, name, industry), "success");
        } catch (Exception e) {
            return new JsonResult<>(ReturnCode.FAIL, e.getLocalizedMessage());
        }
    }
}
