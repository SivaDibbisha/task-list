package com.codurance.training.tasks.refactored.service.impl;


import com.codurance.training.tasks.refactored.Task;
import com.codurance.training.tasks.refactored.service.TaskService;
import com.codurance.training.tasks.refactored.util.Util;


import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class TaskServiceImpl implements TaskService {
    @Override
    public void addTask(String project, String description, String taskId, Map<String, List<Task>> tasks, PrintWriter out) {
        List<Task> projectTasks = tasks.get(project);
        if (projectTasks == null) {
            out.printf("Could not find a project with the name \"%s\".", project);
            out.println();
            return;
        }
        String id = "";
        if (null != taskId && taskId.trim().length() > 1) {
            id = taskId;
        } else {
            id = String.valueOf(Util.nextId());
        }
        projectTasks.add(new Task(id, description, false));
    }

    @Override
    public void deleteTask(String taskId, Map<String, List<Task>> tasks, PrintWriter out) {
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId().equalsIgnoreCase(taskId)) {
                    List<Task> taskLi = project.getValue();
                    taskLi.remove(task);
                    out.printf("task deleted with an ID of %s.", taskId);
                    project.setValue(taskLi);
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %s.", taskId);
        out.println();
    }

    @Override
    public void setDeadLine(String commandLine, Map<String, List<Task>> tasks, PrintWriter out) {
        String[] commandRest = commandLine.split(" ", 2);
        String id = commandRest[0];
        String deadLineDateStr = commandRest[1];
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId().equalsIgnoreCase(id)) {
                    task.setDeadLineDate(deadLineDateStr);
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %s.", id);
        out.println();
    }
}