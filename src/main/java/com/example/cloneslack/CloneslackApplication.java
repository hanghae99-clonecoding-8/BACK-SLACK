package com.example.cloneslack;

import com.example.cloneslack.model.ChatRoom;
import com.example.cloneslack.repository.ChatRoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CloneslackApplication {


    public static final String APPLICATION_LOCATIONS = "spring.config.location="
            + "classpath:application.properties";

    public static void main(String[] args) {
        new SpringApplicationBuilder(CloneslackApplication.class)
                .properties(APPLICATION_LOCATIONS)
                .run(args);

    }
//    public static void main(String[] args) {
//        SpringApplication.run(CloneslackApplication.class, args);
//    }

    @Bean
    public CommandLineRunner demo(ChatRoomRepository repository){
        return (args) -> {
            repository.save(new ChatRoom("전체 채팅방"));
        };
    }

}
