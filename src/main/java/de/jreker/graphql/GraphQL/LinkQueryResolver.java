package de.jreker.graphql.GraphQL;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import de.jreker.graphql.hibernate.HibernateUtil;
import de.jreker.graphql.models.Link;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Component
public class LinkQueryResolver implements GraphQLQueryResolver {

    public Link linkById(int id){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();

        session.getTransaction().begin();

        String hsql = "Select e from " + Link.class.getName() + " e where id = " + id;
        Query<Link> query = session.createQuery(hsql);
        Link link = query.getSingleResult();

        session.getTransaction().commit();
        session.close();
        return link;
    }

    public Iterable<Link> getLinks() {
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.getCurrentSession();

            session.getTransaction().begin();
            String hsql = "Select e from " + Link.class.getName() + " e";
            Query<Link> query = session.createQuery(hsql);
            List<Link> links = query.getResultList();
            session.getTransaction().commit();
            return links;
        } catch(Exception ex) {
            throw new APIError(200,ex.getMessage().toString());
        }

    }
}
