package com.chaoo.service.basic.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaoo.service.basic.dto.PetDetail;
import com.chaoo.service.basic.entity.Pet;
import com.chaoo.service.basic.mapper.PetMapper;
import com.chaoo.service.basic.service.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetServiceImpl extends ServiceImpl<PetMapper, Pet> implements PetService {

    @Override
    public PetDetail deatil(Integer id, Integer cid) {
        return baseMapper.deatil(id, cid);
    }
}