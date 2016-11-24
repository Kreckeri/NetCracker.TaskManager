package tasks.manager.model.journal;

import java.util.TreeSet;

public class TaskJournal {
    TreeSet<Task> tasks = new TreeSet<>();

    public boolean addTask(Task task) {
        return tasks.add(task);
    }

    public boolean deleteTask(Task task) {
        return tasks.remove(task);
    }

    public boolean modificationTask(Task source, Task modified) {
        return deleteTask(source) & addTask(modified);
    }

    /*public Iterator<Task> getNext(){
        return tasks.iterator();
    }*/
    //TODO:Add serializable


}
