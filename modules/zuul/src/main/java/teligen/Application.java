package teligen;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2018/7/25.
 */
@EnableZuulProxy
@RestController
@SpringBootApplication
@EnableDiscoveryClient
public class Application {

    @Autowired
    DiscoveryClient client;

    Logger logger = LoggerFactory.getLogger(Application.class);

    @RequestMapping("/hello")
    public String hello() {


//        List<String> services = client.getServices();
        List<ServiceInstance> list = client.getInstances("eurekaserver");
        if (list != null && list.size() > 0 ) {
            return "Hello World from zuul : " +list.get(0).getServiceId();
        }

        return "get info fail";
    }



    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
