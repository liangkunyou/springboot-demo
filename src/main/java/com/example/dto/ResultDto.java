package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ResultDto
 *
 * @author yezw1506
 * @date 2019-02-22
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultDto<T> implements Serializable {

    /**
     * 返回状态
     * 成功:true 失败:false
     */
    private boolean success;

    /**
     * 返回错误编号
     */
    private String code;

    /**
     * 返回错误信息
     */
    private String message;

    /**
     * 返回数据
     */
    private T date;

}
