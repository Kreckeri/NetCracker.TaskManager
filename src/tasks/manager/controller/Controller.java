package tasks.manager.controller;


import tasks.manager.model.journal.Task;

public interface Controller {
    void addTask(Task task);
    void deleteTask(Task task);
    void modificationTask(Task source, Task modified);
}
