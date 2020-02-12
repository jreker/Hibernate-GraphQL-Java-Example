package de.jreker.graphql.graphQL;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import de.jreker.graphql.models.Category;
import de.jreker.graphql.repositories.CategoryRepository;


//This class must have the same name as the Query in the schema.
//Also the methods need to have the same name as in the graphsqls schema.
@Component
public class CategoryQueryResolver implements GraphQLQueryResolver {

    @Autowired
    CategoryRepository categoryRepository;

    public Category categoryById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Iterable<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
