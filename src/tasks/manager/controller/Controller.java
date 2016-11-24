package tasks.manager.controller;


import tasks.manager.model.journal.Task;

public interface Controller {
    void addTask(Task task);
    void deleteTask(Task task);
    void modificateTask(Task source,Task modified);
}
