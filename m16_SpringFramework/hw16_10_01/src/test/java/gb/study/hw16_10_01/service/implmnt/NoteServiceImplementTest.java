package gb.study.hw16_10_01.service.implmnt;

import gb.study.hw16_10_01.NoteRepository;
import gb.study.hw16_10_01.model.Note;
import gb.study.hw16_10_01.service.NoteService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class NoteServiceImplementTest {

    @Test
    @DisplayName("createNote")
    void createNote() {
        //подготовка
        NoteRepository noteRepository = mock(NoteRepository.class);
        NoteService noteService = new NoteServiceImplement(noteRepository);
        Note note = new Note();
        note.setContent("test content");
        note.setTitle("test title");
        noteService.createNote(note);

        //действие
        given(noteRepository.save(note))
                .willReturn(note);

        //проверка
        verify(noteRepository).save(note);

    }
}