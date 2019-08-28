package ro.itschool.curs24;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.itschool.curs24.repository.DocumentRepository;
import ro.itschool.curs24.repository.model.Document;

@SpringBootApplication
public class Curs24Application {

    public static void main(String[] args) {
        SpringApplication.run(Curs24Application.class, args);
    }

    @Bean
    CommandLineRunner atStartup(DocumentRepository repo) {
        return args -> {
            repo.save(new Document("name1", "content1", "Steli"));
            repo.save(new Document("name2", "content2", "Steli"));
            repo.save(new Document("name3", "content3", "Steli"));
            repo.save(new Document("name4", "content4", "Steli"));
            repo.save(new Document("name4", "content4", "Steli"));
            repo.save(new Document("name4", "content4", "Cipri"));
            repo.save(new Document("name4", "content4", "Cipri"));

            System.out.println("by owner");
            repo.findAllByOwner("Cipri")
                    .forEach(System.out::println);
            repo.findFirstByOwnerOrderByDocumentId("Steli")
                    .ifPresent(System.out::println);
            System.out.println("------------------");
            repo.findAll()
                    .forEach(System.out::println);
        };
    }
}
