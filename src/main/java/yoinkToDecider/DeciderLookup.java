package yoinkToDecider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Yoink's lookup class for Decider
 * 
 * @author suzanne
 *
 */
@Service
public class DeciderLookup {
	

    private final RestTemplate restTemplate;

    public DeciderLookup(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public void getBasisSetAndFunctional(String user) throws InterruptedException {
        String url = String.format("http://localhost:8080/ytd?name=%s", user);
        List<String> results = restTemplate.getForObject(url, ArrayList.class);
        
        System.out.println(results);
    }

}
