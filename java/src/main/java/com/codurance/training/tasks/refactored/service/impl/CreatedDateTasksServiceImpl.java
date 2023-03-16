package com.codurance.training.tasks.refactored.service.impl;

import com.codurance.training.tasks.refactored.Task;
import com.codurance.training.tasks.refactored.service.ViewCommonService;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class CreatedDateTasksServiceImpl implements ViewCommonService {
    @Override
    public void tasksByAttribute(String createdDate, Map<String, List<Task>> tasks, PrintWriter out) {
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
}