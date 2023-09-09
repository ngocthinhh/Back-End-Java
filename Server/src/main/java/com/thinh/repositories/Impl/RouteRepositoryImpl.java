/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.repositories.Impl;

import com.thinh.pojos.Route;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.thinh.repositories.RouteRepository;

/**
 *
 * @author Ngoc Thinh
 */
@Repository
@Transactional
public class RouteRepositoryImpl implements RouteRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Route> getRoute() {
        Session session = sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("FROM Route");
        return q.getResultList();
    }

    @Override
    public void addRoute(Route route) {
        Session session = sessionFactory.getObject().getCurrentSession();
        
        session.save(route);
    }

    @Override
    public void deleteRoute(String id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        Route routeDelete = session.get(Route.class, id);
        
        if (routeDelete != null)
        {
            session.delete(routeDelete);
        }
    }

    @Override
    public Route getRouteById(String id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
//        Query q = session.createQuery("FROM Route WHERE id_route=:id");
//        q.setParameter("id", id);
//        List<Route> routes = q.getResultList();
//        return routes.get(0);
        
        Route route = session.get(Route.class, id);
        return route;
    }

    @Override
    public void updateRoute(Route route) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        session.update(route);
    }
}
