package pl.coderslab.model;

import javax.persistence.*;
import javax.validation.constraints.Future;


@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Priority priority;

    private String name;

//    @Future
    private String endDate;

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Task(User user, Priority priority, String name, String endDate) {
        this.user = user;
        this.priority = priority;
        this.name = name;
        this.endDate = endDate;
    }

    public Task() {
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", user=" + user +
                ", priority=" + priority +
                ", name='" + name + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
