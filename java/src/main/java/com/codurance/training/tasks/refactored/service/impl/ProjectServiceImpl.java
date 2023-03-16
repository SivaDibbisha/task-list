package com.codurance.training.tasks.refactored.service.impl;


import com.codurance.training.tasks.refactored.Task;
import com.codurance.training.tasks.refactored.service.ProjectService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProjectServiceImpl implements ProjectService {

    @Override
    public void addProject(String name, Map<String, List<Task>> tasks) {
        tasks.put(name, new ArrayList<Task>());
    }
}