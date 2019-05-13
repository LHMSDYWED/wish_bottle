package com.lhm.star.service.impl;

import com.lhm.star.entity.model.SeckillOrder;
import com.lhm.star.mapper.SeckillOrderMapper;
import com.lhm.star.service.SeckillOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lhm
 * @date 2019/5/7 11:24
 **/
@Service
@Transactional
public class SeckillOrderServiceImpl implements SeckillOrderService {

    @Autowired
    private SeckillOrderMapper seckillOrderMapper;

    @Override
    public int insertSelective(SeckillOrder record) {
        return 0;
    }
}
