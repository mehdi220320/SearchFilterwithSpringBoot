package com.fsb.searchfiltre;

import com.fsb.searchfiltre.Entity.User;
import com.fsb.searchfiltre.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SearchFiltreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchFiltreApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository){
        User user=new User(1,"salim","abada","'salim'","skanfar 7ama ghrab ya ghrab i m sexy",56);
        User user1=new User(2,"hama","zakrawi","hama","zo9olo9o ",56);
        User user2=new User(6,"lim","sikimiki","lim","wa aezae zakaria",56);
        User user3=new User(3,"krima","soudani","krima","azeazeazdkoapd zae azes clean foul soudani salut aeae",56);
        User user4=new User(4,"ezidine","7dide","ezidine","azeazeazdkoapd zae azes  7dide salut aeae",5653);
        User user5=new User(5,"sdaesqdae","salut","sdaesqdae","azeazeazdkoapd zae azes azae ena salut aeae",56);
        User user6=new User(7,"kfskfpaaze","azes","kfskfpaaze","azeazeazdkoapd zae azes  sexy salut aeae",56);
        User user7=new User(8,"salimvvv","hello","salimvvv","azeazeazdkoapd zae azes clean hello  aeae",56);
        User user8=new User(9,"salisaeam","zarkawi","salisaeam","azeazeazdkoapd zae azes clean aze salut aeae",56);
        User user9=new User(10,"clean shit","smart","clean shit","azeazeazdkoapd zae azes clean sexy salut aeae",56);
        return args -> {
            userRepository.save(user);
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);
            userRepository.save(user4);
            userRepository.save(user5);
            userRepository.save(user6);
            userRepository.save(user7);
            userRepository.save(user8);
            userRepository.save(user9);

        };
    }
}
