package org.gowtham.fullstackecommercebackend.Services;

import jakarta.annotation.PostConstruct;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.gowtham.fullstackecommercebackend.Model.*;
import org.gowtham.fullstackecommercebackend.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvLoaderService {

    @Autowired private UserRepo userRepository;
    @Autowired private ProductRepo productRepository;
    @Autowired private OrdersRepo ordersRepo;
    @Autowired private OrderItemsRepo orderItemsRepo;
    @Autowired private InventoryItemRepo inventoryItemRepo;
    @Autowired private DistributionCenterRepo distributionCenterRepo;

    private static final DateTimeFormatter DATETIME_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSXXXXX");


    private OffsetDateTime parseDateTime(String value) {
        if (value == null || value.isBlank()) return null;

        try {
            DateTimeFormatter formatterWithMicros =
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSXXXXX");
            return OffsetDateTime.parse(value, formatterWithMicros);
        } catch (Exception ignored) {
        }

        try {
            DateTimeFormatter fallbackFormatter =
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssXXXXX");
            return OffsetDateTime.parse(value, fallbackFormatter);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse date: " + value, e);
        }
    }


    @PostConstruct
    public void init() throws Exception {
        loadUsers("data/users.csv");
        loadProducts("data/products.csv");
        loadOrders("data/orders.csv");
        loadOrderItems("data/order_items.csv");
        loadInventoryItems("data/inventory_items.csv");
        loadDistributionCenters("data/distribution_centers.csv");
    }

    private void loadUsers(String path) throws Exception {
        List<Users> users = new ArrayList<>();
        try (CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().withTrim()
                .parse(new InputStreamReader(new ClassPathResource(path).getInputStream()))) {

            for (CSVRecord record : parser) {
                Users user = new Users();
                user.setFirstName(record.get("first_name"));
                user.setLastName(record.get("last_name"));
                user.setEmail(record.get("email"));
                user.setAge(Integer.parseInt(record.get("age")));
                user.setGender(record.get("gender"));
                user.setState(record.get("state"));
                user.setStreetAddress(record.get("street_address"));
                user.setPostalCode(record.get("postal_code"));
                user.setCity(record.get("city"));
                user.setCountry(record.get("country"));
                user.setLatitude(record.get("latitude"));
                user.setLongitude(record.get("longitude"));
                user.setTrafficSource(record.get("traffic_source"));
                users.add(user);
            }
            userRepository.saveAll(users);
        }
    }

    private void loadProducts(String path) throws Exception {
        List<Products> products = new ArrayList<>();
        try (CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().withTrim()
                .parse(new InputStreamReader(new ClassPathResource(path).getInputStream()))) {

            for (CSVRecord record : parser) {
                Products product = new Products();
                product.setCost(record.get("cost"));
                product.setCategory(record.get("category"));
                product.setName(record.get("name"));
                product.setBrand(record.get("brand"));
                product.setRetailPrice(record.get("retail_price"));
                product.setDepartment(record.get("department"));
                product.setSku(record.get("sku"));
                product.setDistributionCenterId(record.get("distribution_center_id"));
                products.add(product);
            }
            productRepository.saveAll(products);
        }
    }

    private void loadOrders(String path) throws Exception {
        List<Orders> orders = new ArrayList<>();
        try (CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().withTrim()
                .parse(new InputStreamReader(new ClassPathResource(path).getInputStream()))) {

            for (CSVRecord record : parser) {
                Orders order = new Orders();
                order.setUserId(Long.parseLong(record.get("user_id")));
                order.setStatus(record.get("status"));
                order.setGender(record.get("gender"));
                order.setCreatedAt(parseDateTime(record.get("created_at")));
                order.setShippedAt(parseDateTime(record.get("shipped_at")));
                order.setDeliveredAt(parseDateTime(record.get("delivered_at")));
                order.setNumberOfItem(Integer.parseInt(record.get("num_of_item")));
                orders.add(order);
            }
            ordersRepo.saveAll(orders);
        }
    }

    private void loadOrderItems(String path) throws Exception {
        List<OrderItems> items = new ArrayList<>();
        try (CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().withTrim()
                .parse(new InputStreamReader(new ClassPathResource(path).getInputStream()))) {

            for (CSVRecord record : parser) {
                OrderItems item = new OrderItems();
                item.setOrderId(Long.parseLong(record.get("order_id")));
                item.setUserId(Long.parseLong(record.get("user_id")));
                item.setProductId(Long.parseLong(record.get("product_id")));
                item.setInventoryItemId(Long.parseLong(record.get("inventory_item_id")));
                item.setStatus(record.get("status"));
                item.setCreatedAt(parseDateTime(record.get("created_at")));
                item.setShippedAt(parseDateTime(record.get("shipped_at")));
                item.setDeliveredAt(parseDateTime(record.get("delivered_at")));
                item.setReturnedAt(parseDateTime(record.get("returned_at")));
                item.setSalePrice(new BigDecimal(record.get("sale_price")));
                items.add(item);
            }
            orderItemsRepo.saveAll(items);
        }
    }

    private void loadInventoryItems(String path) throws Exception {
        List<InventoryItem> items = new ArrayList<>();
        try (CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().withTrim()
                .parse(new InputStreamReader(new ClassPathResource(path).getInputStream()))) {

            for (CSVRecord record : parser) {
                InventoryItem item = new InventoryItem();
                item.setProductId(Long.parseLong(record.get("product_id")));
                item.setCreatedAt(parseDateTime(record.get("created_at")));
                item.setSoldAt(parseDateTime(record.get("sold_at")));
                item.setCost(new BigDecimal(record.get("cost")));
                item.setProductCategory(record.get("product_category"));
                item.setProductName(record.get("product_name"));
                item.setProductBrand(record.get("product_brand"));
                item.setProductRetailPrice(new BigDecimal(record.get("product_retail_price")));
                item.setProductDepartment(record.get("product_department"));
                item.setProductSku(record.get("product_sku"));
                item.setProductDistributionCenterId(Integer.parseInt(record.get("product_distribution_center_id")));
                items.add(item);
            }
            inventoryItemRepo.saveAll(items);
        }
    }

    private void loadDistributionCenters(String path) throws Exception {
        List<DistributionCenters> centers = new ArrayList<>();
        try (CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().withTrim()
                .parse(new InputStreamReader(new ClassPathResource(path).getInputStream()))) {

            for (CSVRecord record : parser) {
                DistributionCenters center = new DistributionCenters();
                center.setName(record.get("name"));
                center.setLatitude(record.get("latitude"));
                center.setLongitude(record.get("longitude"));
                centers.add(center);
            }
            distributionCenterRepo.saveAll(centers);
        }
    }
}
