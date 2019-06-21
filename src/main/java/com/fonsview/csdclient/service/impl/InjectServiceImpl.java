package com.fonsview.csdclient.service.impl;

import com.alibaba.fastjson.JSON;
import com.fonsview.csdclient.service.InjectService;
import com.fonsview.csdclient.utils.MD5Util;
import com.fonsview.csdclient.utils.http.HttpProtocolHandler;
import com.fonsview.csdclient.utils.http.HttpRequest;
import com.fonsview.csdclient.utils.http.HttpResponse;
import com.fonsview.csdclient.vo.InjectVO;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

@Service
public class InjectServiceImpl implements InjectService {

    private static final String INJECT_DELETE_URL = "/sscos/rest/v2/inject/delete";
    //
    private static final String[] URLS = {
            "http://www.baidu.com/js/aaa1.js",
            "http://www.baidu.com/js/aaa2.js",
            "http://www.baidu.com/js/aaa3.js",
            "http://www.baidu.com/js/aaa4.js",
            "http://www.baidu.com/js/aaa5.js",
            "http://www.baidu.com/js/aaa6.js",
            "http://www.baidu.com/js/aaa7.js",
            "http://www.baidu.com/js/aaa8.js",
            "http://www.baidu.com/js/aaa9.js",
            "http://www.baidu.com/js/aaa10.js",
            "http://www.baidu.com/js/aaa11.js",
            "http://www.baidu.com/js/aaa12.js",
            "http://www.baidu.com/js/aaa13.js",
            "http://www.baidu.com/js/aaa14.js",
            "http://www.baidu.com/js/aaa15.js",
            "http://www.baidu.com/js/aaa16.js",
            "http://www.baidu.com/js/aaa17.js",
            "http://www.baidu.com/js/aaa18.js",
            "http://www.baidu.com/js/aaa19.js",
            "http://www.baidu.com/js/aaa20.js",
            "http://www.baidu.com/js/aaa21.js",
            "http://www.baidu.com/js/aaa22.js",
            "http://www.baidu.com/js/aaa23.js",
            "http://www.baidu.com/js/aaa24.js",
            "http://www.baidu.com/js/aaa25.js",
            "http://www.baidu.com/js/aaa26.js",
            "http://www.baidu.com/js/aaa27.js",
            "http://www.baidu.com/js/aaa28.js",
            "http://www.baidu.com/js/aaa29.js",
            "http://www.baidu.com/js/aaa30.js",
            "http://www.baidu.com/js/aaa31.js",
            "http://www.baidu.com/js/aaa32.js",
            "http://www.baidu.com/js/aaa33.js",
            "http://www.baidu.com/js/aaa34.js",
            "http://www.baidu.com/js/aaa35.js",
            "http://www.baidu.com/js/aaa36.js",
            "http://www.baidu.com/js/aaa37.js",
            "http://www.baidu.com/js/aaa38.js",
            "http://www.baidu.com/js/aaa39.js",
            "http://www.baidu.com/js/aaa40.js",
            "http://www.baidu.com/js/aaa41.js",
            "http://www.baidu.com/js/aaa42.js",
            "http://www.baidu.com/js/aaa43.js",
            "http://www.baidu.com/js/aaa44.js",
            "http://www.baidu.com/js/aaa45.js",
            "http://www.baidu.com/js/aaa46.js",
            "http://www.baidu.com/js/aaa47.js",
            "http://www.baidu.com/js/aaa48.js",
            "http://www.baidu.com/js/aaa49.js",
            "http://www.baidu.com/js/aaa50.js",
            "http://www.baidu.com/js/aaa51.js",
            "http://www.baidu.com/js/aaa52.js",
            "http://www.baidu.com/js/aaa53.js",
            "http://www.baidu.com/js/aaa54.js",
            "http://www.baidu.com/js/aaa55.js",
            "http://www.baidu.com/js/aaa56.js",
            "http://www.baidu.com/js/aaa57.js",
            "http://www.baidu.com/js/aaa58.js",
            "http://www.baidu.com/js/aaa59.js",
            "http://www.baidu.com/js/aaa60.js",
            "http://www.baidu.com/js/aaa61.js",
            "http://www.baidu.com/js/aaa62.js",
            "http://www.baidu.com/js/aaa63.js",
            "http://www.baidu.com/js/aaa64.js",
            "http://www.baidu.com/js/aaa65.js",
            "http://www.baidu.com/js/aaa66.js",
            "http://www.baidu.com/js/aaa67.js",
            "http://www.baidu.com/js/aaa68.js",
            "http://www.baidu.com/js/aaa69.js",
            "http://www.baidu.com/js/aaa70.js",
            "http://www.baidu.com/js/aaa71.js",
            "http://www.baidu.com/js/aaa72.js",
            "http://www.baidu.com/js/aaa73.js",
            "http://www.baidu.com/js/aaa74.js",
            "http://www.baidu.com/js/aaa75.js",
            "http://www.baidu.com/js/aaa76.js",
            "http://www.baidu.com/js/aaa77.js",
            "http://www.baidu.com/js/aaa78.js",
            "http://www.baidu.com/js/aaa79.js",
            "http://www.baidu.com/js/aaa80.js",
            "http://www.baidu.com/js/aaa81.js",
            "http://www.baidu.com/js/aaa82.js",
            "http://www.baidu.com/js/aaa83.js",
            "http://www.baidu.com/js/aaa84.js",
            "http://www.baidu.com/js/aaa85.js",
            "http://www.baidu.com/js/aaa86.js",
            "http://www.baidu.com/js/aaa87.js",
            "http://www.baidu.com/js/aaa88.js",
            "http://www.baidu.com/js/aaa89.js",
            "http://www.baidu.com/js/aaa90.js",
            "http://www.baidu.com/js/aaa91.js",
            "http://www.baidu.com/js/aaa92.js",
            "http://www.baidu.com/js/aaa93.js",
            "http://www.baidu.com/js/aaa94.js",
            "http://www.baidu.com/js/aaa95.js",
            "http://www.baidu.com/js/aaa96.js",
            "http://www.baidu.com/js/aaa97.js",
            "http://www.baidu.com/js/aaa98.js",
            "http://www.baidu.com/js/aaa99.js",
            "http://www.baidu.com/js/aaa100.js"
    };


    @Async
    @Override
    public void injectTask(String fcrsIP, InjectVO injectVO) {
        try {
            InjectVO sendVO = JSON.parseObject(JSON.toJSONString(injectVO), InjectVO.class);
            String url = "http://" + fcrsIP + INJECT_DELETE_URL;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String dateStr = sdf.format(new Date());
            String signature = MD5Util.getMD5((dateStr + sendVO.getSpNo() + sendVO.getSignature()).getBytes());
            sendVO.setSignature(signature);
            sendVO.setInstances(Arrays.asList(URLS));
            //
            HttpRequest req = new HttpRequest(url, JSON.toJSONString(sendVO));
            HttpResponse resp = HttpProtocolHandler.getInstance().execute(req);
            System.out.println(Thread.currentThread().getName() + " send inject task:" + fcrsIP + " ,resultCode:" + resp.getStringResult());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
