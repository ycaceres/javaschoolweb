package ns.javaschool.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ToDoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String description;
    private boolean done;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ToDoItem toDoItem = (ToDoItem) o;

        if (done != toDoItem.done)
            return false;
        if (id != null ? !id.equals(toDoItem.id) : toDoItem.id != null)
            return false;
        return description != null ?
                description.equals(toDoItem.description) :
                toDoItem.description == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (done ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ToDoItem{" + "description='" + description + '\'' + ", done=" + done + '}';
    }
}
