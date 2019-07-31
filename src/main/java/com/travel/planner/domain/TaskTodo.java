package com.travel.planner.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "todo")
@JsonIgnoreProperties(
        value = {"createdAt", "updatedAt"},
        allowGetters = true
)
public class TaskTodo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long taskId;

    @NotBlank(message = "Task Title can not blank.")
    @Size(max = 100)
    @UniqueElements(message = "Todo Title is unique.")
    private String title;

    private Boolean completed = false;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "TaskTodo{" +
                "taskId=" + taskId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }


}
