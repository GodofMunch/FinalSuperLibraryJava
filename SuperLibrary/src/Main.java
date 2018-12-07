import Hibernate.AuthorEntity;
import Hibernate.CustomerEntity;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.jdbc.Work;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.stat.SessionStatistics;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }


    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {

            frmGUI SuperLibrary = new frmGUI(session);

            //https://examples.javacodegeeks.com/enterprise-java/hibernate/retrieve-object-by-id-in-hibernate/
            try{
                session.beginTransaction();

               /* CustomerEntity dbCust = session.get(CustomerEntity.class, email);
                System.out.println(dbCust.getCustpassword());
                session.getTransaction().commit();*/
            } catch (HibernateException e){
                System.out.println("Hibernate Exception : " + e.toString());
            }









            /*System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }*/
        } finally {
            //session.close();
        }


        /*
        String hql = "select custpassword FROM CustomerEntity WHERE email = :email";
            Query myQuery = session.createQuery(hql);
            myQuery.setParameter("email","daveytheguitarist@yahoo.com");
            System.out.println(myQuery.getSingleResult().toString());
         */
    }
}