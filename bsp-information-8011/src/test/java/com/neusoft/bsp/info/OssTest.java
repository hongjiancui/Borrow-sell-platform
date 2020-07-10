package com.neusoft.bsp.info;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.InputStream;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OssTest {
    @Resource
    OSSClient ossClient;

    @Test
    public void upload() throws Exception {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
//        String endpoint = "oss-cn-beijing.aliyuncs.com";
//        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
//        String accessKeyId = "LTAI4G9uRgbSYBXcjSuzYvbU";
//        String accessKeySecret = "DzjY8om6SHKXLbw0pD7PRpdUZELzwW";
//
//        // 创建OSSClient实例。
//        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 上传文件流。
        InputStream inputStream = new FileInputStream("C:\\Users\\Cui\\Pictures\\Saved Pictures\\avator.jpg");
        ossClient.putObject("pic-cui-0622", "company/avator.jpg", inputStream);

        // 关闭OSSClient。
        ossClient.shutdown();
        System.out.println("上传完成");
    }
}
