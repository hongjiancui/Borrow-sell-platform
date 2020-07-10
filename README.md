# Everest
The backend repository for Cross-border e-commerce borrow-sell platform.
![](https://pic-cui-0622.oss-cn-beijing.aliyuncs.com/img/20200711010703.png)

Backend uses SpringCloud Alibaba (Nacos, Sentinel) to build this distributed microservice platform. The database connection pool uses Druid, file system uses Aliyun OSS to store the image file.

The platform currently contains **seven microservices**:
- **bsp-gateway**: Using SpringCloud Gateway for routing and load balancing
- **bsp-user**: The microservice for login and register
- **bsp-product**: The microservice for maintaining the product information of BVO & MVO
- **bsp-order**: The microservice for managing the order
- **bsp-information**: The microservice for Maintenance information of brand, company and store
- **bsp-wallet**: The microservice for wallet
- **bsp-admin**: The microservice for admin

## To be done

The next step is to build a platform authority management framework, ready to use Shiro to complete this work. Also plan to use Seata for transaction management.

However, there still have many details need to be improved, so, we will do much more test work for the backend and make the performance optimization.