package org.example.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.IndexDaily;
import org.example.service.IndexDailyService;
import org.example.service.OriginService;
import org.example.utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.example.Constant.OBJECT_MAPPER;

@Slf4j
@Service
public class OriginServiceImpl implements OriginService {
    @Autowired
    IndexDailyService indexDailyService;

    @Override
    public String getDaily() {
        return runProcess("E:\\Code\\stock\\venv\\Scripts\\python.exe E:\\Code\\stock\\origin\\get_daily.py");
    }

    @Override
    public String getHfqDaily() {
        return runProcess("E:\\Code\\stock\\venv\\Scripts\\python.exe E:\\Code\\stock\\origin\\get_stock_hfq_daily.py");
    }

    @Override
    public String getHsConst() {
        return runProcess("E:\\Code\\stock\\venv\\Scripts\\python.exe E:\\Code\\stock\\origin\\get_hs_const.py");
    }

    @Override
    public String getStockBasic() {
        return runProcess("E:\\Code\\stock\\venv\\Scripts\\python.exe E:\\Code\\stock\\origin\\get_stock_basic.py");
    }

    @Override
    public String getTradeCal() {
        return runProcess("E:\\Code\\stock\\venv\\Scripts\\python.exe E:\\Code\\stock\\origin\\get_trade_cal.py");
    }

    @Override
    public String getShIndex() {
        try {
            String beginDate = indexDailyService.getNextDate();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String endDate = simpleDateFormat.format(new Date());
            String url = "https://stockapi.com.cn/v1/index/sh?startDate=" + beginDate + "&endDate=" + endDate;
            String data = HttpClientUtil.getHttpData(url);
            ArrayNode dataNode = (ArrayNode) OBJECT_MAPPER.readTree(data).path("data");
            List<IndexDaily> indexDailyList = new ArrayList<>();
            for (JsonNode node : dataNode) {
                IndexDaily indexDaily = new IndexDaily();
                indexDaily.setTsCode(node.path("code").asText() + ".SH");
                indexDaily.setTradeDate(node.path("time").asText().replace("-", ""));
                indexDaily.setOpen(BigDecimal.valueOf(node.path("open").asDouble()));
                indexDaily.setHigh(BigDecimal.valueOf(node.path("high").asDouble()));
                indexDaily.setLow(BigDecimal.valueOf(node.path("low").asDouble()));
                indexDaily.setClose(BigDecimal.valueOf(node.path("close").asDouble()));
                indexDaily.setPctChg(BigDecimal.valueOf(node.path("changeRatio").asDouble()));
                indexDaily.setVol(BigDecimal.valueOf(node.path("volume").asDouble()));
                indexDaily.setAmount(BigDecimal.valueOf(node.path("amount").asDouble()));
                indexDaily.setTurnOver(BigDecimal.valueOf(node.path("turnoverRatio").asDouble()));
                indexDaily.setChangeNum(BigDecimal.valueOf(node.path("change").asDouble()));
                indexDailyList.add(indexDaily);
            }
            indexDailyService.saveBatch(indexDailyList);
            return "success";
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            return "error";
        }
    }

    public String runProcess(String command) {
        Process process;
        try {
            process = Runtime.getRuntime().exec(command);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = in.readLine()) != null) {
                sb.append(line);
                sb.append(' ');
            }
            in.close();
            process.waitFor();
            return sb.toString();
        } catch (IOException | InterruptedException e) {
            return e.getLocalizedMessage();
        }
    }
}
