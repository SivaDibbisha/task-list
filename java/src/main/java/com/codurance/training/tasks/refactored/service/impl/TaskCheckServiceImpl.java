package com.codurance.training.tasks.refactored.service.impl;


import com.codurance.training.tasks.refactored.Task;
import com.codurance.training.tasks.refactored.service.TaskCheckService;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class TaskCheckServiceImpl implements TaskCheckService {


    @Override
    public void check(String idString, Map<String, List<Task>> tasks, PrintWriter out) {
        setDone(idString, true,tasks, out);
    }
    @Override
    public void uncheck(String idString, Map<String, List<Task>> tasks, PrintWriter out) {
        setDone(idString, false,tasks, out);
    }

    private void setDone(String idString, boolean done, Map<String, List<Task>> tasks, PrintWriter out) {
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId() == idString) {
                    task.setDone(done);
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %d.", idString);
        out.println();
    }
}
