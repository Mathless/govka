package tyoma.govka.services;

import tyoma.govka.DTO.TaskDTO;
import tyoma.govka.requests.Task.TaskCreateRequest;
import tyoma.govka.requests.Task.TaskDeleteRequest;
import tyoma.govka.requests.Task.TaskUpdateRequest;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

public class TaskService {
    private int counter;
    private HashMap<Integer, TaskDTO> tasks;

    public TaskService() {
        counter = 1;
        tasks = new HashMap<>();
    }

    public TaskDTO getTaskById(String id) {
        return tasks.get(Integer.parseInt(id));
    }

    public HashMap<Integer, TaskDTO> getAllTasks(){
        return tasks;
    }

    public TaskDTO addTask(TaskCreateRequest task) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(counter);
        taskDTO.setName(task.getName());
        taskDTO.setDate(task.getDate());
        tasks.put(counter++, taskDTO);
        return taskDTO;
    }

    public TaskDTO changeTaskById(TaskUpdateRequest taskUpdateRequest){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(Integer.parseInt(taskUpdateRequest.getId()));
        taskDTO.setName(taskUpdateRequest.getName());
        taskDTO.setDate(taskUpdateRequest.getDate());
        tasks.put(taskDTO.getId(), taskDTO);
        return taskDTO;

    }
    public void deleteTask(TaskDeleteRequest taskDeleteRequest){
        tasks.remove(Integer.parseInt(taskDeleteRequest.getId()));
    }

}
