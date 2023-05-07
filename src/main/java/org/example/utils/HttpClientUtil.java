package org.example.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

@Slf4j
public class HttpClientUtil {
    public static String getHttpData(String urlStr) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(urlStr);
        String res = "";
        try {
            HttpResponse getAddrResp = httpClient.execute(httpGet);
            HttpEntity entity = getAddrResp.getEntity();
            if (entity != null) {
                res = EntityUtils.toString(entity);
            }
            log.info("响应" + getAddrResp.getStatusLine());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return res;
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
        return res;
    }
}
