package com.webteam.laptopmall.listener;

import com.webteam.laptopmall.builder.entity.keyboard.KeyboardBuilder;
import com.webteam.laptopmall.builder.entity.keyboard.KeyboardBuilderImpl;
import com.webteam.laptopmall.builder.entity.laptop.LaptopBuilder;
import com.webteam.laptopmall.builder.entity.laptop.LaptopBuilderImpl;
import com.webteam.laptopmall.builder.entity.monitor.MonitorBuilder;
import com.webteam.laptopmall.builder.entity.monitor.MonitorBuilderImpl;
import com.webteam.laptopmall.customenum.ECategory;
import com.webteam.laptopmall.customenum.EGender;
import com.webteam.laptopmall.entity.CartItem;
import com.webteam.laptopmall.entity.prod.Laptop;
import com.webteam.laptopmall.entity.prod.MechanicalKeyboard;
import com.webteam.laptopmall.entity.prod.Monitor;
import com.webteam.laptopmall.entity.prod.Product;
import com.webteam.laptopmall.entity.user.User;
import com.webteam.laptopmall.repository.cartitem.CartItemRepos;
import com.webteam.laptopmall.repository.cartitem.CartItemReposImpl;
import com.webteam.laptopmall.repository.prod.ProdRepos;
import com.webteam.laptopmall.repository.prod.ProdReposImpl;
import com.webteam.laptopmall.repository.user.UserRepos;
import com.webteam.laptopmall.repository.user.UserReposImpl;
import com.webteam.laptopmall.service.login.LoginService;
import com.webteam.laptopmall.service.login.LoginServiceImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebListener
public class InitializingData  implements ServletContextListener {
    private CartItemRepos cartItemRepos;
    private ProdRepos prodRepos;
    private UserRepos userRepos;
    private LoginService loginService;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        init();

        deleteAll();

        List<User> savedUsers =  initUser();
        List<Product> savedProducts =  initProduct();
        List<CartItem> savedCartItems =  initCartItem(savedUsers, savedProducts);
    }

    private void init() {
        cartItemRepos = new CartItemReposImpl();
        prodRepos = new ProdReposImpl();
        userRepos = new UserReposImpl();
        loginService = new LoginServiceImpl();
    }

    private void deleteAll() {
        int deleteCartItems = cartItemRepos.deleteAll();
        int deleteProds = prodRepos.deleteAll();
        int deleteUsers = userRepos.deleteAll();
    }

    private List<CartItem> initCartItem(List<User> savedUsers, List<Product> savedProducts) {

        User customer = userRepos.getUserByUsername( savedUsers.get(0).getUsername() );
        CartItem cartItem = new CartItem(4, customer, savedProducts.get(0));
        CartItem cartItem2 = new CartItem(2, customer, savedProducts.get(1));
        CartItem cartItem3 = new CartItem(1, customer, savedProducts.get(2));


        User customer2 = userRepos.getUserByUsername( savedUsers.get(1).getUsername() );
        CartItem cartItem4 = new CartItem(2, customer2, savedProducts.get(3));
        CartItem cartItem5 = new CartItem(8, customer2, savedProducts.get(4));
        CartItem cartItem6 = new CartItem(4, customer2, savedProducts.get(5));

        List<CartItem> cartItems = new ArrayList<>();
        cartItems.add(cartItem);
        cartItems.add(cartItem2);
        cartItems.add(cartItem3);
        cartItems.add(cartItem4);
        cartItems.add(cartItem5);
        cartItems.add(cartItem6);

        List<CartItem> savedCartItems = new ArrayList<>();
        cartItems.forEach(ci -> {
            CartItem savedCartItem = cartItemRepos.save(ci);
            savedCartItems.add(savedCartItem);
        });

        return savedCartItems;
    }

    private List<Product> initProduct() {
        List<Product> prods = new ArrayList<>();
        prods.addAll(buildLaptops());
        prods.addAll(buildKeyboards());
        prods.addAll(buildMonitors());

        List<Product> savedProds = new ArrayList<>();
        prods.forEach(p -> {
            Product saveProd = prodRepos.save(p);
            savedProds.add(saveProd);
        });
        return savedProds;
    }

    private List<Laptop> buildLaptops() {
        LaptopBuilder builder = new LaptopBuilderImpl();

        List<Laptop> laptops = new ArrayList<>();

        Laptop laptop1 =  builder
                .cpuName("Intel Core i5")
                .cpuCores(4)
                .cpuThreads(8)
                .cpuSpeed(2.5)
                .cpuMaxSpeed(4.0)
                .cpuCache(8)
                .ramSize(16)
                .ramType(Laptop.ERam.DDR4)
                .ramBusSpeed(3200)
                .ramMaxSupport(32)
                .romType(Laptop.ERom.SSD)
                .romSize(512)
                .screenSize(15.6)
                .screenResolution("1920 x 1080")
                .screenRefreshRate(60)
                .screenTechnology("LED")
                .brightness(250)
                .antiGlare(true)
                .graphicsCard("Nvidia GeForce GTX 1650")
                .weight(2.3)
                .material("Aluminum")
                .operatingSystem(Laptop.EOS.WINDOWS)
                .brand("HP")
                .model("Pavilion")
                .desc("Powerful and stylish laptop for everyday use")
                .price(new BigDecimal("799.99"))
                .stockQty(50)
                .discountPercent(10.0)
                .version("1.0")
                .color("Silver")
                .category(ECategory.LAPTOP)
                .releaseYear(2022)
                .build();
        Laptop laptop2 =  builder
                .cpuName("Intel Core i7")
                .cpuCores(4)
                .cpuThreads(8)
                .cpuSpeed(2.5)
                .cpuMaxSpeed(4.0)
                .cpuCache(8)
                .ramSize(16)
                .ramType(Laptop.ERam.DDR3)
                .ramBusSpeed(3200)
                .ramMaxSupport(32)
                .romType(Laptop.ERom.SSD)
                .romSize(512)
                .screenSize(15.6)
                .screenResolution("1920 x 1080")
                .screenRefreshRate(60)
                .screenTechnology("LED")
                .brightness(250)
                .antiGlare(true)
                .graphicsCard("Nvidia GeForce GTX 1650")
                .weight(2.3)
                .material("Aluminum")
                .operatingSystem(Laptop.EOS.LINUX)
                .brand("Dell")
                .model("Pavilion")
                .desc("Powerful and stylish laptop for everyday use")
                .price(new BigDecimal("799.99"))
                .stockQty(50)
                .discountPercent(10.0)
                .version("1.0")
                .color("Silver")
                .category(ECategory.LAPTOP)
                .releaseYear(2022)
                .build();

        laptops.add(laptop1);
        laptops.add(laptop2);

        return laptops;
    }

    private List<MechanicalKeyboard> buildKeyboards() {
        Set<Laptop.EOS> compatibilities = new HashSet<>();
        compatibilities.add(Laptop.EOS.WINDOWS);
        compatibilities.add(Laptop.EOS.MAC);
        compatibilities.add(Laptop.EOS.LINUX);

        Set<MechanicalKeyboard.EConnection> connections = new HashSet<>();
        connections.add(MechanicalKeyboard.EConnection.USB_RECEIVER);
        connections.add(MechanicalKeyboard.EConnection.BLUETOOTH);
        connections.add(MechanicalKeyboard.EConnection.WIRED);

        KeyboardBuilder builder = new KeyboardBuilderImpl();

        List<MechanicalKeyboard> mechanicalKeyboards = new ArrayList<>();

        MechanicalKeyboard mechanicalKeyboard1 = builder
                .compatibilities(compatibilities)
                .connections(connections)
                .cableLength("1.8m")
                .switchType("Cherry MX Red")
                .layout(MechanicalKeyboard.ELayout.FULL_SIZE)
                .keyCount(104)
                .keycapMaterial("ABS")
                .batteryType("AA")
                .brand("BrandName")
                .model("Model123")
                .desc("Description of the keyboard")
                .price(new BigDecimal("99.99"))
                .stockQty(50)
                .discountPercent(0.05)
                .version("Version2")
                .color("Black")
                .category(ECategory.MECHANICAL_KEYBOARD)
                .releaseYear(2023)
                .build();


        MechanicalKeyboard mechanicalKeyboard2 = builder
                .compatibilities(compatibilities)
                .connections(connections)
                .cableLength("1.8m")
                .switchType("Cherry MX Red")
                .layout(MechanicalKeyboard.ELayout.FULL_SIZE)
                .keyCount(104)
                .keycapMaterial("ABS")
                .batteryType("AA")
                .brand("BrandName")
                .model("Model123")
                .desc("Description of the keyboard")
                .price(new BigDecimal("99.99"))
                .stockQty(50)
                .discountPercent(0.05)
                .version("Version2")
                .color("White")
                .category(ECategory.MECHANICAL_KEYBOARD)
                .releaseYear(2023)
                .build();

        mechanicalKeyboards.add(mechanicalKeyboard1);
        mechanicalKeyboards.add(mechanicalKeyboard2);

        return mechanicalKeyboards;
    }

    private List<Monitor> buildMonitors() {
        Set<Monitor.EConnection> connections = new HashSet<>();
        connections.add(Monitor.EConnection.HDMI);
        connections.add(Monitor.EConnection.USB_C);

        MonitorBuilder builder = new MonitorBuilderImpl();

        List<Monitor> monitors = new ArrayList<>();

        Monitor monitor1 = builder
                .screenSize(27.0)
                .resolution("1920x1080")
                .touchScreen(true)
                .panelType(Monitor.EPanel.IPS)
                .refreshRate(144)
                .eyeCareTechnology(true)
                .brightness(250)
                .hdrSupported(true)
                .builtInSpeakers(true)
                .powerConsumption(50.5)
                .weight(7.2)
                .connections(connections)
                .brand("BrandName")
                .model("Model123")
                .desc("Description of the monitor")
                .price(new BigDecimal("299.99"))
                .stockQty(50)
                .discountPercent(0.1)
                .version("Version2")
                .color("Black")
                .category(ECategory.MONITOR)
                .releaseYear(2023)
                .build();

        Monitor monitor2 = builder
                .screenSize(27.0)
                .resolution("1920x1080")
                .touchScreen(true)
                .panelType(Monitor.EPanel.IPS)
                .refreshRate(144)
                .eyeCareTechnology(true)
                .brightness(250)
                .hdrSupported(true)
                .builtInSpeakers(true)
                .powerConsumption(50.5)
                .weight(7.2)
                .connections(connections)
                .brand("BrandName")
                .model("Model123")
                .desc("Description of the monitor")
                .price(new BigDecimal("299.99"))
                .stockQty(50)
                .discountPercent(0.1)
                .version("Version3")
                .color("Black")
                .category(ECategory.MONITOR)
                .releaseYear(2023)
                .build();

        monitors.add(monitor1);
        monitors.add(monitor2);

        return monitors;
    }

    private List<User> initUser() {
        List<User> users = new ArrayList<>();

        final String hashedPass =  loginService.hashPass("123456");
        User user1 = new User("HCM", "nguyenvana0606@gmail.com", "Nguyễn Văn A",
                EGender.MALE, "0123456789", "vana0505", hashedPass, User.ERole.CUSTOMER);
        User user2 = new User("Hà Nội", "nguyenvanb0505@gmail.com", "Lê Hoàng Giang",
                EGender.MALE, "0123456788", "vanb0606", hashedPass, User.ERole.CUSTOMER);
        User user3 = new User("Đà Nẵng", "nguyenvanc0707@gmail.com", "Hà Hồ",
                EGender.FEMALE, "0123456787", "vanc0707", hashedPass, User.ERole.CUSTOMER);
        User user4 = new User("Quảng Ninh", "nguyenvand0808@gmail.com", "Nguyễn Trường An",
                EGender.MALE, "0123456786", "vand0808", hashedPass, User.ERole.SALESPERSON);
        User user5 = new User("Cần Thơ", "nguyenvan0909e@gmail.com", "Trần Văn An",
                EGender.MALE, "0123456785", "vane0909", hashedPass, User.ERole.SALESPERSON);

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        List<User> savesUsers = new ArrayList<>();
        users.forEach(u -> {
            User savedUser = userRepos.save(u);
            savesUsers.add(savedUser);
        });

        return savesUsers;
    }
}
