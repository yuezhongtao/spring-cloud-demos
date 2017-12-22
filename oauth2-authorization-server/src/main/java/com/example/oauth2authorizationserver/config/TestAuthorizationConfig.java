package com.example.oauth2authorizationserver.config;

import com.google.common.collect.Lists;
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
import org.springframework.security.oauth2.provider.CompositeTokenGranter;
import org.springframework.security.oauth2.provider.TokenGranter;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.JdbcApprovalStore;
import org.springframework.security.oauth2.provider.client.ClientCredentialsTokenGranter;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeTokenGranter;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.implicit.ImplicitTokenGranter;
import org.springframework.security.oauth2.provider.password.ResourceOwnerPasswordTokenGranter;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import javax.sql.DataSource;
import java.util.List;

@Configuration
public class TestAuthorizationConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private ApplicationContext context;
    @Autowired
    private MyUserDetailService userDetailService;
    @Autowired
    private AuthenticationManager am;

    private static String REALM="MY_OAUTH_REALM";

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.realm(REALM);
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
        .tokenGranter(tokenGranter())
        ;
    }

    @Bean
    TokenGranter tokenGranter() {
        List<TokenGranter> tokenGranters = Lists.newArrayList();
        ResourceOwnerPasswordTokenGranter resourceOwnerPasswordTokenGranter = new ResourceOwnerPasswordTokenGranter(am,getDefaultTokenServices()
        ,getClientDetailsService(),new DefaultOAuth2RequestFactory(getClientDetailsService()));
        ClientCredentialsTokenGranter clientCredentialsTokenGranter = new ClientCredentialsTokenGranter(getDefaultTokenServices(),getClientDetailsService(),new DefaultOAuth2RequestFactory(getClientDetailsService()));
        AuthorizationCodeTokenGranter authorizationCodeTokenGranter = new AuthorizationCodeTokenGranter(getDefaultTokenServices(),authorizationCodeServices(),getClientDetailsService(),new DefaultOAuth2RequestFactory(getClientDetailsService()));
        ImplicitTokenGranter implicitTokenGranter = new ImplicitTokenGranter(getDefaultTokenServices(),getClientDetailsService(),new DefaultOAuth2RequestFactory(getClientDetailsService()));
        tokenGranters.add(resourceOwnerPasswordTokenGranter);
        tokenGranters.add(clientCredentialsTokenGranter);
        tokenGranters.add(authorizationCodeTokenGranter);
        tokenGranters.add(implicitTokenGranter);
        return new CompositeTokenGranter(tokenGranters);
    }

    @Bean
    AuthorizationCodeServices authorizationCodeServices() {
        DataSource dataSource = context.getBean(DataSource.class);
        return new JdbcAuthorizationCodeServices(dataSource);
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
        defaultTokenServices.setAccessTokenValiditySeconds(30);
        defaultTokenServices.setAccessTokenValiditySeconds(120);
        return defaultTokenServices;
    }

    @Bean
    ClientDetailsService getClientDetailsService(){
        DataSource dataSource = context.getBean(DataSource.class);
        JdbcClientDetailsService clientDetailsService = new JdbcClientDetailsService(dataSource);
        return clientDetailsService;
    }


}
