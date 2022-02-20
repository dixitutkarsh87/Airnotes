package controller;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import utils.Path;
import DB.DBHandler;
import java.util.HashMap;
import java.util.Map;
import utils.ViewUtil;

public class PageServer{
	public static Handler serveLoginPage = ctx -> {
        ctx.render(Path.Template.LOGIN);
    };
	public static Handler serveIndexPage = ctx -> {
        ctx.render(Path.Template.INDEX);
    };
	public static Handler serveSignUpPage = ctx -> {
        ctx.render(Path.Template.SIGNUP);
    };
	public static Handler serveDashboardPage = ctx -> {
		Map<String, Object> model = ViewUtil.baseModel(ctx);
		model.put("posts",DBHandler.getPost(ctx.cookieStore("email")));
        ctx.render(Path.Template.DASHBOARD,model);
    };
}