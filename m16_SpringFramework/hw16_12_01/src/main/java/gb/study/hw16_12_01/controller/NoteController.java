package gb.study.hw16_12_01.controller;

import gb.study.hw16_12_01.model.Note;
import gb.study.hw16_12_01.service.FileGateway;
import gb.study.hw16_12_01.service.implmnt.NoteServiceImplement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteServiceImplement noteService;
    //это для интеграции
    private final FileGateway fileGateway;

    @GetMapping
    public ResponseEntity<List<Note>> getAll() {
        return new ResponseEntity<>(noteService.getAllNotes(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        fileGateway.writeToFile(note.getTitle() + ".txt", note.toString()); //для интеграции
        return new ResponseEntity<>(noteService.createNote(note), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Note> getNote(@PathVariable("id") Long id) {
        Note noteById;
        try {
            noteById = noteService.getNoteById(id);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Note());
        }
        return new ResponseEntity<>(noteById, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Note> updateNote(@RequestBody Note note) {
        return new ResponseEntity<>(noteService.updateNote(note), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable("id") Long id){
        noteService.deleteNote(id);
        return ResponseEntity.ok().build();
    }

}
