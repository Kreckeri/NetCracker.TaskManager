package tasks.manager.model.journal;

import java.time.ZonedDateTime;

public class Task implements Comparable{
    private String name;
    private String description;
    private ZonedDateTime dateTime;

    public Task(String name, String description, ZonedDateTime dateTime) {
        this.name = name;
        this.description = description;
        this.dateTime = dateTime;
    }


    //Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ZonedDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(ZonedDateTime dateTime) {
        this.dateTime = dateTime;
    }

    //Equals and hash code overriding
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;

        Task task = (Task) o;

        return name.equals(task.name) && description.equals(task.description) && dateTime.equals(task.dateTime);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + dateTime.hashCode();
        return result;
    }

    //Compare for tree set
    //Converse sort
    @Override
    public int compareTo(Object o) {
        if(!(o instanceof Task))
            throw new ClassCastException("Object " + o + "( " + o.getClass() + " ) not compare to Task");

        Task task = (Task) o;
        return task.dateTime.compareTo(task.dateTime);
    }
}
