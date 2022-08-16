package com.chaoo.service.basic.dto;

import lombok.Data;

/**
 * @Author chaoo
 * @Date: 2022/08/16/ 10:30
 *
 * 接收宠物列表的分页数据
 */
@Data
public class PetSearch {
    private Integer page_num; //  1,
    private Integer page_size; //  30,
    private Integer community_id; //  3,
    private Integer sex; //  1,
    private Boolean license; //  true,
    private String breed; //  "田园犬",
    private String coat_color; //  "白色",
    private Integer remove; //  1
}
