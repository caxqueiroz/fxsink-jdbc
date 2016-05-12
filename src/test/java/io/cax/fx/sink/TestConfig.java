package io.cax.fx.sink;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by cq on 22/4/16.
 */
@Configuration
@EnableJpaRepositories(basePackages = "io.cax.fx.sink.repository")
@ComponentScan(basePackages = "io.cax.fx.sink")
@EnableAutoConfiguration(exclude=FxsinkApp.class)
public class TestConfig {


}
