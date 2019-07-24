package com.sysco.labs.test1;


import com.sysco.labs.test1.plugins.DbHealthPlugin;
import net.cake.apeye.healthComponentRegistry.ComponentRegistry;
import net.cake.apeye.healthPlugins.URLHealthExtensionIntializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.sysco.labs","net.cake.apeye.*"})
public class Test1Application {

    public static void main(String[] args) {
        URLHealthExtensionIntializer.setDefaultHealthExtensions();
       ComponentRegistry.setHealthCheckList(new DbHealthPlugin());
       SpringApplication.run(Test1Application.class, args);
    }

}
