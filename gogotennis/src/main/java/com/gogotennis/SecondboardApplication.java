package com.gogotennis;

import javax.persistence.EntityManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.querydsl.jpa.impl.JPAQueryFactory;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class SecondboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondboardApplication.class, args);
	}

	@Bean
	JPAQueryFactory jpaQueryFactory(EntityManager entityManager) {
		return new JPAQueryFactory(entityManager);
	}

}

