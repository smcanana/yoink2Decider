package yoinkToDecider;

import java.util.concurrent.Executor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableAsync
public class YTDApplication extends AsyncConfigurerSupport implements CommandLineRunner{
	
	DeciderLookup dl;

	public static void main(String[] args) {

        SpringApplication.run(YTDApplication.class, args);
        
	}

	public void run(String... args) throws Exception {
		dl.getBasisSetAndFunctional("Min");
		
	}
	
	public YTDApplication(DeciderLookup deciderLookup){
		this.dl = deciderLookup;
	}

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("GithubLookup-");
        executor.initialize();
        return executor;
    }

}
