package pl.filip850;

import org.springframework.boot.SpringApplication;

public class TestCarreserverApplication {

  public static void main(String[] args) {
    SpringApplication.from(CarreserverApplication::main).with(TestcontainersConfiguration.class).run(args);
  }

}
