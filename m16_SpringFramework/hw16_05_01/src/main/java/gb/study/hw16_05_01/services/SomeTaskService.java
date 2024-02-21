package gb.study.hw16_05_01.services;

import gb.study.hw16_05_01.model.SomeTask;
import gb.study.hw16_05_01.model.TaskStatus;
import gb.study.hw16_05_01.repositories.SomeTaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SomeTaskService {
    private final SomeTaskRepository someTaskRepository;

    public List<SomeTask> findAll() { return someTaskRepository.findAll(); }

    public Optional<SomeTask> findById(Long id) { return someTaskRepository.findById(id); }

    public SomeTask createSomeTask(SomeTask someTask) { return someTaskRepository.save(someTask); }

    public SomeTask updateSomeTask(Long id, SomeTask someTask)
    {
        Optional<SomeTask> optionalSomeTask = someTaskRepository.findById(id);
        if (optionalSomeTask.isPresent()) {
            SomeTask task = optionalSomeTask.get();
            task.setDescription(someTask.getDescription());
            task.setStatus(someTask.getStatus());
            return someTaskRepository.save(task);
        } else {
            throw new IllegalArgumentException("SomeTask not found with id: " + id);
        }
    }

    public void deleteById(Long id) { someTaskRepository.deleteById(id); }

    public List<SomeTask> findByStatus(TaskStatus status) {
        return someTaskRepository.findByStatus(status);
    }
}
