package ru;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.Cfgs.AppConfig;
import ru.Factorys.HibernateFactory;
import ru.Models.Bucket;
import ru.Service.BucketService;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


public class App {
    private static BucketService bucketService;
    public static void main(String[] args) {
            ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
            HibernateFactory factory = context.getBean(HibernateFactory.class);
            try (Session session = factory.getSession()){
                String sql = Files.lines(Paths.get("InitTables.sql")).collect(Collectors.joining(" "));
                session.beginTransaction();
                session.createNativeQuery(sql).executeUpdate();
                session.getTransaction().commit();
            } catch (IOException e) {
                e.printStackTrace();
            }
        bucketService = context.getBean("BucketService", BucketService.class);
        showProductsByBuyer(1L);
        System.out.println("____________________");
        showProductsByBuyer(2L);
        System.out.println("____________________");
        showBuyerByProducts(3L);
        System.out.println("____________________");
        showBuyerByProducts(4L);
        System.out.println("____________________");

        }


    private static void showBuyerByProducts(Long id){
        List<Bucket> orders = bucketService.getOrdersByProduct(id);
        System.out.println("Product " + orders.get(0).getProduct().getName() + " buy:");
        for(Bucket o : orders){
            System.out.println(o.getBuyer().getNickName());
        }
    }


    private static void showProductsByBuyer(Long id){
        List<Bucket> orders = bucketService.getOrdersByBuyer(id);
        System.out.println("Buyer " + orders.get(0).getBuyer().getNickName() + " buy:");
        for(Bucket o : orders){
            System.out.println(o.getProduct().getName());
        }
    }


}