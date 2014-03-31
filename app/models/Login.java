package models;

import org.hibernate.validator.constraints.NotEmpty;
import play.data.validation.Constraints;

/**
 * Created by sully.rafiq on 31/03/2014.
 */
public class Login {

    @Constraints.Required
    @Constraints.MaxLength(value = 255)
    @Constraints.Email
    public String email;

    @NotEmpty
    @Constraints.Required
    @Constraints.MinLength(value = 7)
    public String password;

    public String validate() {
        if (User.authenticate(email, password) == null) {
            return "Invalid user or password";
        }
        return null;
    }

}
