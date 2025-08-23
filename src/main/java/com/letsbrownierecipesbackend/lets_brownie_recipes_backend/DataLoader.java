package com.letsbrownierecipesbackend.lets_brownie_recipes_backend;

import com.letsbrownierecipesbackend.lets_brownie_recipes_backend.model.Recipe;
import com.letsbrownierecipesbackend.lets_brownie_recipes_backend.repository.RecipeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    private final RecipeRepository recipeRepository;

    public DataLoader(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Iniciando o carregamento de dados de teste...");

        // Criação de receitas de exemplo, baseadas no JSON do projeto Angular
        Recipe brownie = new Recipe(
                "Bolo de Chocolate",
                Arrays.asList("Farinha", "Ovos", "Chocolate"),
                Arrays.asList("Misture tudo", "Asse por 40 minutos"),
                "../imgs/brownies_tradicional.jpg",
                40,
                300,
                4.8,
                24
        );

        Recipe pancake = new Recipe(
                "Panqueca",
                Arrays.asList("Farinha", "Leite", "Ovos"),
                Arrays.asList("Misture", "Frite na frigideira"),
                "../imgs/brownies_tradicional.jpg",
                15,
                150,
                4.5,
                12
        );

        // Salva as receitas no banco de dados
        recipeRepository.save(brownie);
        recipeRepository.save(pancake);

        System.out.println("Dados de teste carregados com sucesso.");
        System.out.println("Receitas salvas no banco de dados:");

        // Recupera todas as receitas do banco de dados e imprime no console
        recipeRepository.findAll().forEach(recipe -> {
            System.out.println("ID: " + recipe.getId() + ", Nome: " + recipe.getName());
        });

        System.out.println("Teste de conexão e persistência com o banco de dados concluído.");
    }
}