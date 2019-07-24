package com.sysco.labs.test1.plugins;

import net.cake.apeye.beans.Component;
import net.cake.apeye.beans.HealthStatus;
import net.cake.apeye.healthPlugins.HealthExtension;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;

public class DbHealthPlugin implements HealthExtension {

    @Override
    public Component checkHealth(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://pos3-int-mysql-master.leapset.com:3306/LEAPSET",
                    "leapset_user",
                    "leapset123");

            return new Component("Leapset DB", HealthStatus.PASS, new Date());

        }

        catch(Exception e){
            return new Component("Leapset DB", HealthStatus.FAIL, new Date());
        }
    }
}



