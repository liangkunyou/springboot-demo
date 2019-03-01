package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UrlDto
 *
 * @author yezw1506
 * @date 2019-02-25
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UrlDto {

    /**
     * 链接url
     */
    private String url;
}
