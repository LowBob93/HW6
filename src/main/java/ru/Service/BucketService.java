package ru.Service;

import org.springframework.stereotype.Service;
import ru.DaoClasses.BucketDao;
import ru.DaoClasses.BuyerDao;
import ru.DaoClasses.ProductDao;
import ru.Models.Bucket;

import java.util.List;

@Service
public class BucketService {
        private BucketDao bucketDao;
        private BuyerDao buyerDao;
        private ProductDao productDao;

        public BucketService(BucketDao bucketDao, BuyerDao buyerDao, ProductDao productDao) {
            this.bucketDao = bucketDao;
            this.buyerDao = buyerDao;
            this.productDao = productDao;
        }

        public List<Bucket> getOrdersByBuyer(Long id){
            return bucketDao.getBuyerBucket(id);
        }

        public List<Bucket> getOrdersByProduct(Long id){
            return bucketDao.getBucketByProduct(id);
        }
    }
