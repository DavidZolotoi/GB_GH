package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class NumberGame extends AbstractGame {
    @Override
    List<String> getGeneratedCharList() {
        List<String> charList = new ArrayList<>();
        for (int i = 0; i <= 9; i++) charList.add(String.valueOf(i));
        return charList;
    }
}

