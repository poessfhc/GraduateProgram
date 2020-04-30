package wang.dreamland.www.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "idea")
public class Idea {
    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
