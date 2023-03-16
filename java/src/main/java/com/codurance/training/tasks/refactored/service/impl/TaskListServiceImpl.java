package com.codurance.training.tasks.refactored.service.impl;

import com.codurance.training.tasks.refactored.Task;
import com.codurance.training.tasks.refactored.service.ProjectService;
import com.codurance.training.tasks.refactored.service.TaskListService;
import com.codurance.training.tasks.refactored.service.TaskAddService;
import com.codurance.training.tasks.refactored.util.Util;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class TaskListServiceImpl implements TaskListService {

    private final ProjectService porectService = new ProjectServiceImpl();

    private final TaskAddService taskService = new TaskAddServiceImpl();

    // execute("add task P2 t2");
    // execute("add project P2");
    @Override
    public void add(String commandLine, Map<String, List<Task>> tasks, PrintWriter out) {
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            porectService.addProject(subcommandRest[1], tasks);
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 3);
            if (projectTask.length == 3) {
                if (Util.isValidTaskId(projectTask[2])) {
                    taskService.addTask(projectTask[0], projectTask[1], projectTask[2], tasks, out);
                } else {
                    out.printf(" Task ID is not valid \"%s\" %n ", projectTask[2]);
                }
            } else
                taskService.addTask(projectTask[0], projectTask[1], null, tasks, out);
        }
    }
}