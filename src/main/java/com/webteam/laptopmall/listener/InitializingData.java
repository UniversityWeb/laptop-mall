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
import com.webteam.laptopmall.entity.ChatMessage;
import com.webteam.laptopmall.entity.prod.Laptop;
import com.webteam.laptopmall.entity.prod.MechanicalKeyboard;
import com.webteam.laptopmall.entity.prod.Monitor;
import com.webteam.laptopmall.entity.prod.Product;
import com.webteam.laptopmall.entity.user.User;
import com.webteam.laptopmall.repository.cartitem.CartItemRepos;
import com.webteam.laptopmall.repository.cartitem.CartItemReposImpl;
import com.webteam.laptopmall.repository.chatmessage.MessageRepos;
import com.webteam.laptopmall.repository.chatmessage.MessageReposImpl;
import com.webteam.laptopmall.repository.prod.ProdRepos;
import com.webteam.laptopmall.repository.prod.ProdReposImpl;
import com.webteam.laptopmall.repository.user.UserRepos;
import com.webteam.laptopmall.repository.user.UserReposImpl;
import com.webteam.laptopmall.utility.PassUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebListener
public class InitializingData  implements ServletContextListener {
    private CartItemRepos cartItemRepos;
    private ProdRepos prodRepos;
    private UserRepos userRepos;
    private MessageRepos msgRepos;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        init();

        deleteAll();

        List<User> users =  initUser();
        List<Product> savedProducts =  initProduct();
        List<CartItem> savedCartItems =  initCartItem(users, savedProducts);
        List<ChatMessage> savedChatMessages = initChatMessage(users.get(0).getUsername(),
                users.get(1).getUsername(), users.get(users.size() - 1).getUsername());
    }

    private void init() {
        cartItemRepos = new CartItemReposImpl();
        prodRepos = new ProdReposImpl();
        userRepos = new UserReposImpl();
        msgRepos = new MessageReposImpl();
    }

    private void deleteAll() {
        int deletedCartItems = cartItemRepos.deleteAll();
        int deletedProds = prodRepos.deleteAll();
        int deletedChatMessages = msgRepos.deleteAll();
    }

    private List<ChatMessage> initChatMessage(String customerUsername1,
                                              String customerUsername2,
                                              String salespersonUsername) {

        List<ChatMessage> chatMessages = new ArrayList<>();

        User customer1 = userRepos.getUserByUsername(customerUsername1);
        User customer2 = userRepos.getUserByUsername(customerUsername2);
        User salesperson = userRepos.getUserByUsername(salespersonUsername);

        chatMessages.add(new ChatMessage("Chào Shop", ChatMessage.EType.TEXT, Timestamp.from(Instant.now()),
                customer1, salesperson));
        chatMessages.add(new ChatMessage("Laptop này còn không ạ!", ChatMessage.EType.TEXT, Timestamp.from(Instant.now()),
                customer1, salesperson));
        chatMessages.add(new ChatMessage("Không còn bạn nhé :vV", ChatMessage.EType.TEXT, Timestamp.from(Instant.now()),
                salesperson, customer1));
        chatMessages.add(new ChatMessage(customer1.getUsername() + " close chat.", ChatMessage.EType.NOTIFICATION, Timestamp.from(Instant.now()),
                customer2, salesperson));


        chatMessages.add(new ChatMessage("Chào Shop", ChatMessage.EType.TEXT, Timestamp.from(Instant.now()),
                customer2, salesperson));
        chatMessages.add(new ChatMessage("Màn hình này còn không ạ!", ChatMessage.EType.TEXT, Timestamp.from(Instant.now()),
                customer2, salesperson));
        chatMessages.add(new ChatMessage("Còn bạn nhé", ChatMessage.EType.TEXT, Timestamp.from(Instant.now()),
                salesperson, customer2));
        chatMessages.add(new ChatMessage("Ok, e cảm ơn", ChatMessage.EType.TEXT, Timestamp.from(Instant.now()),
                customer2, salesperson));
        chatMessages.add(new ChatMessage(customer2.getUsername() + " close chat.", ChatMessage.EType.NOTIFICATION, Timestamp.from(Instant.now()),
                customer2, salesperson));

        List<ChatMessage> savedChatMessages = new ArrayList<>();
        chatMessages.forEach(cm -> {
            ChatMessage saved = msgRepos.save(cm);
            savedChatMessages.add(saved);
        });

        return savedChatMessages;
    }

    private List<CartItem> initCartItem(List<User> users, List<Product> savedProducts) {

        User customer = userRepos.getUserByUsername( users.get(0).getUsername() );
        CartItem cartItem = new CartItem(4, customer, savedProducts.get(0));
        CartItem cartItem2 = new CartItem(2, customer, savedProducts.get(1));
        CartItem cartItem3 = new CartItem(1, customer, savedProducts.get(2));


        User customer2 = userRepos.getUserByUsername( users.get(1).getUsername() );
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
                .model("Laptop HP 15s fq5162TU i5")
                .desc("Powerful and stylish laptop for everyday use")
                .price(new BigDecimal("99500000.00"))
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
                .model("Laptop Dell Inspiron 15 3530 i7")
                .desc("Powerful and stylish laptop for everyday use")
                .price(new BigDecimal("29950000.00"))
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
                .model("mechanical keyboard 68 keys customized RGB")
                .desc("Description of the keyboard")
                .price(new BigDecimal("2555000.00"))
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
                .model("Mini Gaming Keyboard RGB Backlit Red Switch")
                .desc("Description of the keyboard")
                .price(new BigDecimal("1200000.00"))
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
                .brand("LG")
                .model("27\" IPS FHD Monitor")
                .desc("Description of the monitor")
                .price(new BigDecimal("10500000.00"))
                .stockQty(50)
                .discountPercent(0.1)
                .version("Version2")
                .color("Black")
                .category(ECategory.MONITOR)
                .releaseYear(2023)
                .build();

        Monitor monitor2 = builder
                .screenSize(24.0)
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
                .brand("LG")
                .model("24\" IPS FHD Monitor")
                .desc("Description of the monitor")
                .price(new BigDecimal("6500000.00"))
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

        final String hashedPass =  PassUtil.hashPass("123456");
        User user1 = new User("HCM", "nguyenhaquynhgiao9569@gmail.com", "Nguyễn Văn A",
                EGender.MALE, "0123456789", "vana0505", hashedPass, User.ERole.CUSTOMER);
        User user2 = new User("Hà Nội", "nguyenvanb0505@gmail.com", "Lê Hoàng Giang",
                EGender.MALE, "0123456788", "vanb0606", hashedPass, User.ERole.CUSTOMER);
        User user3 = new User("Đà Nẵng", "nguyenvanc0707@gmail.com", "Hà Hồ",
                EGender.FEMALE, "0123456787", "vanc0707", hashedPass, User.ERole.CUSTOMER);
        User user4 = new User("Quảng Ninh", "nguyenvand0808@gmail.com", "Nguyễn Trường An",
                EGender.MALE, "0123456786", "vand0808", hashedPass, User.ERole.SALESPERSON);
        User user5 = new User("Cần Thơ", "nguyenvan0909e@gmail.com", "Trần Văn An",
                EGender.MALE, "0123456785", "vanannek", hashedPass, User.ERole.SALESPERSON);

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        users.forEach(u -> {
            userRepos.save(u);
        });

        return users;
    }
}
