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

Besides, the authority management framework of the system has been set up, which uses Spring Security (OAuth2).

## To be done

Planning to use Seata to do the transaction management.

There still have many details need to be improved, we will do much test work for the backend and make performance optimization.