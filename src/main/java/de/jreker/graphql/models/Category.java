package de.jreker.graphql.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Categories")
@Table(name="Categories")
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @javax.persistence.Id
    private int Id;
    private String Name;
    @OneToMany(mappedBy = "Category",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Link> Links = new ArrayList<>();

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public List<Link> getLinks() {
        return Links;
    }

    public void setLinks(List<Link> links) {
        this.Links = links;
    }
}
