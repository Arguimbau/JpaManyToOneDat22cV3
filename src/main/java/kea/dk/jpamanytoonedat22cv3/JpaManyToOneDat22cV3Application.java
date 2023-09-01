package kea.dk.jpamanytoonedat22cv3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class JpaManyToOneDat22cV3Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(JpaManyToOneDat22cV3Application.class, args);
    }

}
