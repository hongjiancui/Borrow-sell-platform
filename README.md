# Everest
The backend repository for Cross-border e-commerce borrow-sell platform.
![](https://pic-cui-0622.oss-cn-beijing.aliyuncs.com/img/20200711010703.png)

## Have done

Backend uses SpringCloud Alibaba (Nacos, Sentinel) to build this distributed microservice platform. The database connection pool uses Druid, file system uses Aliyun OSS to store the image file.

The platform currently contains **eight microservices**:
- **bsp-gateway**: Using SpringCloud Gateway for routing and load balancing
- **bsp-user**: The microservice for login and register
- **bsp-product**: The microservice for maintaining the product information of BVO & MVO
- **bsp-order**: The microservice for managing the order
- **bsp-information**: The microservice for Maintenance information of brand, company and store
- **bsp-wallet**: The microservice for wallet
- **bsp-admin**: The microservice for admin
- **bsp-oauth**: Provide authorization service

Besides, the authority management framework of the system has been set up, which uses Spring Security (OAuth2).

Using redis as the 2-level of mybatis cache.

Using aop to do the global exception handling and request/response logging intercepting.

Have done all the tests of backend services.

Using docker to deploy the backend services.

## To be done

Dealing with some details about the business logic, making the performance of this system better.