package com.letsbrownierecipesbackend.lets_brownie_recipes_backend.repository;

import com.letsbrownierecipesbackend.lets_brownie_recipes_backend.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
