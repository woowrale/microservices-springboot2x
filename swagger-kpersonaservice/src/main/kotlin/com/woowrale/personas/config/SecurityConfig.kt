package com.woowrale.personas.config

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.access.AccessDeniedHandler
import org.springframework.stereotype.Component
import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class SecurityHandler : AccessDeniedHandler {

    /* (non-Javadoc)
     * @see org.springframework.security.web.access.AccessDeniedHandler#handle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.access.AccessDeniedException)
     */
    @Throws(IOException::class, ServletException::class)
    override fun handle(httpServletRequest: HttpServletRequest,
                        httpServletResponse: HttpServletResponse,
                        e: AccessDeniedException) {

        val auth = SecurityContextHolder.getContext().getAuthentication()

        if (auth != null) {
            logger.info("User '" + auth.getName()
                    + "' attempted to access the protected URL: "
                    + httpServletRequest.getRequestURI())
        }

        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/403")

    }

    companion object {

        /** The logger.  */
        private val logger = LoggerFactory.getLogger(SecurityHandler::class.java)
    }
}

@Configuration
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    /** The access denied handler.  */
    @Autowired
    private val accessDeniedHandler: AccessDeniedHandler? = null

    /** The user.  */
    @Value("\${security.user.name}")
    private val user: String? = null

    /** The password.  */
    @Value("\${security.user.password}")
    private val password: String? = null

    /** The role.  */
    @Value("\${security.user.role}")
    private val role: String? = null

    /* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
	 */
    @Throws(Exception::class)
    protected override fun configure(http: HttpSecurity) {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/", "/about", "/console").permitAll()
                .and().formLogin().loginPage("/login").permitAll()
                .and().logout().permitAll()
                .and().exceptionHandling().accessDeniedHandler(accessDeniedHandler)

    }

    /**
     * Configure global.
     *
     * @param auth the auth
     * @throws Exception the exception
     */
    @Autowired
    @Throws(Exception::class)
    fun configureGlobal(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication().withUser(user).password(password).roles(role)
    }
}
