package utils;

import io.javalin.http.Context;
import java.util.HashMap;
import java.util.Map;

public class ViewUtil{
    public static Map<String, Object> baseModel(Context ctx) {
        Map<String, Object> model = new HashMap<>();
        model.put("currentUser", ctx.cookieStore("email"));
        return model;
    }
}