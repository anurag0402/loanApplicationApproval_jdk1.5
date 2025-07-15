package com.westbank.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@ComponentScan(basePackages = "com.westbank.dao")
public class SpringTestConfiguration {
}
