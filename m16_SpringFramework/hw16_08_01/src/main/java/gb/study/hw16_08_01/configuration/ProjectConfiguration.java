package gb.study.hw16_08_01.configuration;

import gb.study.hw16_08_01.aspects.RegisterUserAction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "gb.study.hw16_08_01")
@EnableAspectJAutoProxy
public class ProjectConfiguration {
    @Bean
    public RegisterUserAction registerUserAction() {
        return new RegisterUserAction();
    }
}
