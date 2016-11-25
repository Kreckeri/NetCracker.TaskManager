package tasks.manager.model.observer;

import tasks.manager.model.journal.Task;

public class TaskEvent implements Event{
    public enum Events{
        TASK_ADDET,
        TASK_DELETED,
        TASK_EXCITED
    }

    Events event;
    Task task;

    public TaskEvent(Events event, Task task) {
        this.event = event;
        this.task = task;
    }

    public Task getTask() {
        return task;
    }

    public Events getEvent() {
        return event;
    }
}
