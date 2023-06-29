package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class EnGame extends AbstractGame{
    @Override
    List<String> getGeneratedCharList() {
        List<String> charList = new ArrayList<>();
        for (int i = 'a'; i <= 'z'; i++) charList.add(String.valueOf((char) i));
        return charList;
    }
}
