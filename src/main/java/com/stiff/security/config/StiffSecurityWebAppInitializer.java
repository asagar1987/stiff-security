package com.stiff.security.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.stiff.security.config.MultipleEntriesSecurityConfig.ApiWebSecurityConfigurationAdapter;
import com.stiff.security.config.MultipleEntriesSecurityConfig.FormLoginWebSecurityConfigurerAdapter;

public class StiffSecurityWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
	@Override
	protected Class<?>[] getRootConfigClasses()
	{
		return new Class[] { StiffSecurityWebAppInitializer.class, SecurityInitializer.class, 
				MultipleEntriesSecurityConfig.class, ApiWebSecurityConfigurationAdapter.class, FormLoginWebSecurityConfigurerAdapter.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses()
	{
		return null;
	}

	@Override
	protected String[] getServletMappings()
	{
		return new String[] { "/" };
	}
}