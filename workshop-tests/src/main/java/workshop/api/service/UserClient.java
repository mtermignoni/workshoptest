package workshop.api.service;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import workshop.api.model.ResponseJsonSuccess;

@FeignClient(url = "http://www.mocky.io/v2/5b3444063200009a31d1e354")
public interface UserClient {
    //@RequestMapping(method = RequestMethod.GET, value = "/stores")
    //List<Store> getStores();

	@RequestMapping(value = "/ResponseJsonSuccess", method = RequestMethod.GET)
    ResponseJsonSuccess getResponseJsonSuccess();
    //String version();
	
	
}
