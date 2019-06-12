package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Priority;
import pl.coderslab.model.Task;
import pl.coderslab.model.User;
import pl.coderslab.repository.PriorityRepository;
import pl.coderslab.repository.TaskRepository;
import pl.coderslab.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TaskController {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final PriorityRepository priorityRepository;

    public TaskController(TaskRepository taskRepository,
                          UserRepository userRepository,
                          PriorityRepository priorityRepository) {

        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.priorityRepository = priorityRepository;
    }

    //    GET PRIORITY LIST FROM DATABASE   ############################################################################
    @ModelAttribute("prioritylist")
    public List<Priority> priorityList() {

        return priorityRepository.findAll();

    }

    //    GET TASK LIST FROM DATABASE   ####################################################################################

    @ModelAttribute("tasklist")
    public List<Task> taskList() {
        return taskRepository.findAll();
    }

    //    SHOW TASKS -> task-list.jsp   ################################################################################
    @RequestMapping("/task/show")
    public String showTask() {
        return "task/task-list";
    }

    //    GET USER LIST FROM DATABASE   ################################################################################
    @ModelAttribute("userlist")
    public List<User> userList() {
        return userRepository.findAll();
    }

    //    ADD TASK -> task-add.jsp      ################################################################################
    @RequestMapping(value = "/task/add", method = RequestMethod.GET)
    public String newTask(Model model) {
        model.addAttribute("task", new Task());
        return "task/task-add";
    }

    //    ADD NEW TASK   ###############################################################################################
    @RequestMapping(value = "/task/add", method = RequestMethod.POST)
    public String processNewTask(@Valid Task task, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "task/task-add";
        }
        taskRepository.save(task);
        model.addAttribute("task", task);
        return "task/task-success";
    }

    //    DELETE TASK -> task-delete.jsp     ###########################################################################
    @RequestMapping("/task/delete/{id}")
    public String taskDelete(@PathVariable Long id) {
        Task task = taskRepository.findOne(id);
        taskRepository.delete(task);

        return "redirect:/task/show";
    }

    //    EDIT TASK -> task-edit.jsp   #################################################################################
    @GetMapping("/task/edit/{id}")
    public String editTask(@PathVariable Long id, Model model) {
        model.addAttribute("task", taskRepository.findOne(id));
        return "task/task-edit";
    }

    @RequestMapping(value = "/task/edit", method = RequestMethod.POST)
    public String processEditTask(@Valid Task task, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "task/task-edit";
        }
        taskRepository.save(task);
        model.addAttribute("task", task);
        return "redirect:/task/show";
    }

}
