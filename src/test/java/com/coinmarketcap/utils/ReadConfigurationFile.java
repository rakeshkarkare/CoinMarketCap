package com.coinmarketcap.utils;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;

public class ReadConfigurationFile {

    /**
     * Read Configuration file
     *
     * @return endpoint
     */

    public static String readConfigurationFile(String key) {
        EnvironmentVariables environmentVariables = Injectors.getInjector()
                .getInstance(EnvironmentVariables.class);

        return EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty(key);
    }

    public static String form_endpoint(String endpoint){
        return ReadConfigurationFile.readConfigurationFile("domain.endpoint")+
                ReadConfigurationFile.readConfigurationFile(endpoint);
    }
}
