package org.example.service.impl;

import org.example.service.OriginService;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class OriginServiceImpl implements OriginService {
    @Override
    public String getDaily() {
        return runProcess("E:\\Code\\stock\\venv\\Scripts\\python.exe E:\\Code\\stock\\origin\\get_daily.py");
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
