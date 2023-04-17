package com.codurance.training.tasks.refactored.service.impl;

import com.codurance.training.tasks.refactored.Task;
import com.codurance.training.tasks.refactored.service.TaskDeleteService;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class TaskDeleteServiceImpl implements TaskDeleteService {


    @Override
    public void deleteTask(String taskId, Map<String, List<Task>> tasks, PrintWriter out) {
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId().equalsIgnoreCase(taskId)) {
                    List<Task> taskLi = project.getValue();
                    taskLi.remove(task);
                    out.printf("task deleted with an ID of %s %n", taskId);
                    project.setValue(taskLi);
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %s.", taskId);
        out.println();
    }

}