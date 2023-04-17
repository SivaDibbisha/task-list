package com.codurance.training.tasks.refactored.service.impl;

import com.codurance.training.tasks.refactored.Task;
import com.codurance.training.tasks.refactored.service.ViewCommonService;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class ProjectTasksServiceImpl implements ViewCommonService {

    @Override
    public void tasksByAttribute(String projectName, Map<String, List<Task>> tasks, PrintWriter out) {
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
}
