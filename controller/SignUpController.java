package controller;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import utils.Path;
import Cipher.hasher;
import DB.DBHandler;

public class SignUpController{
	public static Handler handleSignUpPost = ctx -> {
		System.out.println(ctx.formParam("email"));
		System.out.println(hasher.sha256(ctx.formParam("passwd")));
		DBHandler.createUser(ctx.formParam("email"),hasher.sha256(ctx.formParam("passwd")));
		ctx.redirect("/login");
	};
}