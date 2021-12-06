package com.aliorujaliyev.nosto;

import com.aliorujaliyev.config.nostoConfig;
import com.aliorujaliyev.resource.nostoResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class nostoTask extends Application<nostoConfig> {
    public static void main(String[] args) throws Exception {
        new nostoTask().run(args);
    }

    @Override
    public void run(nostoConfig configuration, Environment environment) {
        environment.jersey().register(new nostoResource());
    }
}
