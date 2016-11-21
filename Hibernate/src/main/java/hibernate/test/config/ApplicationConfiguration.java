package hibernate.test.config;

//import org.hibernate.ejb.HibernatePersistence;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by скурихин on 21.11.2016.
 */
@Configuration
@ComponentScan("hibernate.test")
@EnableJpaRepositories("hibernate.test.repository")
@EnableTransactionManagement
public class ApplicationConfiguration {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource managerDataSource = new DriverManagerDataSource(/*"jdbc:h2:./Hibernate/src/main/resources/bank-app"*/);
        managerDataSource.setDriverClassName("org.h2.Driver");
        managerDataSource.setUrl("jdbc:h2:./Hibernate/src/main/resources/bank-app");

        return managerDataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        factoryBean.setPackagesToScan(new String[]{"hibernate.test"});

        factoryBean.setJpaProperties(hibernateProperties());

//        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        factoryBean.setJpaVendorAdapter(vendorAdapter);

        return factoryBean;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect",
                "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.hbm2ddl.auto", "create-drop");
        properties.put("hibernate.show_sql", "true");
//        properties.put("hibernate.format_sql", "false");
//        properties.put("ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
        return properties;
    }
}
