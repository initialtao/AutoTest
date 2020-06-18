import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by test on 2020/6/15.
 */

//给SpringBootApplication托管
@SpringBootApplication
//扫描哪些包下的类进行托管管理
@ComponentScan("com.course")
public class Application {

    public static void main(String[] args){

        SpringApplication.run(Application.class,args);

    }
}
