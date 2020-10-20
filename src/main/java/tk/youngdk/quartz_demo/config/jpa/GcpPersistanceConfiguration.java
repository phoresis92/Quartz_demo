package tk.youngdk.quartz_demo.config.jpa;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Properties;

@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableJpaRepositories(
        basePackages = "tk.youngdk.quartz_demo.repository.gcp",
        entityManagerFactoryRef = "gcpEntityManagerFactory",
        transactionManagerRef = "gcpTransactionManager"
)
public class GcpPersistanceConfiguration {
    private final Environment env;

    @PostConstruct
    public void init(){
        log.error("PersistanceConfiguration");
    }

    @Primary
    @Bean
    public DataSource gcpDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.jpa.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.jpa.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.jpa.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.jpa.password"));

        return dataSource;
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean gcpEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(gcpDataSource());
        em.setPackagesToScan(new String[] { "tk.youngdk.quartz_demo.domain" });

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Properties props = new Properties();
        // create | create-drop | spawn | spawn-drop | update | validate | none
        props.setProperty(AvailableSettings.HBM2DDL_AUTO, env.getProperty("spring.jpa.hibernate.ddl-auto"));
        props.setProperty(AvailableSettings.POOL_SIZE, env.getProperty("spring.jpa.hibernate.pool-size"));
        props.setProperty(AvailableSettings.USE_NEW_ID_GENERATOR_MAPPINGS, env.getProperty("spring.jpa.hibernate.use-new-id-generator-mappings"));
        props.setProperty(AvailableSettings.PHYSICAL_NAMING_STRATEGY, env.getProperty("spring.jpa.hibernate.naming.physical-strategy"));

        props.setProperty(AvailableSettings.SHOW_SQL, env.getProperty("spring.jpa.properties.hibernate.show_sql"));
        props.setProperty(AvailableSettings.FORMAT_SQL, env.getProperty("spring.jpa.properties.hibernate.format_sql"));
        props.setProperty(AvailableSettings.DIALECT, env.getProperty("spring.jpa.properties.hibernate.dialect"));

        em.setJpaProperties(props);

        return em;
    }

    @Primary
    @Bean
    public PlatformTransactionManager gcpTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(gcpEntityManagerFactory().getObject());

        return transactionManager;
    }

}
