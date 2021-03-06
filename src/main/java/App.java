import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static spark.Spark.*;
public class App {

        static int getHerokuAssignedPort() {
            ProcessBuilder processBuilder = new ProcessBuilder();
            if (processBuilder.environment().get("PORT") != null) {
                return Integer.parseInt(processBuilder.environment().get("PORT"));
            }
            return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
        }
        public static void main(String[] args) {

            port(getHerokuAssignedPort());
            staticFileLocation("/public");
        staticFileLocation("/public");
        //get to show new hero form
        get("/heroes/new",(request, response) ->  {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"heroform.hbs");
        },new HandlebarsTemplateEngine());
//
        //task: process new hero form
        post ("/heroes/new",(request, response) -> {
            Map<String,Object>model = new HashMap<String, Object>();
            String name =request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String strength= request.queryParams("strength");
            String weakness = request.queryParams("weakness");
            Hero newIdentity =new Hero(name,age,strength,weakness);
            model.put("hero",newIdentity);
            return new ModelAndView(model,"success.hbs");
        }, new HandlebarsTemplateEngine());
//
        //get to show all heroes
        get("/",(request, response) -> {
            Map<String,Object> model = new HashMap<String, Object>();
            ArrayList<Hero> heroes = Hero.getAll();
            ArrayList<Squad>squads =Squad.getAll();
            model.put("heroes",heroes);
//            model.put("squads",squads);
            return new ModelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());
//
        //show an individual hero
        get("/heroes/:id",(request, response) -> {
            Map<String,Object>model = new HashMap<String, Object>();
            int idOfHeroToFind = Integer.parseInt(request.params(":id"));
            Hero foundHero= Hero.findById(idOfHeroToFind);
            model.put("hero",foundHero);
            return new ModelAndView(model,"herodetail.hbs");
        }, new HandlebarsTemplateEngine());
//        get show a form to update hero
        get("/heroes/:id/update",(request, response) -> {
            Map <String,Object>model = new HashMap<>();
            int idOfTheHeroToEdit =Integer.parseInt(request.params("id"));
            Hero editHero = Hero.findById(idOfTheHeroToEdit);
            model.put("editHero",editHero);
            return new ModelAndView(model,"heroform.hbs");
        },new HandlebarsTemplateEngine());
//
        //task:process a form to update a hero
        post("/heroes/:id/update",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            String newName = request.queryParams("name");
            int newAge =Integer.parseInt(request.queryParams("age"));
            String newStrength = request.queryParams("strength");
            String newWeakness = request.queryParams("weakness");
            int idOfTheHeroToEdit =Integer.parseInt(request.params("id"));
            Hero editHero = Hero.findById(idOfTheHeroToEdit);
            editHero.update(newName,newAge,newStrength,newWeakness);
            return new ModelAndView(model,"success.hbs");
        },new HandlebarsTemplateEngine());
        //get: delete an individual hero
        get("/heroes/:id/delete" ,(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            int idOfHeroToDelete = Integer.parseInt(request.params("id"));
            Hero deleteHero = Hero.findById(idOfHeroToDelete);
            deleteHero.deleteById(idOfHeroToDelete);
            return new ModelAndView(model,"success.hbs");
        },new HandlebarsTemplateEngine());

        get("/squads",(request, response) -> {
                        Map<String,Object> model = new HashMap<String, Object>();
                        ArrayList<Squad>squads =Squad.getAll();
                        model.put("squads",squads);
                        return new ModelAndView(model,"squadlist.hbs");
                    }, new HandlebarsTemplateEngine());



        get("/squads/new",(request, response) ->  {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"squadform.hbs");
        },new HandlebarsTemplateEngine());
        get("/squads/list",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model,"squadform.hbs");
        },new HandlebarsTemplateEngine());
        //task: process new squad form
        post ("/squads/list",(request, response) -> {
            Map<String,Object>model = new HashMap<>();
            String squadName =request.queryParams("squadName");
            int squadNumber = Integer.parseInt(request.queryParams("squadNumber"));
            String squadCause= request.queryParams("squadCause");
            Squad newSquadIdentity =new Squad(squadName,squadNumber,squadCause);
            model.put("squad",newSquadIdentity );
            return new ModelAndView(model,"squadsuccess.hbs");
        }, new HandlebarsTemplateEngine());
        get("/squads/list/:id",(request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads = Squad.getAll();
            model.put("squads", squads);
            return new ModelAndView(model, "squadlist.hbs");
        },new HandlebarsTemplateEngine());
    }
}