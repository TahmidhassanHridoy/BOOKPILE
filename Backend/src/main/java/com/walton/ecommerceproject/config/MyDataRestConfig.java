package com.walton.ecommerceproject.config;

import com.walton.ecommerceproject.entity.Product;
import com.walton.ecommerceproject.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer{
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);

        HttpMethod[] theUnsupportedAction = {HttpMethod.POST,HttpMethod.PUT, HttpMethod.DELETE};
        // disableHTTP method for Product : PUT ,Delete and Post
         config.getExposureConfiguration()
                 .forDomainType(Product.class)
                 .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedAction))
                 .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedAction));

        // disableHTTP method for ProductCategory : PUT ,Delete and Post
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedAction))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedAction));
    }
}
