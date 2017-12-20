package com.example.oauth2authorizationserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import javax.sql.DataSource;

@Configuration
public class TestAuthorizationConfig implements AuthorizationServerConfigurer{
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {

    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        DataSource

        clients.jdbc();
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

    }
}
