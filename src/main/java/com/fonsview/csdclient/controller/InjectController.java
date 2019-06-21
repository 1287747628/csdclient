package com.fonsview.csdclient.controller;

import com.alibaba.fastjson.JSON;
import com.fonsview.csdclient.service.InjectService;
import com.fonsview.csdclient.vo.InjectVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class InjectController {

    @Resource
    private InjectService injectService;

    @RequestMapping(value = "/send/task/{fcrsIP:.+}/{taskNum}", method = RequestMethod.POST)
    public String sendTask(@PathVariable String fcrsIP, @PathVariable Integer taskNum,
                           @RequestBody String body) {
        long startTime = System.currentTimeMillis();
        InjectVO injectVO = JSON.parseObject(body, InjectVO.class);
        if (taskNum != null && taskNum > 0) {
            for (int i = 0; i < taskNum; i++) {
                injectService.injectTask(fcrsIP, injectVO);
            }
        }
        long endTime = System.currentTimeMillis() - startTime;
        Map<String, String> resp = new HashMap<>();
        resp.put("resultCode", "0");
        resp.put("description", "success");
        resp.put("costTime", String.valueOf(endTime));
        return JSON.toJSONString(resp);
    }


}
