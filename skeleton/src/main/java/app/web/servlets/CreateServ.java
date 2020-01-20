package app.web.servlets;

import app.domain.models.binding.CarBindingModel;
import app.domain.models.service.CarServiceModel;
import app.service.CarServiceImpl;
import app.util.FileUtil;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/create")
public class CreateServ extends HttpServlet {

    private final static String FILE_PATH = "C:\\Users\\Vasil\\Desktop\\SoftUni\\Java Web\\Java Web Basics\\IntroductionToJavaEE\\skeleton\\src\\main\\webapp\\views\\create.html";

    private final FileUtil fileUtil;
    private final ModelMapper modelMapper;
    private final CarServiceImpl carService;

    @Inject
    public CreateServ(FileUtil fileUtil, ModelMapper modelMapper, CarServiceImpl carService) {
        this.fileUtil = fileUtil;
        this.modelMapper = modelMapper;
        this.carService = carService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        String html = this.fileUtil.readFile(FILE_PATH);
        out.println(html);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CarBindingModel carBindingModel = new CarBindingModel();
        carBindingModel.setBrand(req.getParameter("brand"));
        carBindingModel.setEngine(req.getParameter("engine"));
        carBindingModel.setModel(req.getParameter("model"));
        carBindingModel.setYear(Integer.parseInt(req.getParameter("year")));

        this.carService.createCar(this.modelMapper.map(carBindingModel, CarServiceModel.class));

        System.out.println();

        resp.sendRedirect("/all");

    }
}
