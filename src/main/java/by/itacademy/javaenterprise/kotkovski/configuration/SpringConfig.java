package by.itacademy.javaenterprise.kotkovski.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("by.itacademy.javaenterprise.kotkovski")
public class SpringConfig {

    @Bean
    public HikariConfig hikariConfig(@Value("${db.url}") String url,
                                     @Value("${db.username}") String userName,
                                     @Value("${dp.password}") String password,
                                     @Value("${db.driver}") String driver,
                                     @Value("${db.max.pool.size}") Integer maxPoolSize
    ) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(userName);
        config.setPassword(password);
        config.setDriverClassName(driver);
        config.setMaximumPoolSize(maxPoolSize);
        return config;
    }

    @Bean
    public HikariDataSource hikariDataSource(@Autowired HikariConfig hikariConfig) {
        return new HikariDataSource(hikariConfig);
    }




}
