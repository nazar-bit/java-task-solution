package pjv.hello.vasylnaz.xml_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pjv.hello.vasylnaz.xml_task.entity.Village;

@Repository
public interface VillageRepository extends JpaRepository<Village, Long> {
}
