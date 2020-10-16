package tk.youngdk.quartz_demo.config.quartz;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class QuartzDataSourceConfig {
    private final Environment env;

    @PostConstruct
    public void init(){
        log.error("QuartzDataSource");
    }

    @Bean
    @QuartzDataSource
    public DataSource quartzDataSource(){
        return DataSourceBuilder
                .create()
                .url(env.getProperty("spring.datasource.quartz.url"))
                .driverClassName(env.getProperty("spring.datasource.quartz.driver-class-name"))
                .username(env.getProperty("spring.datasource.quartz.username"))
                .password(env.getProperty("spring.datasource.quartz.password"))
                .build();
    }

}
