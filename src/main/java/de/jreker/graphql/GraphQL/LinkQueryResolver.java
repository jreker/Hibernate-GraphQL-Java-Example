package de.jreker.graphql.graphQL;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import de.jreker.graphql.models.Link;
import de.jreker.graphql.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LinkQueryResolver implements GraphQLQueryResolver {

    @Autowired
    LinkRepository linkRepository;

    public Link linkById(final int id) {
        return linkRepository.findById(id).orElse(null);

    }

    public Iterable<Link> getLinks() {
        return linkRepository.findAll();
    }
}
