package controller;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import utils.Path;
import Cipher.hasher;
import DB.DBHandler;
import controller.UserChecker;

public class LoginController{
	public static Handler handleLoginPost = ctx -> {
		if (DBHandler.checkUser(ctx.formParam("email"),hasher.sha256(ctx.formParam("passwd")))==1){
			ctx.cookieStore("password", ctx.formParam("passwd"));
			ctx.cookieStore("email", ctx.formParam("email"));
			ctx.redirect("/dashboard");
		}
		else{
		ctx.redirect("/login");
		}
	};
	public static Handler handleLogoutGet = ctx -> {
		ctx.clearCookieStore();
		ctx.redirect("/");
	};
}