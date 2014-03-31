package controllers;

import be.objectify.deadbolt.java.actions.SubjectPresent;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.predictions;

public class Predictions extends Controller {

    @SubjectPresent
    public static Result fixtures() {
        return ok(predictions.render());
    }
}
