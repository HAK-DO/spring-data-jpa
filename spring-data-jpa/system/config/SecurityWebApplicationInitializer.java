package config;

import javax.servlet.ServletContext;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

    @Override
    public boolean enableHttpSessionEventPublisher() {
            return true;
    }

//    @Override
//    protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
//            insertFilters(servletContext, new OpenEntityManagerInViewFilter());
//    }
}