package de.jreker.graphql.GraphQL;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import de.jreker.graphql.hibernate.HibernateUtil;
import de.jreker.graphql.models.Category;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;


import java.util.List;


//This class must have the same name as the Query in the schema.
//Also the methods need to have the same name as in the graphsqls schema.
@Component
public class CategoryQueryResolver implements GraphQLQueryResolver {


    public Category categoryById(int id) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        String hsql = "Select e from " + Category.class.getName() + " e where id = " + id;
        Query<Category> query = session.createQuery(hsql);
        Category cat = query.getSingleResult();
        Hibernate.initialize(cat.getLinks());
        session.getTransaction().commit();
        session.close();
        return cat;
    }

    public Iterable<Category> getCategories() {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        String hsql = "from " + Category.class.getName() + " e";
        Query<Category> query = session.createQuery(hsql);
        List<Category> cats = query.getResultList();
        Hibernate.initialize(cats);
        cats.forEach(item -> Hibernate.initialize(item.getLinks()));

        session.getTransaction().commit();
        session.close();
        return cats;
    }


}
