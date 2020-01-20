package app.web.servlets;

import app.util.FileUtil;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class HomeServ extends HttpServlet {

    private final FileUtil fileUtil;

    @Inject
    public HomeServ(FileUtil fileUtil) {
        this.fileUtil = fileUtil;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PrintWriter out = resp.getWriter();
        String html = this.fileUtil.readFile("C:\\Users\\Vasil\\Desktop\\SoftUni\\Java Web\\Java Web Basics\\IntroductionToJavaEE\\skeleton\\src\\main\\webapp\\views\\home.html");
        out.println(html);

    }
}
//        StringBuilder sb = new StringBuilder();
//
//        File file = new File("C:\\Users\\Vasil\\Desktop\\SoftUni\\Java Web\\Java Web Basics\\IntroductionToJavaEE\\skeleton\\src\\main\\webapp\\views\\home.html");
//        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
//
//        String line;
//
//        while ((line = bf.readLine()) != null){
//            sb.append(line).append(System.lineSeparator());
//        }
