package dev.cedric.runnerz.run;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class RunRepository {
    private static List<Run> runs = new ArrayList<>();

    List<Run> findAll() {
        return runs;
    }

    Optional<Run> getById(int id) {
        return runs.stream().filter(run -> run.id() == id).findFirst();
    }

    void create(Run run) {
        runs.add(run);
    }

    void update(Run run, Integer id) {
        Optional<Run> existingRun = getById(id);
        if (existingRun.isPresent()) {
            runs.set(runs.indexOf(existingRun.get()), run);
        }
    }

    void delete(Integer id) {
        runs.removeIf(run -> run.id().equals(id));
    }

    @PostConstruct
    private void init() {
        runs.add(new Run(1, "first run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5,
                Location.INDOOR));
        runs.add(new Run(2, "second run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 10,
                Location.OUTDOOR));
    }
}
