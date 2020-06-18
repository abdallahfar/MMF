package org.MMF.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;

@Configuration
@PropertySource("app.properties")
public class DataConfig {
    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean sessionFactory()
    {
        Resource config  = new ClassPathResource("hibernate.cfg.xml");
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setConfigLocation(config);
        localSessionFactoryBean.setPackagesToScan(env.getProperty("MMF.entity.package"));
        localSessionFactoryBean.setDataSource(dataSource());
        return localSessionFactoryBean;
    }

    @Bean
    public DataSource dataSource()
    {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(env.getProperty("MMF.db.driver"));
        ds.setUrl(env.getProperty("MMF.db.url"));
        ds.setUsername(env.getProperty("MMF.db.username"));
        ds.setPassword(env.getProperty("MMF.db.password"));
        return ds;
    }
}
