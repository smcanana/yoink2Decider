package yoinkToDecider;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Decider's response creator for Yoink
 * 
 * @author suzanne
 *
 */
@RestController
public class YtdController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/ytd")
    public Ytd greeting(@RequestParam(value="name", defaultValue="json") String name) {
    	
        return new Ytd(counter.incrementAndGet(),
        		String.format(template, name));
    }

}
