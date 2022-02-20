//JAVALIN PACKAGE
import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;
import io.javalin.http.staticfiles.Location;
import static io.javalin.apibuilder.ApiBuilder.before;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.post;
import DB.DBHandler.*;

import utils.Path;
import controller.LoginController;
import controller.*;

public class Main {
    public static void main(String[] args) {
		Javalin app = Javalin.create(config -> {
            //config.addStaticFiles("/templates", Location.CLASSPATH);
			config.addStaticFiles("/static", Location.CLASSPATH);
        }).start(8080);
		app.routes(() -> {
            get(Path.Web.INDEX, PageServer.serveIndexPage);
			get(Path.Web.LOGIN, PageServer.serveLoginPage);
            get(Path.Web.SIGNUP, PageServer.serveSignUpPage);
            get(Path.Web.DASHBOARD, PageServer.serveDashboardPage);
            //get(Path.Web.LOGIN, LoginController.serveLoginPage);
            post(Path.Web.LOGIN, LoginController.handleLoginPost);
            post(Path.Web.POST, PostController.handlePostPost);
			post(Path.Web.SIGNUP, SignUpController.handleSignUpPost);
			post(Path.Web.EDIT, PostController.handleEditData);
            get(Path.Web.LOGOUT, LoginController.handleLogoutGet);
        });
    }
	 
}
