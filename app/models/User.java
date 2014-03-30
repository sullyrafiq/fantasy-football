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

    @Constraints.Required
    @Constraints.MaxLength(value = 255)
    @Constraints.Email
    private String username;

    @NotEmpty
    @Constraints.Required
    @Constraints.MinLength(value = 7)
    private String password;

    private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

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
        return getUsername();
    }
}