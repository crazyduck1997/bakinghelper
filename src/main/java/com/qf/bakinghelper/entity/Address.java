package com.qf.bakinghelper.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private Integer id;
    private String addressName;
    private String addressPhone;
    private String addressMsg;
    private Integer uid;

}
