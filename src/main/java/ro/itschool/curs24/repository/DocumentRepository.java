package ro.itschool.curs24.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.itschool.curs24.repository.model.Document;

import java.util.List;
import java.util.Optional;

public interface DocumentRepository extends JpaRepository<Document,Integer> {
    List<Document> findAllByOwner(String owner);

    Optional<Document> findFirstByOwnerOrderByDocumentId(String owner);


}
