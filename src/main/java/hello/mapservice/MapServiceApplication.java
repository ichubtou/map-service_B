package hello.mapservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class MapServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapServiceApplication.class, args);
	}

	@RequestMapping("/")
	public String home() {
		return "hello world spring";
	}
}