import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static spark.Spark.*;
public class App {
    public static void main(String[] args) {
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }
        port(port);
        staticFileLocation("/public");
        //get to show new hero form
        get("/heros/new",(request, response) ->  {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"hero-form.hbs");
        },new HandlebarsTemplateEngine());
//
        //task: process new hero form
        post ("/heros/new",(request, response) -> {
            Map<String,Object>model = new HashMap<String, Object>();
            String name =request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String power= request.queryParams("power");
            String weakness = request.queryParams("weakness");
            Hero newIdentity =new Hero(name,age,power,weakness);
            model.put("hero",newIdentity);
            return new ModelAndView(model,"success.hbs");
        }, new HandlebarsTemplateEngine());
//