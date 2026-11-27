package com.devops.cicd_demo;

import org.springframework.core.env.Environment;

/**
 * @author Ravikumar.e
 *
 */
public class AppConfigMessages
{
	private final Environment appConfig;
	public AppConfigMessages(Environment appConfig) {
		super();
		this.appConfig = appConfig;
	}
	public String getRequiredFieldsMsg() {
        return appConfig.getProperty("REQUIRED_FIELDS");
	}
}
