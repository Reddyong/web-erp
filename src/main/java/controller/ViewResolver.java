package controller;

public class ViewResolver {
    public static String makeView(String view) {
        return "/WEB-INF/views/" + view + ".jsp";
    }
}
