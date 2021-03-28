package Server;
import Users.Admin;
import Users.LoginValidator;
import Users.Student;
import spark.*;
import spark.debug.DebugScreen;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.utils.BooleanHelper;
import spark.utils.HandlebarsTemplateEngineBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static spark.Spark.redirect;
import static spark.route.HttpMethod.get;


public class Server {

        private static HandlebarsTemplateEngine engine;
    static EntityManagerFactory entityManagerFactory;


    public static void main(String[] args) {
        Spark.port(9000);
        Server.init();
        DebugScreen.enableDebugScreen();

    }

        private static void initEngine() {
            Server.engine = HandlebarsTemplateEngineBuilder
                    .create()
                    .withDefaultHelpers()
                    .withHelper("isTrue", BooleanHelper.isTrue)
                    .build();
        }

        public static void init() {
            Server.initEngine();
            Spark.staticFileLocation("/public");
            Server.configure();
        }

        private static void configure(){
            HandlebarsTemplateEngine engine = new HandlebarsTemplateEngine();

            redirect.get("/", "/login");

            Spark.get("/login", Server::login, engine);
            Spark.get("/loginIncorrectUser", Server::loginIncorrectUser, engine);


            Spark.post("/loginUser", TemplWithTransaction(Server::validateUserLogin), engine);

        }

    public static ModelAndView login(Request request, Response response) {
        return new ModelAndView(null, "loginUser.html");
    }
    public static ModelAndView loginIncorrectUser(Request request, Response response){
        return new ModelAndView(null,"loginIncorrecto.html");
    }
    public static ModelAndView validateUserLogin (Request request, Response response, EntityManager em){
        String dniS = request.queryParams("dni");
        String fileS = request.queryParams("file");

        int dni = Integer.parseInt(dniS);
        int file = Integer.parseInt(fileS);

        LoginValidator loginValidator = new LoginValidator(em);
        Student student = loginValidator.searchStudent(dni);

        if(student == null) {
            response.status(401);
            response.redirect("/loginIncorrectUser");
        }

        if (student.getDni() == dni && student.getFile() == file){
            request.session(true);
            request.session().attribute("dni", dni);
            request.session().attribute("user", student);
            request.session().maxInactiveInterval(3600);
            request.session().attribute("admin", false);
            response.redirect("/index");
        }

        response.status(401);
        response.redirect("/loginIncorrectUser");

        return null;
    }

    public static ModelAndView validateAdminLogin (Request request, Response response, EntityManager em){
        String user = request.queryParams("user");
        String password = request.queryParams("password");

        LoginValidator loginValidator = new LoginValidator(em);
        Admin admin = loginValidator.searchAdmin(user);

        if(admin == null) {
            response.status(401);
            response.redirect("/loginIncorrectUser");
        }

        if (admin.getUser().equals(user) && admin.getPassword().equals(password)){
            request.session(true);
            request.session().attribute("username", user);
            request.session().attribute("user", admin);
            request.session().maxInactiveInterval(3600);
            request.session().attribute("admin", true);
            response.redirect("/index"); //TODO el redirect va a el index del admin
        }

        response.status(401);
        response.redirect("/loginIncorrectAdmin"); // TODO el login incorrect del admin

        return null;
    }

    /*
        The next two methods are going to use a Template who is going to use transactions
     */
    private static TemplateViewRoute TemplWithTransaction(WithTransaction<ModelAndView> fn) {
        TemplateViewRoute r = (req, res) -> {
            EntityManager em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();
            try {
                ModelAndView result = fn.method(req, res, em);
                em.getTransaction().commit();
                return result;
            } catch (Exception ex) {
                em.getTransaction().rollback();
                throw ex;
            }
            finally {em.close();}
        };
        return r;
    }

    private static Route RouteWithTransaction(WithTransaction<Object> fn) {
        Route r = (req, res) -> {
            EntityManager em = entityManagerFactory.createEntityManager();
            em.getTransaction().begin();
            try {
                Object result = fn.method(req, res, em);
                em.getTransaction().commit();
                return result;
            } catch (Exception ex) {
                em.getTransaction().rollback();
                throw ex;
            }
            finally {em.close();}
        };
        return r;
    }


    }

