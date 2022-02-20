package utils;

public class Path {

    public static class Web {
        public static final String INDEX = "/";
        public static final String LOGIN = "/login";
        public static final String SIGNUP = "/signup";
		public static final String EDIT = "/edit";
		public static final String DASHBOARD = "/dashboard";
		public static final String LOGOUT = "/logout";
		public static final String POST = "/post";
    }

    public static class Template {
        public static final String INDEX = "/velocity/index.vm";
        public static final String LOGIN = "/velocity/login.vm";
        public static final String SIGNUP = "/velocity/signup.vm";
        public static final String DASHBOARD = "/velocity/dashboard.vm";
        public static final String NOT_FOUND = "/velocity/notFound.vm";
    }

}