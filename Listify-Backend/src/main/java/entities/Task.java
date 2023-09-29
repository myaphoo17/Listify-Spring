package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private Long id;
@SuppressWarnings("unused")
private String text;
@SuppressWarnings("unused")
private boolean completed;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public boolean isCompleted() {
	return completed;
}
public void setCompleted(boolean completed) {
	this.completed = completed;
}



}
