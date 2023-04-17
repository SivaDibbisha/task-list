package com.codurance.training.tasks.refactored.service;

import com.codurance.training.tasks.refactored.Task;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public interface ViewService {
    void show(Map<String, List<Task>> tasks, PrintWriter out);
}
