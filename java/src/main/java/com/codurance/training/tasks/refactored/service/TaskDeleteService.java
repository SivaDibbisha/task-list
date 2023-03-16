package com.codurance.training.tasks.refactored.service;


import com.codurance.training.tasks.refactored.Task;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public interface TaskDeleteService {
    void deleteTask(String taskId, Map<String, List<Task>> tasks, PrintWriter out);
}
