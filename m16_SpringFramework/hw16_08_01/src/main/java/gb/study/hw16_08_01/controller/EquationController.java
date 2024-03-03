package gb.study.hw16_08_01.controller;
import gb.study.hw16_08_01.model.Equation;
import gb.study.hw16_08_01.service.EquationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class EquationController {

    private final EquationService equationService;

    @GetMapping("/equations")
    public String viewEquations(Model model) {
        List<Equation> equations = equationService.getAllEquations(); // Возврат всех уравнений
        model.addAttribute("equations", equations);      // Добавление уравнений в модель для th:each
        return "equations";                                           // Возврат представления html с уравнениями в виде таблицы
    }

    @PostMapping("/equations")
    public String addEquation(Equation e, Model model) {
        equationService.addEquation(e);
        // ниже "копипаст" из @GetMapping("/equations")
        List<Equation> equations = equationService.getAllEquations();
        model.addAttribute("equations", equations);
        return "equations";
    }

}
