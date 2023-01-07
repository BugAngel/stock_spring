package org.example.controller;

import com.github.pagehelper.PageInfo;
import org.example.bean.JsonResult;
import org.example.bean.ReturnCode;
import org.example.bean.StockDailyBasic;
import org.example.service.StartStarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/start_star")
public class StartStarController {
    @Autowired
    private StartStarService startStarService;

    @GetMapping("/list")
    public JsonResult<PageInfo<StockDailyBasic>> list(@RequestParam(value = "date") String date,
                                                      @RequestParam(value = "firstThreshold", defaultValue = "0.5") Double firstThreshold,
                                                      @RequestParam(value = "thirdThreshold", defaultValue = "0.6") Double thirdThreshold,
                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                      @RequestParam(value = "pageSize", defaultValue = "100") Integer pageSize) {
        try {
            return new JsonResult<>(ReturnCode.SUC, startStarService.list(date, firstThreshold, thirdThreshold, pageNum, pageSize), "获取列表成功");
        } catch (Exception e) {
            return new JsonResult<>(ReturnCode.FAIL, e.getLocalizedMessage());
        }
    }
}
