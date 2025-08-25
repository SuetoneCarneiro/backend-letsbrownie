package com.letsbrownierecipesbackend.lets_brownie_recipes_backend.service;

import com.letsbrownierecipesbackend.lets_brownie_recipes_backend.model.Comment;
import com.letsbrownierecipesbackend.lets_brownie_recipes_backend.model.Recipe;
import com.letsbrownierecipesbackend.lets_brownie_recipes_backend.repository.CommentRepository;
import com.letsbrownierecipesbackend.lets_brownie_recipes_backend.repository.RecipeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final RecipeRepository recipeRepository;

    public CommentService(CommentRepository commentRepository, RecipeRepository recipeRepository) {
        this.commentRepository = commentRepository;
        this.recipeRepository = recipeRepository;
    }

    public List<Comment> findByRecipeId(Long recipeId) {
        return commentRepository.findByRecipeId(recipeId);
    }

    public Comment save(Long recipeId, Comment newComment) {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new RuntimeException("Receita não encontrada com o ID: " + recipeId));
        newComment.setRecipe(recipe);
        return commentRepository.save(newComment);
    }

    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }
}
