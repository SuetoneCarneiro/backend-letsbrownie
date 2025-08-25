package com.letsbrownierecipesbackend.lets_brownie_recipes_backend.repository;

import com.letsbrownierecipesbackend.lets_brownie_recipes_backend.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByRecipeId(Long recipeId);
}
