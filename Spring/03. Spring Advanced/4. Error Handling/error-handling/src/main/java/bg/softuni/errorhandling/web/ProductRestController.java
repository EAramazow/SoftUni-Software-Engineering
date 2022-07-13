package bg.softuni.errorhandling.web;

import bg.softuni.errorhandling.model.APIErrorDTO;
import bg.softuni.errorhandling.model.ObjectNotFoundException;
import bg.softuni.errorhandling.model.ProductDTO;
import bg.softuni.errorhandling.model.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Long id) {
        ProductDTO productDTO = getProductDTOById(id);

        if (productDTO == null) {
            throw new ProductNotFoundException(id);
        }

        return ResponseEntity.ok(productDTO);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ProductNotFoundException.class})
    public @ResponseBody APIErrorDTO handleRestErrors(ProductNotFoundException e) {
        return new APIErrorDTO(e.getId(), "Product was not found!");
    }

    private ProductDTO getProductDTOById(Long id) {
        return null;
    }
}
