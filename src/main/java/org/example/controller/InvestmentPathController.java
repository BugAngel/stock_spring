package org.example.controller;

import org.example.bean.JsonResult;
import org.example.bean.ReturnCode;
import org.example.bean.TwoYearHighBean;
import org.example.service.InvestmentPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 投资正途相关指标
 */
@RestController
@RequestMapping("/investment_path")
public class InvestmentPathController {
    @Autowired
    InvestmentPathService investmentPathService;

    /**
     * 2年新高
     *
     * @param date 查询日期
     * @return 2年新高股票
     */
    @GetMapping("/two_year_high")
    public JsonResult<List<TwoYearHighBean>> twoYearHighStocks(@RequestParam(value = "date") Integer date) {
        try {
            return new JsonResult<>(ReturnCode.SUC, investmentPathService.twoYearHighStocks(date), "获取列表成功");
        } catch (Exception e) {
            return new JsonResult<>(ReturnCode.FAIL, e.getLocalizedMessage());
        }
    }

    @GetMapping("/near_two_year_high")
    public JsonResult<List<TwoYearHighBean>> nearTwoYearHighStocks(@RequestParam(value = "date") Integer date,
                                                                   @RequestParam(value = "threshold") Double threshold) {
        try {
            return new JsonResult<>(ReturnCode.SUC, investmentPathService.nearTwoYearHighStocks(date,threshold), "获取列表成功");
        } catch (Exception e) {
            return new JsonResult<>(ReturnCode.FAIL, e.getLocalizedMessage());
        }
    }
}
