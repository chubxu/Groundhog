package org.chubxu.groundhog.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class MainGenerator {
    public static void main(String[] args) {
        FastAutoGenerator
                .create(
                        "jdbc:mariadb://127.0.0.1:3306/groundhog?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8&useSSL=false",
                        "root",
                        "123456")
                .globalConfig(builder -> {
                    builder.author("chubxu").outputDir("H:\\Code\\Groundhog\\groundhog-admin");
                })
                .packageConfig(builder -> {
                    builder.parent("com.chubxu.groundhog.console")    // 设置父包名
                            .moduleName("groundhog-console");
                })
                .strategyConfig(builder -> {
                    builder.addInclude("task_template") // 设置需要生成的表名
                            .addTablePrefix("t_");      // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
