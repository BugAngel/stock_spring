package org.example.controller;

import org.example.bean.JsonResult;
import org.example.bean.ReturnCode;
import org.example.bean.StartStarInfo;
import org.example.service.StartStarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/start_star")
public class StartStarController {
    @Autowired
    private StartStarService startStarService;

    @GetMapping("/list")
    public JsonResult<List<StartStarInfo>> list(@RequestParam(value = "begin") Integer beginDate,
                                                @RequestParam(value = "end") Integer endDate,
                                                @RequestParam(value = "firstThreshold", defaultValue = "0.5") Double firstThreshold,
                                                @RequestParam(value = "thirdThreshold", defaultValue = "0.6") Double thirdThreshold) {
        try {
            return new JsonResult<>(ReturnCode.SUC, startStarService.list(beginDate, endDate, firstThreshold, thirdThreshold), "获取列表成功");
        } catch (Exception e) {
            return new JsonResult<>(ReturnCode.FAIL, e.getLocalizedMessage());
        }
    }

    @GetMapping("/pre_list")
    public JsonResult<List<StartStarInfo>> preList(@RequestParam(value = "begin") Integer beginDate,
                                                   @RequestParam(value = "end") Integer endDate,
                                                   @RequestParam(value = "firstThreshold", defaultValue = "0.5") Double firstThreshold) {
        try {
            return new JsonResult<>(ReturnCode.SUC, startStarService.preList(beginDate, endDate, firstThreshold), "获取列表成功");
        } catch (Exception e) {
            return new JsonResult<>(ReturnCode.FAIL, e.getLocalizedMessage());
        }
    }
}
