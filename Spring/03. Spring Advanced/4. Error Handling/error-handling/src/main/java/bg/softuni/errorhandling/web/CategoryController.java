package bg.softuni.errorhandling.web;

import bg.softuni.errorhandling.model.CategoryDTO;
import bg.softuni.errorhandling.model.ObjectNotFoundException;
import bg.softuni.errorhandling.model.ProductDTO;
import bg.softuni.errorhandling.model.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @GetMapping("/{id}")
    public String getCategoryById(@PathVariable("id") Long id,
                                 Model model) {
        CategoryDTO categoryDTO = getCategoryDTOById(id);

        // uncomment for controller based exception handling
        if (categoryDTO == null) {
            throw new ObjectNotFoundException(id);
        }

        model.addAttribute("name", categoryDTO.getCategoryName());

        return "category";
    }


    private CategoryDTO getCategoryDTOById(Long id) {
        return null;
    }
}
