package com.codurance.training.tasks.refactored.service;

import com.codurance.training.tasks.refactored.Task;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public interface ViewCommonService {
    void tasksByAttribute(String attribute , Map<String, List<Task>> tasks, PrintWriter out);
}
