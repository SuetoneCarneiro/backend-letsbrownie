package com.letsbrownierecipesbackend.lets_brownie_recipes_backend.controller;

import com.letsbrownierecipesbackend.lets_brownie_recipes_backend.model.Comment;
import com.letsbrownierecipesbackend.lets_brownie_recipes_backend.service.CommentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/recipes/{recipeId}/comments")
@CrossOrigin(origins = "http://localhost:4200")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getCommentsByRecipeId(@PathVariable Long recipeId) {
        return commentService.findByRecipeId(recipeId);
    }

    @PostMapping
    public Comment createComment(@PathVariable Long recipeId, @RequestBody Comment newComment) {
        return commentService.save(recipeId, newComment);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        commentService.deleteById(commentId);
    }
}
