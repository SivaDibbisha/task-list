package com.codurance.training.tasks.refactored.service.impl;

import com.codurance.training.tasks.refactored.Task;
import com.codurance.training.tasks.refactored.service.ViewService;

import java.io.PrintWriter;
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
}