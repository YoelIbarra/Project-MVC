package Server;


import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

@FunctionalInterface
public interface WithTransaction<E> {
    E method(Request req, Response res, EntityManager em) throws CloneNotSupportedException, ParseException,  IOException, SQLException,  ClassNotFoundException;
}

