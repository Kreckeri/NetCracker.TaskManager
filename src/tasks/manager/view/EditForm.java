package tasks.manager.view;

import tasks.manager.model.journal.Task;
import tasks.manager.model.journal.TaskJournal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class EditForm extends AddOrEditForm
{
    TaskJournal journal;
    Task task;

    public EditForm(TaskJournal journal, Task task)
    {
        this.journal = journal;
        this.task = task;
    }

    public void init()
    {
        form.setTitle("Изменить задачу");

        name.setText(task.getName());
        textpane.setText(task.getDescription());

        ytf.setText(""+task.getDateTime().getYear());
        mtf.setText(""+task.getDateTime().getMonthValue());
        dtf.setText(""+task.getDateTime().getDayOfMonth());

        htf.setText(""+task.getDateTime().getHour());
        mintf.setText(""+task.getDateTime().getMinute());

        butAddEdit.setText("Изменить");
        butAddEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                task.setName(name.getText());
                task.setDescription(textpane.getText());
                ZonedDateTime dateTime = ZonedDateTime.of(Integer.parseInt(ytf.getText()), Integer.parseInt(mtf.getText()), Integer.parseInt(dtf.getText()), Integer.parseInt(htf.getText()), Integer.parseInt(mintf.getText()), 0, 0, ZoneId.of("UTC+4"));
                task.setDateTime(dateTime);

                //journal.modificationTask(); как это должно работать?

                form.dispose();
            }
        });

        cancelLabel.setText("Отменить изменение задачи?");
        form.setVisible(true);
    }
}
