package com.example.oauth2authorizationserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.security.oauth2.provider.TokenGranter;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.JdbcApprovalStore;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.security.oauth2.provider.password.ResourceOwnerPasswordTokenGranter;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

@Configuration
public class TestAuthorizationConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private ApplicationContext context;
    @Autowired
    private MyUserDetailService userDetailService;
    @Autowired
    private AuthenticationManager am;

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
        endpoints.userDetailsService(this.userDetailService)
        .tokenStore(getJdbcTokenStore())
        .approvalStore(approvalStore())
        .tokenGranter(tokenGranter());
        ;
    }

    @Bean
    TokenGranter tokenGranter() {
        ResourceOwnerPasswordTokenGranter resourceOwnerPasswordTokenGranter = new ResourceOwnerPasswordTokenGranter(am,getDefaultTokenServices()
        ,getClientDetailsService(),new DefaultOAuth2RequestFactory(getClientDetailsService()));
        return resourceOwnerPasswordTokenGranter;
    }

    @Bean
    ApprovalStore approvalStore() {
        DataSource dataSource = context.getBean(DataSource.class);
        return new JdbcApprovalStore(dataSource);
    }

    @Bean
    JdbcTokenStore getJdbcTokenStore(){
        DataSource dataSource = context.getBean(DataSource.class);
        JdbcTokenStore tokenStore = new JdbcTokenStore(dataSource);
        return tokenStore;
    }

    @Bean
    DefaultTokenServices getDefaultTokenServices(){
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(getJdbcTokenStore());
        defaultTokenServices.setReuseRefreshToken(true);
        return defaultTokenServices;
    }

    @Bean
    ClientDetailsService getClientDetailsService(){
        DataSource dataSource = context.getBean(DataSource.class);
        JdbcClientDetailsService clientDetailsService = new JdbcClientDetailsService(dataSource);
        return clientDetailsService;
    }


}
