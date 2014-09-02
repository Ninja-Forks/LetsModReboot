package com.ardor.letsmodreboot.handler;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by Ben on 8/10/2014.
 */

public class ConfigurationHandler {

    public static Configuration configuration;

    public static void init(File configFile)
    {
        //Create the configuration object from the given configuration file
        configuration = new Configuration(configFile);

        boolean configValue = false;

        try
        {
            //Load the configuration file
            configuration.load();

            //Read in properties from configuration file
            configValue = configuration.get("ForgeCraft", "configValue", true, "This is an example config value").getBoolean(true);
        }
        catch (Exception e)
        {
            //Log the exception
        }
        finally
        {
            //Save the configuration file

            if(configuration.hasChanged())
            {
                configuration.save();
            }

        }

        System.out.println("Configuration Test = " + configValue);
    }
}
