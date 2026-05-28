package pl.filip850;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.filip850.utils.EnvLoader;

@SpringBootApplication
public class CarreserverApplication {

  public static void main(String[] args) {
    EnvLoader.load();
    SpringApplication.run(CarreserverApplication.class, args);
  }

}
