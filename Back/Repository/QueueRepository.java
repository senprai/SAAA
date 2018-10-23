package sut.sa.g15.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import sut.sa.g15.entity.Queue;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface QueueRepository extends JpaRepository<Queue,Long> {

}
