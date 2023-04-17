package com.codurance.training.tasks.refactored.service.impl;

import com.codurance.training.tasks.refactored.service.TaskErrorService;

import java.io.PrintWriter;

public class TaskErrorServiceImpl implements TaskErrorService {

    @Override
    public void error(String command, PrintWriter out) {
        out.printf("I don't know what the command \"%s\" is.", command);
        out.println();
    }
}
