import appearsln.Appearsln;

import java.time.LocalDateTime;
import java.util.Objects;

public class Task<A extends Appearsln>{
  private String title;
  private int id;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Task<?> task = (Task<?>) o;
    return id == task.id && Objects.equals(title, task.title) && dateTime.equals(task.dateTime) && Objects.equals(deccription, task.deccription) && Objects.equals(appearsln, task.appearsln);
  }


  private LocalDateTime dateTime;
  private String deccription;
  private Appearsln appearsln;
  static int ide = 1;

  public void setTitle(String title) {
    this.title = title;
  }


  public String getTitle() {
    return title;
  }

  public int getId() {
    return id;
  }

  public LocalDateTime getDateTime() {
    return dateTime;
  }

  public String getDeccription() {
    return deccription;
  }

  public Task(String title, LocalDateTime dateTime, String deccription, A appearsln) {
    this.title = title;
    if (this.title == " " || this.title == null) {
      this.title = "Defoult";
    }
    this.dateTime = dateTime;
    this.deccription = deccription;
    if (this.deccription == " " || this.deccription == null) {
      this.deccription = "Defoult";
    }
    this.appearsln = appearsln;
    this.id = ide;
    ide++;
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  public void setDateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }

  public Appearsln getAppearsln() {
    return appearsln;
  }

  @Override
  public String toString() {
    return "Task{" +
            ", title='" + title + '\'' +
            ", dateTime=" + dateTime +
            ", deccription='" + deccription + '\'' +
            '}';
  }
}
