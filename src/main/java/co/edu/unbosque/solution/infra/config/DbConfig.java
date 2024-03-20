package co.edu.unbosque.solution.infra.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * The type Db config.
 */
@Configuration
public class DbConfig {
    /**
     * Data source
     *
     * @return the data source
     */
    @Primary
    // @Bean marca un método como componenete de configuracion
    @Bean
    @Scope("singleton")
    public DataSource dataSource() {
        DriverManagerDataSource db = new DriverManagerDataSource();
        db.setDriverClassName("com.mysql.cj.jdbc.Driver");
        db.setUrl("jdbc:mysql://localhost:3306/proyectoabc");
        db.setUsername("root");
        db.setPassword("1234");
        return db;
    }
    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }
}
