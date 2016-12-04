package tasks.manager.view;

import tasks.manager.model.journal.Task;
import tasks.manager.model.journal.TaskJournal;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class AddForm extends AddOrEditForm{

    TaskJournal journal;

    public AddForm(TaskJournal journal)
    {
        this.journal = journal;
    }

    public void init()
    {
        form.setTitle("Добавить задачу");

        butAddEdit.setText("Добавить");
        butAddEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // проверка на существование такой же задачи
                //если нет то добавить в базу
                ZonedDateTime dateTime = ZonedDateTime.of(Integer.parseInt(ytf.getText()), Integer.parseInt(mtf.getText()), Integer.parseInt(dtf.getText()), Integer.parseInt(htf.getText()), Integer.parseInt(mintf.getText()), 0, 0, ZoneId.of("UTC+4"));
                Task task = new Task(name.getText(), textpane.getText(), dateTime);
                journal.addTask(task);
                form.dispose();
            }
        });

        cancelLabel.setText("Отменить добавление задачи?");
        form.setVisible(true);
    }

}
