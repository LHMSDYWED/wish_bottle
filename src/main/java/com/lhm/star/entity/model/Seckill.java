package com.lhm.star.entity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode
@SuppressWarnings("serial")
@ApiModel(value = "秒杀商品表")
@AllArgsConstructor
@NoArgsConstructor
public class Seckill implements Serializable {
    @ApiModelProperty("主键id")
    private Integer id;
    @ApiModelProperty("商品id")
    private String seckillId;
    @ApiModelProperty("商品标题")
    private String title;
    @ApiModelProperty("商品图片")
    private String image;
    @ApiModelProperty("商品原价格")
    private BigDecimal price;
    @ApiModelProperty("商品秒杀价格")
    private BigDecimal costPrice;
    @ApiModelProperty("剩余库存数量")
    private Long stockCount;
    @ApiModelProperty("秒杀开始时间")
    private Date startTime;
    @ApiModelProperty("秒杀结束时间")
    private Date endTime;
    @ApiModelProperty("创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;


}