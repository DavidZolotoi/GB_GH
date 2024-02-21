package gb.study.hw16_05_01.controllers;

import gb.study.hw16_05_01.model.SomeTask;
import gb.study.hw16_05_01.model.TaskStatus;
import gb.study.hw16_05_01.services.SomeTaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sometasks")
@AllArgsConstructor
public class SomeTaskController {

    private final SomeTaskService someTaskService;

    @GetMapping()
    public List<SomeTask> findAll() {
        return someTaskService.findAll();
    }

    @GetMapping("/status/{status}")
    public List<SomeTask> getTasksByStatus(@PathVariable TaskStatus status) {
        return someTaskService.findByStatus(status);
    }

    @PutMapping("/{id}")
    public SomeTask updateTaskStatus(@PathVariable Long id, @RequestBody SomeTask someTask) {
        return someTaskService.updateSomeTask(id, someTask);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        someTaskService.deleteById(id);
    }

}
