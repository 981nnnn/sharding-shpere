package com.xb.sharding;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Component;

/**
 * @ClassName ProductDao
 * @Description TODO
 * @Author xb
 * @Date 2021/8/18 15:24
 * @Version 1.0
 **/
@Mapper
@Component
public class ProductDao {
  //添加商品基本信息
  @Insert("insert into product_info(store_info_id,product_name,spec,region_code,price) value(#{storeInfoId},#{productName},#{spec},#{regionCode},#{price})")
  @Options(useGeneratedKeys = true,keyProperty = "productInfoId",keyColumn = "id")
  int insertProductInfo(ProductInfo productInfo);
  //添加商品描述信息
  @Insert("insert into product_descript(product_info_id,descript,store_info_id) value(# {productInfoId},#{descript},#{storeInfoId})")
  @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
  int insertProductDescript(ProductDescript productDescript);
}
