package teligen.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import teligen.feign.hystrixImpl.HelloClientHystrix;

@FeignClient(name="HelloServer",fallback = HelloClientHystrix.class)
public interface HelloClient {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String hello();

}
