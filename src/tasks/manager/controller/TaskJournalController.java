package tasks.manager.controller;

import tasks.manager.model.journal.Task;
import tasks.manager.model.journal.TaskJournal;
import tasks.manager.model.observer.Observer;

public class TaskJournalController implements Controller{

    TaskJournal journal;

    public TaskJournalController(TaskJournal journal) {
        this.journal = journal;
    }

    @Override
    public void addTask(Task task) {

    }

    @Override
    public void deleteTask(Task task) {

    }

    @Override
    public void modificationTask(Task source, Task modified) {

    }

    @Override
    public void addObserver(Observer observer) {

    }
}
