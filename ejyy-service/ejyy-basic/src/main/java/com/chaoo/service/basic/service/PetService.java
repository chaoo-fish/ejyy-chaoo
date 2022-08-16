package com.chaoo.service.basic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chaoo.service.basic.dto.PetDetail;
import com.chaoo.service.basic.entity.Pet;

public interface PetService extends IService<Pet> {
    PetDetail deatil(Integer id, Integer cid);
}