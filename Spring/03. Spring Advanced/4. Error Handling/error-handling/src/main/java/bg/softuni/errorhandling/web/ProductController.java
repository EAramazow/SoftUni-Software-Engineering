package bg.softuni.errorhandling.web;

import bg.softuni.errorhandling.model.ObjectNotFoundException;
import bg.softuni.errorhandling.model.ProductDTO;
import bg.softuni.errorhandling.model.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/{id}")
    public String getProductById(@PathVariable("id") Long id,
                                 Model model) {
        ProductDTO productDTO = getProductDTOById(id);

        // uncomment for controller based exception handling
        //  if (productDTO == null) {
        //  throw new ProductNotFoundException(id);
        // }


        if (productDTO == null) {
            throw new ObjectNotFoundException(id);
        }


        model.addAttribute("name", productDTO.getName());

        return "product";
    }

    // uncomment for controller based exception handling
//    @ResponseStatus(value = HttpStatus.NOT_FOUND)
//    @ExceptionHandler({ProductNotFoundException.class})
//    public ModelAndView onProductNotFound(ProductNotFoundException pnfe) {
//        ModelAndView modelAndView = new ModelAndView("product-not-found");
//        modelAndView.addObject("productId", pnfe.getId());
//
//        return modelAndView;
//    }

    private ProductDTO getProductDTOById(Long id) {
        return null;
    }
}
