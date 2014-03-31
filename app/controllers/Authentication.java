package controllers;

import com.football.security.SecurityUtil;
import models.Login;
import models.User;
import play.data.Form;
import play.mvc.*;

import views.html.*;

public class Authentication extends Controller {

    private static Form<Login> loginForm = new Form<Login>(Login.class);

    public static Result index() {
        return ok(login.render(loginForm));
    }

    public static Result authenticate() {

        Form<Login> filledInForm = loginForm.bindFromRequest();
        if (filledInForm.hasErrors()) {
            System.out.println("Login failed validation " + filledInForm.errorsAsJson());
            return badRequest(login.render(filledInForm));
        } else {
            SecurityUtil.storeUserInSession(session(), User.getMockUser());
            return redirect("/predictions");
        }
    }
}
