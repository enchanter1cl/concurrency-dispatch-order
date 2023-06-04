package ltd.erato.taxi.service.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 订单服务
 *
 */

@EnableFeignClients
@SpringBootApplication
public class SvcOrderApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(SvcOrderApp.class, args);
        System.out.println( "Hello World!" );
    }
}
