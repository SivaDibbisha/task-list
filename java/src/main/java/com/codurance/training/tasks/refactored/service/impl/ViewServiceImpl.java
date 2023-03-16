package com.codurance.training.tasks.refactored.service.impl;

import com.codurance.training.tasks.refactored.Task;
import com.codurance.training.tasks.refactored.service.ViewService;
import com.codurance.training.tasks.refactored.util.Util;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ViewServiceImpl implements ViewService {

    @Override
    public void show(Map<String, List<Task>> tasks, PrintWriter out) {
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            out.println(project.getKey());
            for (Task task : project.getValue()) {
                out.printf("    [%c] %s: %s create dt %5s dead line %5s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription()
                        , task.getCreatedDate(), task.getDeadLineDate());
            }
            out.println();
        }
    }

    @Override
    public void tasksCreatedDate(String createdDate, Map<String, List<Task>> tasks, PrintWriter out) {
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if (createdDate.equalsIgnoreCase(task.getCreatedDate())) {
                    out.printf("   Project %s [%c] %s: %s create dt %5s dead line %5s%n", project.getKey(), (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription()
                            , task.getCreatedDate(), task.getDeadLineDate());
                }
            }
        }
        out.println();
    }

    @Override
    public void tasksDeadLineDate(String DeadLineDate, Map<String, List<Task>> tasks, PrintWriter out) {
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if (DeadLineDate.equalsIgnoreCase(task.getDeadLineDate())) {
                    out.printf("   Project %s [%c] %s: %s create dt %5s dead line %5s%n", project.getKey(), (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription()
                            , task.getCreatedDate(), task.getDeadLineDate());
                }
            }
        }
        out.println();
    }

    @Override
    public void tasksByProject(String projectName, Map<String, List<Task>> tasks, PrintWriter out) {
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            if (project.getKey().equalsIgnoreCase(projectName)) {
                out.println(project.getKey());
                for (Task task : project.getValue()) {
                    out.printf("   [%c] %s: %s create dt %5s dead line %5s%n",
                            (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription() ,
                            task.getCreatedDate(), task.getDeadLineDate());
                }

            }
        }
        out.println();
    }

    @Override
    public void taskDueToday(Map<String, List<Task>> tasks, PrintWriter out) {
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if (Util.dateToString(new Date()).equalsIgnoreCase(task.getDeadLineDate())) {
                    out.printf("    %s  [%c] %s: %s %5s%n", project.getKey(), (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription(), (null != task.getDeadLineDate() ? task.getDeadLineDate() : ' '));
                }
            }
        }
        out.println();
    }
}
