package com.neusoft.bsp.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodeMaster {
    private String cdmId;
    private String codeType;
    private String description;
    private String typeCd;
    private String codeVal;
}
