package com.chaoo.service.basic;

import com.chaoo.service.basic.entity.Pet;
import com.chaoo.service.basic.service.PetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

/**
 * @Author chaoo
 * @Date: 2022/08/16/ 11:37
 */
@SpringBootTest
public class PetTest {
    @Autowired
    private PetService petService;

    @Test
    void test(){
        List<Pet> list = petService.list();
        for (Pet pet : list) {
            System.out.println(pet.getPetType());
        }
    }
}
