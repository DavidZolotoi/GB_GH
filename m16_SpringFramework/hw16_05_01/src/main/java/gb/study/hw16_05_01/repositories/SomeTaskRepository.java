package gb.study.hw16_05_01.repositories;

import gb.study.hw16_05_01.model.SomeTask;
import gb.study.hw16_05_01.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SomeTaskRepository extends JpaRepository<SomeTask, Long> {
    List<SomeTask> findByStatus(TaskStatus status);
}
