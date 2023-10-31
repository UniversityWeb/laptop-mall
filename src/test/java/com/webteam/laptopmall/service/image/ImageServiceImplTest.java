package com.webteam.laptopmall.service.image;

import com.webteam.laptopmall.builder.dto.keyboard.KeyboardDTOBuilder;
import com.webteam.laptopmall.builder.dto.keyboard.KeyboardDTOBuilderImpl;
import com.webteam.laptopmall.dto.prod.MechanicalKeyboardDTO;
import com.webteam.laptopmall.dto.prod.ProductDTO;
import com.webteam.laptopmall.entity.prod.Laptop;
import com.webteam.laptopmall.entity.prod.MechanicalKeyboard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ImageServiceImplTest {

    private ImageService imgService;

    @BeforeEach
    void setup() {
        imgService = new ImageServiceImpl();
    }

    @Test
    public void testLoadProdImageUrls_Success() {
        final List<String> expectedImgUrls = new ArrayList<>();
        expectedImgUrls.add("");
        expectedImgUrls.add("");
        expectedImgUrls.add("");

        ProductDTO prod = keyboardDTOBuilder();

        // Mock the ServletContext to provide a fake real path
        ServletContext mockServletContext = Mockito.mock(ServletContext.class);
        String fakeRealPath = "/WEB-INF/app/prod";  // Replace with your actual fake path
        Mockito.when(mockServletContext.getRealPath("/")).thenReturn(fakeRealPath);

        // Mock the HttpServletRequest to provide the ServletContext
        HttpServletRequest mockRequest = Mockito.mock(HttpServletRequest.class);
        Mockito.when(mockRequest.getServletContext()).thenReturn(mockServletContext);

        // Set the HttpServletRequest in a session to simulate a session context
        HttpSession mockSession = Mockito.mock(HttpSession.class);
        Mockito.when(mockSession.getServletContext()).thenReturn(mockServletContext);
        Mockito.when(mockRequest.getSession()).thenReturn(mockSession);

        String realPath = getRealPath(mockRequest);

        prod = imgService.loadProdImageUrls(prod, realPath);

        for (int i = 0; i < expectedImgUrls.size(); i++) {
            assertEquals(prod.getImageUrls().get(i), expectedImgUrls.get(i));
        }
    }

    public String getRealPath(HttpServletRequest request) {
        return request.getServletContext().getRealPath("/");
    }

    private MechanicalKeyboardDTO keyboardDTOBuilder() {
        Set<Laptop.EOS> compatibilities = new HashSet<>();
        compatibilities.add(Laptop.EOS.WINDOWS);
        compatibilities.add(Laptop.EOS.MAC);
        compatibilities.add(Laptop.EOS.LINUX);

        Set<MechanicalKeyboard.EConnection> connections = new HashSet<>();
        connections.add(MechanicalKeyboard.EConnection.USB_RECEIVER);
        connections.add(MechanicalKeyboard.EConnection.BLUETOOTH);
        connections.add(MechanicalKeyboard.EConnection.WIRED);

        KeyboardDTOBuilder builder = new KeyboardDTOBuilderImpl();
        return builder
                .compatibilities(compatibilities)
                .connections(connections)
                .cableLength("1.8m")
                .switchType("Cherry MX Red")
                .layout(MechanicalKeyboard.ELayout.FULL_SIZE)
                .keyCount(104)
                .keycapMaterial("ABS")
                .batteryType("AA")
                .id(1L)
                .brand("BrandName")
                .model("Model123")
                .desc("Description of the keyboard")
                .price(new BigDecimal("99.99"))
                .stockQty(50)
                .version("Version2")
                .color("Black")
                .build();
    }

}