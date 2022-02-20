package controller;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import utils.*;
import Cipher.SHA512;
import java.util.Map;
import DB.DBHandler;

public class PostController{
	public static Handler handlePostPost = ctx -> {
		String passwd = ctx.cookieStore("password");
		passwd = SHA512.encrypt(ctx.formParam("notes_text"),passwd,"1234");
		if(ctx.formParam("post_id")==null){
			DBHandler.storePost(ctx.cookieStore("email"), ctx.formParam("notes_title"),passwd);
		}
		else{
			System.out.println("POSTIDII IS "+ctx.formParam("post_id"));
			DBHandler.editPost(ctx.cookieStore("email"),ctx.formParam("notes_title"),passwd,ctx.formParam("post_id"));
		}
		ctx.redirect("/dashboard");
	};
	public static Handler handleEditData = ctx -> {
		String passwd = ctx.cookieStore("password");
		String data = SHA512.decrypt(ctx.formParam("cipher_text"),passwd,"1234");
		String data_title = ctx.formParam("data_title");
		Map<String, Object> model = ViewUtil.baseModel(ctx);
		model.put("data",data);
		model.put("data_title",data_title);
		model.put("data_id",ctx.formParam("post_id"));
		model.put("posts",DBHandler.getPost(ctx.cookieStore("email")));
        ctx.render(Path.Template.DASHBOARD,model);
	};
}