package de.jreker.graphql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.jreker.graphql.models.Link;

/**
 * LinkRepository
 */
@Repository
public interface LinkRepository extends JpaRepository<Link, Integer> {
}