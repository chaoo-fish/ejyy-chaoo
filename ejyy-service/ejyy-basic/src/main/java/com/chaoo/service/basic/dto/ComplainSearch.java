package com.chaoo.service.basic.dto;

import lombok.Data;

/**
 * @Author chaoo
 * @Date: 2022/08/17/ 20:18
 */
@Data
public class ComplainSearch {
    private Integer page_num;//: 1,
    private Integer page_size;//: 5,
    private Integer community_id;//: 3,
    private Integer step;//: 1,
    private Integer type;//: 1,
    private Integer category;//: 1,
    private String refer;//: "ower",
}
