package com.codurance.training.tasks.refactored.service;

import java.io.PrintWriter;

public interface TaskErrorService {
    void error(String command, PrintWriter out);
}
