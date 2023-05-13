package org.example.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import lombok.extern.slf4j.Slf4j;
import org.example.service.OriginService;
import org.example.utils.HttpClientUtil;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.example.Constant.OBJECT_MAPPER;

@Slf4j
@Service
public class OriginServiceImpl implements OriginService {
    @Override
    public String getDaily() {
        return runProcess("E:\\Code\\stock\\venv\\Scripts\\python.exe E:\\Code\\stock\\origin\\get_daily.py");
    }

    @Override
    public String getHfqDaily(){
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
    public String getShIndex(){
        try {
            String beginDate = "2021-01-01";
            String endDate = "2023-05-07";
            String url = "https://stockapi.com.cn/v1/index/sh?startDate="+beginDate+"&endDate="+endDate;
            String data = HttpClientUtil.getHttpData(url);
            JsonNode node = OBJECT_MAPPER.readTree(data).path("data");

            return "success";
        }catch (Exception e){
            log.error(e.getLocalizedMessage());
            return "error";
        }
    }

    public static void main(String[] args) {
        try {
            String beginDate = "2023-05-04";
            String endDate = "2023-05-07";
            String url = "https://stockapi.com.cn/v1/index/sh?startDate="+beginDate+"&endDate="+endDate;
            String data = HttpClientUtil.getHttpData(url);
            ArrayNode dataNode = (ArrayNode) OBJECT_MAPPER.readTree(data).path("data");
            for(JsonNode node : dataNode){

            }
        }catch (Exception e){
            log.error(e.getLocalizedMessage());
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
