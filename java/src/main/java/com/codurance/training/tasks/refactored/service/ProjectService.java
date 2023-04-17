package com.codurance.training.tasks.refactored.service;

import com.codurance.training.tasks.refactored.Task;
import java.util.List;
import java.util.Map;

public interface ProjectService {
    void addProject(String name, Map<String, List<Task>> tasks);
}
