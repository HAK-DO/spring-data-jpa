package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
            return new Class[] { ApplicationConfig.class, SecurityConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
            return new Class[] { WebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
            return new String[] { "/" };
    }
    
//    @Override
//    protected Filter[] getServletFilters() {
//            return new Filter[] { new OpenEntityManagerInViewFilter(), new DelegatingFilterProxy("springSecurityFilterChain") };
////            return new Filter[] { new OpenEntityManagerInViewFilter() };
//    }
}