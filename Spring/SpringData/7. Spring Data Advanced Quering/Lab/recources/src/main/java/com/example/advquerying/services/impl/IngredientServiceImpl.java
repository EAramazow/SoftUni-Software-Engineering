package com.example.advquerying.services.impl;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.repositories.IngredientRepository;
import com.example.advquerying.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public List<Ingredient> selectNameStartsWith(String start) {
      return this.ingredientRepository.findByNameStartingWith(start);
    }

    @Override
    public List<Ingredient> selectInNames(List<String> names) {
        return this.ingredientRepository.findByNameInOrderByPriceAsc(names);
    }

    @Override
    public int deleteByName(String name) {
        return this.ingredientRepository.deleteByName(name);
    }

    @Override
    @Transactional
    public void increasePriceBy(double percent) {
        BigDecimal actualPercent = BigDecimal.valueOf(percent);
        this.ingredientRepository.increasePriceByPercent(actualPercent);
    }

    @Override
    public int increasePriceByGivenIngredientsNames(BigDecimal price, List<String> names) {
        return this.ingredientRepository.increasePriceByListOfNames(price, names);
    }


}
