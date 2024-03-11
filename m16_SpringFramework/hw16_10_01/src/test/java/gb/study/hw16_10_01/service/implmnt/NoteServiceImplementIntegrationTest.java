package gb.study.hw16_10_01.service.implmnt;

import gb.study.hw16_10_01.NoteRepository;
import gb.study.hw16_10_01.model.Note;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class NoteServiceImplementIntegrationTest {
    //подготовка ч.1
    @Autowired
    private NoteServiceImplement noteService;
    @MockBean
    private NoteRepository noteRepository;

    @Test
    @DisplayName("createNote")
    void createNote() {
        //подготовка ч.2
        Note note = new Note();
        note.setContent("test content");
        note.setTitle("test title");
        noteService.createNote(note);

        //действие
        lenient().when(noteRepository.save(note)).thenReturn(note);

        //проверка
        verify(noteRepository).save(note);

    }

}