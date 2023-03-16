package com.codurance.training.tasks.refactored;

import com.codurance.training.tasks.refactored.service.*;
import com.codurance.training.tasks.refactored.service.impl.*;
import com.codurance.training.tasks.refactored.util.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class TaskListNew implements Runnable {
    private static final String QUIT = "quit";
    private final Map<String, List<Task>> tasks = new LinkedHashMap<>();
    private final BufferedReader in;
    private final PrintWriter out;
    private TaskListService taskListService = new TaskListServiceImpl();

    private TaskCheckService taskcheckService = new TaskCheckServiceImpl();

    private TaskHelpService taskHelpService = new TaskHelpServiceImpl();

    private TaskErrorService taskErrorService = new TaskErrorServiceImpl();

    private ViewService viewService = new ViewServiceImpl();

    private TaskAddService taskaddService = new TaskAddServiceImpl();

    private TaskDeleteService taskDeleteService = new TaskDeleteServiceImpl();

    private ViewCommonService dueDateTaskService  = new DueDateTasksServiceImpl();

    private ViewCommonService createdDateTaskService  = new CreatedDateTasksServiceImpl();

    private ViewCommonService projectTaskService  = new ProjectTasksServiceImpl();

    public TaskListNew(BufferedReader reader, PrintWriter writer) {
        this.in = reader;
        this.out = writer;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        new TaskListNew(in, out).run();
    }

    public void run() {
        intialize();
        while (true) {
            out.print("> ");
            out.flush();
            String command;
            try {
                command = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (command.equals(QUIT)) {
                break;
            }
            execute(command);
        }
    }

    private void execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        switch (command) {
            case "show":
                viewService.show(tasks, out);
                break;
            case "add":
                taskListService.add(commandRest[1], tasks, out);
                break;
            case "check":
                taskcheckService.check(commandRest[1], tasks, out);
                break;
            case "uncheck":
                taskcheckService.uncheck(commandRest[1], tasks, out);
                break;
            case "deadline":
                taskaddService.setDeadLine(commandRest[1], tasks, out);
                break;
            case "today":
                 dueDateTaskService.tasksByAttribute(Util.dateToString(new Date()),tasks, out);
                break;
            case "delete":
                taskDeleteService.deleteTask(commandRest[1], tasks, out);
                break;
            case "viewByCreatedDate":
                createdDateTaskService.tasksByAttribute(commandRest[1], tasks, out);
                break;
            case "viewByDeadLineDate":
                dueDateTaskService.tasksByAttribute(commandRest[1], tasks, out);
                break;
            case "viewByProjectName":
                projectTaskService.tasksByAttribute(commandRest[1], tasks, out);
                break;
            case "help":
                taskHelpService.help(out);
                break;
            default:
                taskErrorService.error(command, out);
                break;
        }
    }

    private void intialize() {
        execute("add project P1");
        execute("add project P2");
        execute("add task P1 t1 p1t1id");
        execute("add task P1 t2 p1t2id");
        execute("add task P2 t1");
        execute("add task P2 t2");
        execute("deadline p1t1id 16-03-2023");
        execute("deadline p1t2id 16-03-2023");
        execute("deadline 1 17-03-2023");
        //execute("deadline 2 18-03-2023");
    }

}