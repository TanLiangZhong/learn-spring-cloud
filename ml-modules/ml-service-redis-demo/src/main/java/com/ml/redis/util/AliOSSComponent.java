package com.ml.redis.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import com.aliyun.oss.model.Bucket;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * @author liangzhong
 * @date 2019/2/27 09:54
 */
@Component
public class AliOSSComponent {

//    @Value("${oss.endpoint}")
//    private  String endpoint;
//
//    @Value("${oss.accessKeyId}")
//    private  String accessKeyId;
//
//    @Value("${oss.accessKeySecret}")
//    private  String accessKeySecret;
//
//    @Value("${oss.bucketName}")
//    private  String bucketName;

    private String endpoint = "http://oss-cn-shanghai.aliyuncs.com";

    private String accessKeyId = "LTAIQdxIsWg3KdVx";

    private String accessKeySecret = "U65yd7ttUraV07dofiBkY3aKKHB8Ko";

    private String bucketName = "ml-20190227";

    /**
     * 创建OSSClient实例
     *
     * @return
     * @author liangzhong
     * @date 2019-02-27
     */
    private OSSClient createOSSClient() {
        return new OSSClient(endpoint, new DefaultCredentialProvider(accessKeyId, accessKeySecret), null);
    }

    /**
     * 创建储空间
     *
     * @param bucketName 储空间名称
     * @author liangzhong
     * @date 2019-02-27
     */
    public void createBucket(String bucketName) {
        OSSClient ossClient = createOSSClient();
        // 创建存储空间
        ossClient.createBucket(bucketName);
        // 关闭OSSClient
        ossClient.shutdown();
    }

    /**
     * 删除储空间
     *
     * @param bucketName 储空间名称
     * @author liangzhong
     * @date 2019-02-27
     */
    public void deleteBucket(String bucketName) {
        OSSClient ossClient = createOSSClient();
        // 创建存储空间
        ossClient.deleteBucket(bucketName);
        // 关闭OSSClient
        ossClient.shutdown();
    }

    /**
     * 列举存储空间
     *
     * @author liangzhong
     * @date 2019-02-27
     */
    public List<Bucket> listBuckets() {
        OSSClient ossClient = createOSSClient();
        // 创建存储空间
        List<Bucket> buckets = ossClient.listBuckets();
        // 关闭OSSClient
        ossClient.shutdown();
        return buckets;
    }

    public void upload(String bucketName, String objectName, byte[] content) {
        OSSClient ossClient = createOSSClient();
        ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(content));
    }

    public void upload(String bucketName, String objectName, InputStream inputStream) {
        OSSClient ossClient = createOSSClient();
        ossClient.putObject(bucketName, objectName, inputStream);
    }


    public static void main(String[] args) {
        AliOSSComponent oss = new AliOSSComponent();
        oss.upload(oss.bucketName, "ml/hello", "sokka".getBytes());
    }

    public String fmtAccessUrl(String path) {
        return "https://" + bucketName + ".oss-cn-shanghai.aliyuncs.com/" + path;
    }

}
