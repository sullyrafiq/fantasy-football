package com.football.security;

import be.objectify.deadbolt.core.models.Subject;
import be.objectify.deadbolt.java.DeadboltHandler;
import be.objectify.deadbolt.java.DynamicResourceHandler;
import play.libs.F;
import play.mvc.Http;
import play.mvc.SimpleResult;

import static play.mvc.Results.redirect;

public class FFDeadboltHandler implements DeadboltHandler {

	@Override
    public F.Promise<SimpleResult> beforeAuthCheck(Http.Context context) {
        return null; // Apparently returning null means that everything is OK.
    }

    @Override
    public Subject getSubject(Http.Context context) {
        return SecurityUtil.getUserFromSession(context.session());
    }

    @Override
    public F.Promise<SimpleResult> onAuthFailure(Http.Context context, String content) {
        return F.Promise.promise(new F.Function0<SimpleResult>() {
            @Override
            public SimpleResult apply()  {
                return redirect("/login");
            }
        });
    }

    @Override
    public DynamicResourceHandler getDynamicResourceHandler(Http.Context context) {
        return null;
    }

}
