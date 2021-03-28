package Users;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class LoginValidator {

    private EntityManager entityManager;

    public LoginValidator(EntityManager _entityManager){
        entityManager = _entityManager;
    }

    public Student searchStudent(int dni){
        Student student = null;
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> consult = cb.createQuery(Student.class);
        Root<Student> users = consult.from(Student.class);
        Predicate condition = cb.equal(users.get("dni"), dni);
        CriteriaQuery<Student> where = consult.select(users).where(condition);
        try {
            student = this.entityManager.createQuery(where).getSingleResult();
            return student;
        } catch (NoResultException nre){

        }

        if(student == null){
            return null;
        }
        return student;
    }

    public Admin searchAdmin(String user){
        Admin admin = null;
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Admin> consult = cb.createQuery(Admin.class);
        Root<Admin> users = consult.from(Admin.class);
        Predicate condition = cb.equal(users.get("user"), user);
        CriteriaQuery<Admin> where = consult.select(users).where(condition);
        try {
            admin = this.entityManager.createQuery(where).getSingleResult();
            return admin;
        } catch (NoResultException nre){

        }

        if(admin == null){
            return null;
        }
        return admin;
    }
}
