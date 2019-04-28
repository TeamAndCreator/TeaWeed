package com.tea.service;

import com.tea.entity.Log;
import com.tea.repository.LogRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Transactional
@Service
public class LogService {

    @Resource
    private LogRepository logRepository;

    public void save(Log log){
        logRepository.save(log);
    }


}
