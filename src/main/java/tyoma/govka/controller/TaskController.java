package tyoma.govka.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tyoma.govka.DTO.TaskDTO;
import tyoma.govka.requests.Task.TaskCreateRequest;
import tyoma.govka.requests.Task.TaskDeleteRequest;
import tyoma.govka.requests.Task.TaskUpdateRequest;
import tyoma.govka.services.TaskService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/task")
public class TaskController {
    private TaskService taskService = new TaskService();

    @GetMapping
    public ResponseEntity<HashMap<Integer, TaskDTO>> list() {
        return ResponseEntity.of(Optional.of(taskService.getAllTasks()));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TaskDTO> getOne(@PathVariable String id) {
        return ResponseEntity.of(Optional.of(taskService.getTaskById(id)));
    }

    @PostMapping("/create")
    public ResponseEntity<TaskDTO> create(@RequestBody TaskCreateRequest taskCreateRequest) {
        return ResponseEntity.of(Optional.of(taskService.addTask(taskCreateRequest)));
    }

    @PostMapping("/update")
    public ResponseEntity<TaskDTO> update(@RequestBody TaskUpdateRequest taskUpdateRequest) {
        return ResponseEntity.of(Optional.of(taskService.changeTaskById(taskUpdateRequest)));
    }

    @PostMapping("/delete")
    public void delete(@RequestBody TaskDeleteRequest taskDeleteRequest){
        taskService.deleteTask(taskDeleteRequest);
    }
}
