package ru.geekbrains.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.geekbrains.server.auth.AuthService;
import ru.geekbrains.server.auth.AuthServiceJdbcImpl;
import ru.geekbrains.server.persistance.UserRepository;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@ComponentScan
public class SpringConfig {

    @Bean
    public ChatServer chatServer(){
        return new ChatServer();
    }

    @Bean
    public AuthService authService(UserRepository userRepository){
        return  new AuthServiceJdbcImpl(userRepository);
    }

    @Bean
    public UserRepository userRepository(DataSource dataSource) throws SQLException {
        return new UserRepository(dataSource);
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUsername("root");
        ds.setPassword("IMBABOTGg2A7Vyz");
        ds.setUrl("jdbc:mysql://localhost:3306/network_chat?&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC");
        return ds;
    }
}
