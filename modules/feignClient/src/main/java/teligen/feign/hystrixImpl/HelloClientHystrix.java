package teligen.feign.hystrixImpl;

import org.springframework.stereotype.Component;
import teligen.feign.HelloClient;

@Component
public class HelloClientHystrix implements HelloClient {
    @Override
    public String hello() {
        return "hello from hystrix fallback";
    }
}
