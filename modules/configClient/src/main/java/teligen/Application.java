package teligen;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/7/19.
 */
@Configuration
@EnableAutoConfiguration
@RestController
@EnableDiscoveryClient
public class Application {

    @Value("${foo}")
    String foo = "World";

    @RequestMapping("/")
    public String home() {
        return "Hello " + foo;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
