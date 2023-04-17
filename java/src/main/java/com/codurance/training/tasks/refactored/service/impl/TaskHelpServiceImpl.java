package com.codurance.training.tasks.refactored.service.impl;

import com.codurance.training.tasks.refactored.service.TaskHelpService;

import java.io.PrintWriter;

public class TaskHelpServiceImpl implements TaskHelpService {
    @Override
    public void help(PrintWriter out) {
        out.println("Commands:");
        out.println("  show");
        out.println("  add project <project name>");
        out.println("  add task <project name> <task description> <task id <Optional>>");
        out.println("  check <task ID>");
        out.println("  uncheck <task ID>");
        out.println("  deadline <ID> <date>");
        out.println("  today");
        out.println("  delete <ID>");
        out.println("  viewByCreatedDate <created date>");
        out.println("  viewByDeadLineDate <dead line date>");
        out.println("  viewByProjectName <project name>");

        out.println();
    }
}
