package tasks.manager.model.observer;

import tasks.manager.model.journal.Task;

public class TaskJournalEvent  implements Event{
    public enum Events{
        TASK_JOURNAL_INIT
    }

    Task source;
    Task modified;
    Events event;

    public TaskJournalEvent(Task source, Task modified, Events event) {
        this.source = source;
        this.modified = modified;
        this.event = event;
    }

    public Task getSource() {
        return source;
    }

    public Task getModified() {
        return modified;
    }

    public Events getEvent() {
        return event;
    }
}
