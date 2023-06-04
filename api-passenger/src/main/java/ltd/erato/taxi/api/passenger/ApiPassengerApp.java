package ltd.erato.taxi.api.passenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableFeignClients
public class ApiPassengerApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(ApiPassengerApp.class, args);
    }
}
