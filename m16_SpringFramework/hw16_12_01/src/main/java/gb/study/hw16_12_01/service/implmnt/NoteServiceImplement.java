package gb.study.hw16_12_01.service.implmnt;

import gb.study.hw16_12_01.NoteRepository;
import gb.study.hw16_12_01.model.Note;
import gb.study.hw16_12_01.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceImplement implements NoteService {

    private final NoteRepository noteRepository;

    @Override
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    @Override
    public Note updateNote(Note note) {
        Note noteById = getNoteById(note.getId());

        noteById.setTitle(note.getTitle());
        noteById.setContent(note.getContent());

        return noteRepository.save(note);
    }

    //    @Override
//    public void deleteNote(Long id) {
//        Note noteById = getNoteById(id);
//        noteRepository.delete(noteById);
//    }
    // Исправление ошибки
    @Override
    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}
