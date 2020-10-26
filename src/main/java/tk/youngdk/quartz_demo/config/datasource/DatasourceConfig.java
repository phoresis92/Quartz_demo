package tk.youngdk.quartz_demo.config.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;

@Configuration
public class DatasourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "datasource.ramada")
    public TypedDataSourceWrapper ramadaDataSource() {
        return new TypedDataSourceWrapper();
    }

    @Bean
    @ConfigurationProperties(prefix = "datasource.stjohns")
    public TypedDataSourceWrapper stjohnsDataSource() {
        return new TypedDataSourceWrapper();
    }

//    @Bean
//    @ConfigurationProperties(prefix = "datasource.t")
//    public TypedDataSourceWrapper tDataSource() {
//        return new TypedDataSourceWrapper();
//    }

    @Bean(name = "dataSource")
    @Autowired
    public DataSource routingDataSource(TypedDataSourceWrapper... dataSources) {

        RoutingDataSource.Builder builder = new RoutingDataSource.Builder();

        Arrays.stream(dataSources)
                .forEach(builder::addTargetDataSource);
        builder.setDefaultDataSource(DataSourceType.STJOHNS);

        return builder.build();
    }
}
