package org.example.controller;

import org.example.bean.JsonResult;
import org.example.bean.ReturnCode;
import org.example.service.OriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 源数据控制器
 */
@RestController
@RequestMapping("/origin")
public class OriginController {
    @Autowired
    private OriginService originService;

    @GetMapping("/daily")
    public JsonResult<String> getDaily() {
        try {
            return new JsonResult<>(ReturnCode.SUC, originService.getDaily(), "success");
        } catch (Exception e) {
            return new JsonResult<>(ReturnCode.FAIL, e.getLocalizedMessage());
        }
    }

    @GetMapping("/hs_const")
    public JsonResult<String> getHsConst() {
        try {
            return new JsonResult<>(ReturnCode.SUC, originService.getHsConst(), "success");
        } catch (Exception e) {
            return new JsonResult<>(ReturnCode.FAIL, e.getLocalizedMessage());
        }
    }

    @GetMapping("/stock_basic")
    public JsonResult<String> getStockBasic() {
        try {
            return new JsonResult<>(ReturnCode.SUC, originService.getStockBasic(), "success");
        } catch (Exception e) {
            return new JsonResult<>(ReturnCode.FAIL, e.getLocalizedMessage());
        }
    }

    @GetMapping("/trade_cal")
    public JsonResult<String> getTradeCal() {
        try {
            return new JsonResult<>(ReturnCode.SUC, originService.getTradeCal(), "success");
        } catch (Exception e) {
            return new JsonResult<>(ReturnCode.FAIL, e.getLocalizedMessage());
        }
    }
}
