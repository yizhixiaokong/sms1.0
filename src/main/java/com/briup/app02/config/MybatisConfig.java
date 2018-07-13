package com.briup.app02.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
/**
 * 告诉mybatis映射接口在哪个包中
 * */
@MapperScan("com.briup.app02.dao")
public class MybatisConfig {

}
