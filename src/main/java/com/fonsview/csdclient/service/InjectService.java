package com.fonsview.csdclient.service;

import com.fonsview.csdclient.vo.InjectVO;

public interface InjectService {

    void injectTask(String fcrsIP, InjectVO injectVO);
}
