import appearsln.Appearsln;

import java.time.LocalDateTime;
import java.util.Objects;

public class Task{
  private String title;
  private  int id;
  private LocalDateTime dateTime;
  private Type type;
  private String deccription;
  private Appearsln appearsln;
 private static int ide = 1;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Task task = (Task) o;
    return id == task.id && Objects.equals(title, task.title) && Objects.equals(dateTime, task.dateTime) && type == task.type && Objects.equals(deccription, task.deccription) && Objects.equals(appearsln, task.appearsln);
  }


  public void setTitle(String title) {
    this.title = title;
  }


  public String getTitle() {
    return title;
  }


  public LocalDateTime getDateTime() {
    return dateTime;
  }

  public static int getIde() {
    return ide;
  }

  public  int getId() {
    return id;
  }

  public String getDeccription() {
    return deccription;
  }

  public Type getType() {
    return type;
  }

  public Task(String title, LocalDateTime dateTime, Type type, String deccription, Appearsln appearsln) {
    this.title = title;
    if (this.title.equals(" ") || this.title == null) {
      this.title = "Defoult";
    }
    this.dateTime = dateTime;
    this.type = type;
    this.deccription = deccription;
    if (this.deccription.equals(" ") || this.deccription == null) {
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
            " title='" + title + '\'' +
            ", dateTime=" + dateTime +
            ", deccription='" + deccription + '\'' +
            ", Type='" + type + '\'' +
            '}';
  }
}
