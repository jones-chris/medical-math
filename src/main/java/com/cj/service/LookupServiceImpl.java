package com.cj.service;

import com.cj.dao.LookupDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LookupServiceImpl implements LookupService {
    @Autowired private LookupDao lookupDao;


    @Override
    public Map<String, Object> getDbVersion() {
        return lookupDao.getDbVersion();
    }
}
