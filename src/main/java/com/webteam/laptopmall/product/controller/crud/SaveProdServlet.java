package com.webteam.laptopmall.product.controller.crud;

import com.webteam.laptopmall.product.builder.dto.keyboard.KeyboardDTOBuilder;
import com.webteam.laptopmall.product.builder.dto.keyboard.KeyboardDTOBuilderImpl;
import com.webteam.laptopmall.product.builder.dto.laptop.LaptopDTOBuilder;
import com.webteam.laptopmall.product.builder.dto.laptop.LaptopDTOBuilderImpl;
import com.webteam.laptopmall.product.builder.dto.monitor.MonitorDTOBuilder;
import com.webteam.laptopmall.product.builder.dto.monitor.MonitorDTOBuilderImpl;
import com.webteam.laptopmall.product.ECategory;
import com.webteam.laptopmall.product.dto.LaptopDTO;
import com.webteam.laptopmall.product.dto.MechanicalKeyboardDTO;
import com.webteam.laptopmall.product.dto.MonitorDTO;
import com.webteam.laptopmall.product.dto.ProductDTO;
import com.webteam.laptopmall.product.entity.Laptop;
import com.webteam.laptopmall.product.entity.MechanicalKeyboard;
import com.webteam.laptopmall.product.entity.Monitor;
import com.webteam.laptopmall.file.prod.ProdImgIO;
import com.webteam.laptopmall.file.prod.ProdImgIOImpl;
import com.webteam.laptopmall.product.controller.GetProdByIdServlet;
import com.webteam.laptopmall.product.service.ProdService;
import com.webteam.laptopmall.product.service.ProdServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@MultipartConfig()
@WebServlet("/save-prod")
public class SaveProdServlet extends HttpServlet {
    private ProdService prodService;
    private ProdImgIO prodImgIO;
    private static final Logger log = Logger.getLogger(GetProdByIdServlet.class.getName());
    private LaptopDTOBuilder laptopDTOBuilder;
    private KeyboardDTOBuilder keyboardDTOBuilder;
    private MonitorDTOBuilder monitorDTOBuilder;

    @Override
    public void init() throws ServletException {
        super.init();
        prodService = new ProdServiceImpl();
        prodImgIO = new ProdImgIOImpl();
        laptopDTOBuilder = new LaptopDTOBuilderImpl();
        keyboardDTOBuilder = new KeyboardDTOBuilderImpl();
        monitorDTOBuilder = new MonitorDTOBuilderImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String url = "/WEB-INF/views/seller-main-page.jsp";
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        boolean isSuccessful=false;
        String realPath = req.getServletContext().getRealPath("/");
        Long id = null;
        String id_str = req.getParameter("id");
        if(!id_str.equals(""))
            id = Long.valueOf(id_str);
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        String desc = req.getParameter("desc");
        BigDecimal price = BigDecimal.valueOf(Double.valueOf(req.getParameter("price")));
        Integer stockQty = Integer.valueOf(req.getParameter("stockQty"));
        double discountPercent = Double.valueOf(req.getParameter("discountPercent"));
        String version = req.getParameter("version");
        String color = req.getParameter("color");
        int releaseYear  = Integer.valueOf(req.getParameter("releaseYear"));

        ECategory category = ECategory.valueOf(req.getParameter("category"));

        List<Part> parts = resolvePartList(req,"images");

        if(category.equals(ECategory.LAPTOP)) {
            String cpuName = req.getParameter("cpuName");
            int cpuCores = Integer.valueOf(req.getParameter("cpuCores")) ;
            int cpuThreads = Integer.valueOf(req.getParameter("cpuThreads")) ;
            double cpuSpeed = Double.valueOf(req.getParameter("cpuSpeed")) ;
            double cpuMaxSpeed = Double.valueOf(req.getParameter("cpuMaxSpeed")) ;
            int cpuCache = Integer.valueOf(req.getParameter("cpuCache")) ;
            int ramSize = Integer.valueOf(req.getParameter("ramSize")) ;
            Laptop.ERam ramType =Laptop.ERam.valueOf(req.getParameter("ramType")) ;
            int ramBusSpeed = Integer.valueOf(req.getParameter("ramBusSpeed")) ;
            int ramMaxSupport = Integer.valueOf(req.getParameter("ramMaxSupport")) ;
            Laptop.ERom romType = Laptop.ERom.valueOf(req.getParameter("romType")) ;
            int romSize = Integer.valueOf( req.getParameter("romSize"));
            double screenSize = Double.valueOf(req.getParameter("screenSize")) ;
            String screenResolution = req.getParameter("screenResolution");
            int screenRefreshRate = Integer.valueOf(req.getParameter("screenRefreshRate")) ;
            String screenTechnology = req.getParameter("screenTechnology");
            int brightness = Integer.valueOf(req.getParameter("brightness")) ;
            boolean antiGlare = Boolean.valueOf(req.getParameter("antiGlare")) ;
            String graphicsCard = req.getParameter("graphicsCard");
            double weight = Double.valueOf( req.getParameter("weight"));
            String material = req.getParameter("material");
            Laptop.EOS operatingSystem = Laptop.EOS.valueOf(req.getParameter("operatingSystem")) ;

            LaptopDTO laptopDTO = laptopDTOBuilder
                    .cpuName(cpuName)
                    .cpuCores(cpuCores)
                    .cpuThreads(cpuThreads)
                    .cpuSpeed(cpuSpeed)
                    .cpuMaxSpeed(cpuMaxSpeed)
                    .cpuCache(cpuCache)
                    .ramSize(ramSize)
                    .ramType(ramType)
                    .ramBusSpeed(ramBusSpeed)
                    .ramMaxSupport(ramMaxSupport)
                    .romType(romType)
                    .romSize(romSize)
                    .screenSize(screenSize)
                    .screenResolution(screenResolution)
                    .screenRefreshRate(screenRefreshRate)
                    .screenTechnology(screenTechnology)
                    .brightness(brightness)
                    .antiGlare(antiGlare)
                    .graphicsCard(graphicsCard)
                    .weight(weight)
                    .material(material)
                    .operatingSystem(operatingSystem)
                    .id(id)
                    .brand(brand)
                    .model(model)
                    .desc(desc)
                    .price(price)
                    .stockQty(stockQty)
                    .discountPercent(discountPercent)
                    .version(version)
                    .color(color)
                    .category(ECategory.LAPTOP)
                    .releaseYear(releaseYear)
                    .build();
            try {
                if(laptopDTO.getId() == null)
                    id = prodService.save(laptopDTO).getId();
                else
                    prodService.update(laptopDTO);

                if(parts!= null)
                    prodImgIO.saveProductImages(id,realPath,parts);

                isSuccessful=true;

            }catch (Exception e){
                log.log(Level.SEVERE,e.getMessage());
            }
        } else if (category.equals(ECategory.MECHANICAL_KEYBOARD)) {
            Set<Laptop.EOS> compatibilities = new HashSet<>() ;
            compatibilities.add(Laptop.EOS.valueOf(req.getParameter("compatibilities")));
            Set<MechanicalKeyboard.EConnection> connections = new HashSet<>(); ;
            connections.add(MechanicalKeyboard.EConnection.valueOf(req.getParameter("connections")));
            String cableLength = req.getParameter("cableLength");
            String switchType = req.getParameter("switchType");
            MechanicalKeyboard.ELayout layout = MechanicalKeyboard.ELayout.valueOf(req.getParameter("layout")) ;
            int keyCount = Integer.valueOf(req.getParameter("keyCount")) ;
            String keycapMaterial = req.getParameter("keycapMaterial");
            String batteryType = req.getParameter("batteryType");


            MechanicalKeyboardDTO mechanicalKeyboardDTO = keyboardDTOBuilder
                    .compatibilities(compatibilities)
                    .connections(connections)
                    .cableLength(cableLength)
                    .switchType(switchType)
                    .layout(layout)
                    .keyCount(keyCount)
                    .keycapMaterial(keycapMaterial)
                    .batteryType(batteryType)
                    .id(id)
                    .brand(brand)
                    .model(model)
                    .desc(desc)
                    .price(price)
                    .stockQty(stockQty)
                    .discountPercent(discountPercent)
                    .version(version)
                    .color(color)
                    .category(category)
                    .releaseYear(releaseYear)
                    .build();
            try {
                if(mechanicalKeyboardDTO.getId() == null)
                    id = prodService.save(mechanicalKeyboardDTO).getId();
                else
                    prodService.update(mechanicalKeyboardDTO);

                if(parts!= null)
                    prodImgIO.saveProductImages(id,realPath,parts);

                isSuccessful=true;

            }catch (Exception e){
                log.log(Level.SEVERE,e.getMessage());
            }
        } else if (category.equals(ECategory.MONITOR)) {
            double screenSize = Double.valueOf( req.getParameter("screenSize"));
            String resolution = req.getParameter("resolution");
            boolean touchScreen = Boolean.valueOf(req.getParameter("touchScreen")) ;
            Monitor.EPanel panelType = Monitor.EPanel.valueOf(req.getParameter("panelType")) ;
            int refreshRate = Integer.valueOf( req.getParameter("refreshRate"));
            boolean eyeCareTechnology = Boolean.valueOf( req.getParameter("eyeCareTechnology"));
            int brightness = Integer.valueOf(req.getParameter("brightness")) ;
            boolean hdrSupported = Boolean.valueOf( req.getParameter("hdrSupported"));
            boolean builtInSpeakers = Boolean.valueOf(req.getParameter("builtInSpeakers")) ;
            double powerConsumption = Double.valueOf(req.getParameter("powerConsumption")) ;
            double weight = Double.valueOf( req.getParameter("weight"));
            Set<Monitor.EConnection> connections = new HashSet<>();
            connections.add(Monitor.EConnection.valueOf(req.getParameter("connections")));
            MonitorDTO monitorDTO = monitorDTOBuilder
                    .screenSize(screenSize)
                    .resolution(resolution)
                    .touchScreen(touchScreen)
                    .panelType(panelType)
                    .refreshRate(refreshRate)
                    .eyeCareTechnology(eyeCareTechnology)
                    .brightness(brightness)
                    .hdrSupported(hdrSupported)
                    .builtInSpeakers(builtInSpeakers)
                    .powerConsumption(powerConsumption)
                    .weight(weight)
                    .connections(connections)
                    .id(id)
                    .brand(brand)
                    .model(model)
                    .desc(desc)
                    .price(price)
                    .stockQty(stockQty)
                    .discountPercent(discountPercent)
                    .version(version)
                    .color(color)
                    .category(category)
                    .releaseYear(releaseYear)
                    .build();
            try {
                if(monitorDTO.getId() == null)
                    id = prodService.save(monitorDTO).getId();
                else
                    prodService.update(monitorDTO);

                if(parts!= null)
                    prodImgIO.saveProductImages(id,realPath,parts);

                isSuccessful=true;

            }catch (Exception e){
                log.log(Level.SEVERE,e.getMessage());
            }
        }

        List<ProductDTO> prodDTOs = prodService.getProdsIsAvailable();
        prodDTOs.forEach(prod -> prod=prodImgIO.loadProdImageUrls(prod,realPath));
        req.setAttribute("prods", prodDTOs);
        req.setAttribute("isSuccessful",isSuccessful);
        req.getServletContext().getRequestDispatcher(url).forward(req, resp);
    }

    private static List<Part> resolvePartList(HttpServletRequest request, String name) throws ServletException, IOException {
        Collection<Part> parts = request.getParts();
        List<Part> result = new ArrayList<>(parts.size());
        for (Part part : parts) {
            if (part.getName().equals(name)) {
                result.add(part);
            }
        }
        return result;
    }
}
