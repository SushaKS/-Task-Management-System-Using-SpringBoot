package com.tm.systm.services;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.tm.systm.db.Task;
import com.tm.systm.repository.TaskRepository;
import java.util.List;


@Service
public class ReminderService {
    
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Scheduled(fixedRate = 3600000) // Every hour
    public void sendReminders() {
        // Get the current time and time 24 hours later
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime next24Hours = currentTime.plusHours(24);

        // Find tasks due within the next 24 hours
        List<Task> tasksDueIn24Hours = taskRepository.findTasksDueWithin24Hours(currentTime, next24Hours);

        // Send email reminders for each task
        for (Task task : tasksDueIn24Hours) {
            sendReminderEmail(task);
        }
    }

    private void sendReminderEmail(Task task) {
        // Simple email message setup
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("user@example.com");  
        // Set recipient email (this could be task.user.email)
        message.setSubject("Reminder: Task Due Soon - " + task.getTitle());
        message.setText("Dear user,\n\n" +
                        "This is a reminder that the task '" + task.getTitle() + "' is due on " + task.getDueDate() +
                        ".\n\nDescription: " + task.getDescription() + "\n\nPlease take necessary action.");

         // Send email
        mailSender.send(message);
    }
}
