package de.jreker.graphql.graphQL;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import de.jreker.graphql.models.Link;
import de.jreker.graphql.repositories.CategoryRepository;
import de.jreker.graphql.repositories.LinkRepository;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class MutationResolver implements GraphQLMutationResolver {

    CategoryRepository categoryRepository;
    LinkRepository linkRepository;

    // Constructor DI
    public MutationResolver(CategoryRepository categoryRepository, LinkRepository linkRepository) {
        this.categoryRepository = categoryRepository;
        this.linkRepository = linkRepository;
    }

    public Link addLink(String Name, String Url, int CategoryId) throws NotFoundException {
        Link link = new Link();
        link.setName(Name);
        link.setUrl(Url);

        link.setCategory(categoryRepository.findById(CategoryId)
                                           .orElseThrow(() -> new NotFoundException("Category not found", CategoryId)));
        linkRepository.save(link);
        return link;
    }

    public Link updateLink(int Id, String Name, String Url, Integer CategoryId) {
        Optional<Link> link = Optional.ofNullable(linkRepository.findById(Id)
                .orElseThrow(() -> new NotFoundException("Link not found", Id)));

        link.get().setName(Optional.ofNullable(Name).orElse(link.get().getName()));
        link.get().setUrl(Optional.ofNullable(Url).orElse(link.get().getUrl()));
        link.get().setCategory(categoryRepository.findById(CategoryId)
                                                 .orElseThrow(() -> new NotFoundException("Category not found", CategoryId)));

        return linkRepository.save(link.orElseThrow(() -> new NotFoundException("Link not found", Id)));
    }
}
