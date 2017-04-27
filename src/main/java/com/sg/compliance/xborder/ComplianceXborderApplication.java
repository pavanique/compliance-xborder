package com.sg.compliance.xborder;

import com.sg.compliance.xborder.web.SecurityConfiguration;
import com.sg.compliance.xborder.web.WebConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@SpringBootApplication
@Import({WebConfiguration.class,SecurityConfiguration.class})
public class ComplianceXborderApplication {
    public static final Logger LOGGER = LoggerFactory.getLogger(ComplianceXborderApplication.class);

    @Bean
    protected ServletContextListener listener() {
        return new ServletContextListener() {

            @Override
            public void contextInitialized(ServletContextEvent sce) {
                LOGGER.info("ServletContext initialized");
            }

            @Override
            public void contextDestroyed(ServletContextEvent sce) {
                LOGGER.info("ServletContext destroyed");
            }

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ComplianceXborderApplication.class, args);
    }
}
