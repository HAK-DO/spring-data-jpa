package config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.hedleyproctor.controller.BaseContoller;
import com.hedleyproctor.domain.BaseEntity;
import com.hedleyproctor.repository.AccountRepository;
import com.hedleyproctor.repository.BaseRepository;
import com.hedleyproctor.service.AccountService;
import com.hedleyproctor.service.BaseService;

@Configuration
@EnableJpaRepositories(basePackageClasses = {BaseRepository.class, AccountRepository.class})
@ComponentScan(basePackageClasses = { BaseContoller.class, BaseService.class, AccountService.class })
@PropertySource("classpath:app.properties")
@EnableTransactionManagement
public class ApplicationConfig {

	@Autowired Environment env;

	@Bean
	public DataSource dataSource() {
		return new DriverManagerDataSource(env.getProperty("url"), env.getProperty("username"), env.getProperty("password"));
	}


    @Bean(name = "entityManagerFactory")
    public EntityManagerFactory entityManagerFactory() {
            HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
            vendorAdapter.setDatabase(Database.MYSQL);

            LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

            Map<String, String> jpaPropertyMap = new HashMap<String, String>();
            jpaPropertyMap.put("hibernate.hbm2ddl.auto", "auto");
            jpaPropertyMap.put("hibernate.show_sql", "true");
            jpaPropertyMap.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");

            factory.setJpaPropertyMap(jpaPropertyMap);
            factory.setJpaVendorAdapter(vendorAdapter);
            factory.setPackagesToScan(BaseEntity.class.getPackage().getName());
            factory.setDataSource(dataSource());

            factory.afterPropertiesSet();

            return factory.getObject();
    }

    @Bean
    public JpaDialect jpaDialect() {
            return new HibernateJpaDialect();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
            JpaTransactionManager txManager = new JpaTransactionManager();
            txManager.setEntityManagerFactory(entityManagerFactory());
            return txManager;
    }
}
