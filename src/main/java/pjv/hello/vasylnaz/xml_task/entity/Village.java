package pjv.hello.vasylnaz.xml_task.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "village")
public class Village {
    @Id
    private Long id;

    private String name;


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
}
