package com.example.oauth2authorizationserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

@Configuration
public class TestAuthorizationConfig implements AuthorizationServerConfigurer{

    @Autowired
    private ApplicationContext context;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {

        System.out.println("------");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        DataSource dataSource = context.getBean(DataSource.class);
        clients.jdbc(dataSource);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(jdbcTokenStore());

    }

    @Bean
    JdbcTokenStore jdbcTokenStore(){
        DataSource dataSource = context.getBean(DataSource.class);
        JdbcTokenStore tokenStore = new JdbcTokenStore(dataSource);
        return tokenStore;
    }

    @Bean
    DefaultTokenServices defaultTokenServices(){
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(jdbcTokenStore());
        defaultTokenServices.setReuseRefreshToken(true);

        return defaultTokenServices;
    }

}
