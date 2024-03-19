package co.edu.unbosque.solution.infra.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DbConfig {
    @Primary
    // @Bean marca un método como componenete de configuracion
    @Bean
    @Scope("singleton")
    public DataSource dataSource() {
        DriverManagerDataSource db = new DriverManagerDataSource();
        db.setDriverClassName("com.mysql.cj.jdbc.Driver");
        db.setUrl("jdbc:mysql://localhost:3306/bd_sw2pc2");
        db.setUsername("root");
        db.setPassword("1234");
        return db;
    }
}
