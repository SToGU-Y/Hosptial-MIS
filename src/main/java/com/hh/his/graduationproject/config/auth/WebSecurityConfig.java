package com.hh.his.graduationproject.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Autowired
    private AuthenticationAccessDeniedHandler authenticationAccessDeniedHandler;

    @Autowired
    private MyAuthenticationEntryPoint myAuthenticationEntryPoint;

    @Autowired
    private MyUrlFilterInvocationSecurityMetadataSource urlFilterInvocationSecurityMetadataSource;

    @Autowired
    private MyUrlAccessDecisionManager urlAccessDecisionManager;

    @Qualifier("userDetailsService")
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/logout").antMatchers("/query/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /**
         *
         * SpringSecurity主要八个步骤
         * ①解决跨域问题
         * ②让Security永远不会创建HttpSession，他不会使用HttpSession来获取SecurityContext
         * ③请求权限配置
         * 放行注册API请求，其他任何请求都必须经过身份验证
         * ④拦截账号、密码。覆盖UsernamePasswordAuthenticationFilter
         * (其实不是覆盖，在执行原生过滤器之前会有四个过滤器方法（之前，之后等）可以设置分别执行什么操作)
         * ⑤拦截token，并检测，在UsernamePasswordAuthenticationFilter之后添加JwtAuthenticationTokenFilter
         * ⑥处理异常状况，认证失败和权限不足
         * ⑦登录，因为使用前端发送JSON方式进行登录，所以登录模式不设置也可以
         * ⑧退出
         */
        http.cors().and().csrf().disable()
                .formLogin()
                //登录页面
                /**
                 * loginProcessingUrl：这个表示配置处理登录请求的接口地址，例如你是表单登录，那么 form 表单中 action 的值就是这里填的值。
                 * loginPage：这个表示登录页的地址，例如当你访问一个需要登录后才能访问的资源时，系统就会自动给你通过重定向跳转到这个页面上来。
                 */
                .loginPage("/login")

                .and().authorizeRequests()
                    //放行路径
                    .antMatchers("/common/**").permitAll()
                .and()
                .authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setSecurityMetadataSource(urlFilterInvocationSecurityMetadataSource);
                        o.setAccessDecisionManager(urlAccessDecisionManager);
                        return o;
                    }
                })
                //注销
                .and()
                .addFilter(new MyAuthenticationFilter(authenticationManager()))
                .logout().logoutUrl("/logout").addLogoutHandler(new MyLogoutHandler())
                //关闭会话
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterAt(myUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        http.exceptionHandling().authenticationEntryPoint(myAuthenticationEntryPoint).accessDeniedHandler(authenticationAccessDeniedHandler);

    }

    @Bean
    LoginAuthenticationFilter myUsernamePasswordAuthenticationFilter() throws Exception{

        LoginAuthenticationFilter filter = new LoginAuthenticationFilter();
        filter.setAuthenticationSuccessHandler(myAuthenticationSuccessHandler);
        filter.setAuthenticationFailureHandler(myAuthenticationFailureHandler);

        return filter;
    }

    @Bean
    public PasswordEncoder password(){
        return new BCryptPasswordEncoder();
    }


}
