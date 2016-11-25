package tasks.manager.controller;


import tasks.manager.model.journal.Task;
import tasks.manager.model.observer.Observer;

public interface Controller {
    void addTask(Task task);
    void deleteTask(Task task);
    void modificationTask(Task source, Task modified);
    void addObserver(Observer observer);
}
