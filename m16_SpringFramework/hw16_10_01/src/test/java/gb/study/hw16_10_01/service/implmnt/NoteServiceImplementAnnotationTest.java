package gb.study.hw16_10_01.service.implmnt;

import gb.study.hw16_10_01.NoteRepository;
import gb.study.hw16_10_01.model.Note;
import gb.study.hw16_10_01.service.NoteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class NoteServiceImplementAnnotationTest {
    //подготовка ч.1
    @Mock
    private NoteRepository noteRepository;
//    Код ниже не сработал, потому что это интерфейс
//    @InjectMocks
//    private NoteService noteService;
    private NoteServiceImplement noteService;

    @BeforeEach
    void setUp() {
        noteService = new NoteServiceImplement(noteRepository);
    }

    @Test
    @DisplayName("createNote")
    void createNote() {
        //подготовка ч.2
        Note note = new Note();
        note.setContent("test content");
        note.setTitle("test title");
        noteService.createNote(note);

        //действие
//        given(noteRepository.save(note))
//                .willReturn(note);
        lenient().when(noteRepository.save(note)).thenReturn(note);

        //проверка
        verify(noteRepository).save(note);

    }
}