package pl.andrzejjozefow.schooldiary.lesson;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LessonService {

    private final LessonRepository lessonRepository;

    public void addLesson(final Lesson lesson) {
        lessonRepository.save(lesson);
    }

    public List<Lesson> getAllLessons() {
        final List<Lesson> lessons = new ArrayList<>();
        lessonRepository.findAll().forEach(lessons::add);
        return lessons;
    }

}
