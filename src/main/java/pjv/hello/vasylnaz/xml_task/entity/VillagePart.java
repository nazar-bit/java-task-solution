package pjv.hello.vasylnaz.xml_task.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "village_part")
public class VillagePart {
    @Id
    private Long id;

    private String name;

    @Column(name = "village_id")
    private Long villageId;


    ///  GETTERS and SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getVillageId() {
        return villageId;
    }

    public void setVillageId(Long villageId) {
        this.villageId = villageId;
    }
}
