package de.jreker.graphql.GraphQL;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import de.jreker.graphql.hibernate.HibernateUtil;
import de.jreker.graphql.models.Category;
import de.jreker.graphql.models.Link;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import javax.persistence.NoResultException;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class MutationResolver implements GraphQLMutationResolver {
    public Link addLink(String Name, String Url, int CategoryId){
        Link link = new Link();
        link.setName(Name);
        link.setUrl(Url);

        CategoryQueryResolver res = new CategoryQueryResolver();
        link.setCategory(res.categoryById(CategoryId));


        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();

        session.getTransaction().begin();
        session.save(link);
        session.getTransaction().commit();
        session.close();
        return link;
    }

    public Link updateLink(int Id, String Name, String Url, Integer CategoryId) {
        LinkQueryResolver res = new LinkQueryResolver();
        Optional<Link> link = Optional.of(res.linkById(Id));

        if(link.isPresent()) {
            link.get().setName(Optional.ofNullable(Name).orElse(link.get().getName()));
            link.get().setUrl(Optional.ofNullable(Url).orElse(link.get().getUrl()));
            try {
                CategoryQueryResolver resCat = new CategoryQueryResolver();
                if(CategoryId != null) {
                    Category cat = resCat.categoryById(CategoryId);
                    link.get().setCategory(cat);
                }

                //link.get().setCategory(Optional.ofNullable(resCat.categoryById(CategoryId)).orElse(link.get().getCategory()));
            } catch(NoResultException ex) {
                //no result TODO: Add logging
            }
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.getCurrentSession();

            session.getTransaction().begin();
            session.update(link.get());
            session.getTransaction().commit();
            session.close();
            return link.get();
        } else {
            throw new NoSuchElementException("Link not found in db.");
        }
    }
}
