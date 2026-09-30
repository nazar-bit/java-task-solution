package pjv.hello.vasylnaz.xml_task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pjv.hello.vasylnaz.xml_task.entity.VillagePart;

@Repository
public interface VillagePartRepository extends JpaRepository<VillagePart, Long> {
}
