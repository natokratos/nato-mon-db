package com.tivit.api.main;

import java.sql.SQLException;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages={"com.tivit.api.entity"})
@EnableJpaRepositories(basePackages = {"com.tivit.api.repository"})
public class TivitMonDbApplication {
	@Value("${db.server.port}")
	private String dbServerPort;
	
	public static void main(String[] args) {
		SpringApplication.run(TivitMonDbApplication.class, args);
	}
	
	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server DBServer() throws SQLException {
	    return Server.createTcpServer(
	      "-tcp", "-tcpAllowOthers", "-tcpPort", dbServerPort);
	}
}
