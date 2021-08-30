package github.gvnc.camunda.starter;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableProcessApplication
public class CamundaStarterApplication {

  @Autowired
  private MyCamundaService myCamundaService;

  public static void main(String... args) {
    SpringApplication.run(CamundaStarterApplication.class, args);
  }

  @PostConstruct
  private void processPostDeploy() {
    myCamundaService.getRunningProcessInstanceList();
  }
}