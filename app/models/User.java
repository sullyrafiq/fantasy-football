package models;

import be.objectify.deadbolt.core.models.Permission;
import be.objectify.deadbolt.core.models.Role;
import be.objectify.deadbolt.core.models.Subject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import play.data.validation.Constraints;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sully.rafiq
 * Date: 27/03/14
 * Time: 18:55
 * To change this template use File | Settings | File Templates.
 */
public class User implements Subject {

    public String email;
    public String password;
    public String role;



    @Override
    @JsonIgnore
    public List<? extends Role> getRoles() {
        return Arrays.asList(new Role() {
            @Override
            public String getName() {
                return role;
            }
        });
    }

    @Override
    @JsonIgnore
    public List<? extends Permission> getPermissions() {
        return Collections.emptyList();
    }

    @Override
    @JsonIgnore
    public String getIdentifier() {
        return email;
    }

    public static User authenticate(String email, String password) {

        if (email.equals("sullyrafiq@gmail.com") && password.equals("password")) {

            // TODO this should come from the DB
            User user = getMockUser();

            return user;
        }

        return null;
    }

    @JsonIgnore
    public static User getMockUser() {
        User user = new User();
        user.email = "sullyrafiq@gmail.com";
        user.password = "password";
        user.role = "admin";
        return user;
    }
}