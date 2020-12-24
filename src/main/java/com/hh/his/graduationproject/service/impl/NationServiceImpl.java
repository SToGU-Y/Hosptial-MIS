package com.hh.his.graduationproject.service.impl;

import com.hh.his.graduationproject.dao.NationMapper;
import com.hh.his.graduationproject.model.entity.Nation;
import com.hh.his.graduationproject.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NationServiceImpl implements NationService {

    @Autowired
    private NationMapper nationMapper;

    @Override
    public List<Nation> findAllNation() {
        List<Nation> allNation = nationMapper.findAllNation();
        return allNation;
    }
}
