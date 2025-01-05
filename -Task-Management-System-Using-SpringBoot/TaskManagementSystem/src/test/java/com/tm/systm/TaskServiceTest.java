package com.tm.systm;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.tm.systm.db.Task;
import com.tm.systm.repository.TaskRepository;
import com.tm.systm.services.TaskService;

@SpringBootTest
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    public void testAddTask() {
        Task task = new Task("Test Task", "Test Description");
        when(taskRepository.save(Mockito.any(Task.class))).thenReturn(task);

        Task result = taskService.addTask(task);

        assertEquals("Test Task", result.getTitle());
        assertEquals("Test Description", result.getDescription());
    }

	private void assertEquals(String string, String title) {
		// TODO Auto-generated method stub
		
	}
}
