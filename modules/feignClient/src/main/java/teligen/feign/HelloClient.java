package teligen.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="HelloServer")
public interface HelloClient {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String hello();



}
