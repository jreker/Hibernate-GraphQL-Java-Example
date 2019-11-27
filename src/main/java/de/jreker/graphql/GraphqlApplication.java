package de.jreker.graphql;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphqlApplication {
	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}

}
