package tasks.manager.model.observer;

import tasks.manager.model.journal.TaskJournal;

public class TaskModifiedEvent {
    public enum Events{
        TASK_MODIFIED
    }

    TaskJournal journal;
    Events event;

    public TaskModifiedEvent(TaskJournal journal, Events event) {
        this.journal = journal;
        this.event = event;
    }

    public TaskJournal getJournal() {
        return journal;
    }

    public Events getEvent() {
        return event;
    }
}
