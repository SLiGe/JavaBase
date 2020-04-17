package com.java.docker;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Info;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.core.SSLConfig;

import java.io.IOException;

/**
 * @author zJiaLi
 * @since 2020-04-03 22:02
 */
public class DockerInfo {

    public static void main(String[] args) throws IOException {
        DockerClientConfig dockerClientConfig = DefaultDockerClientConfig.createDefaultConfigBuilder().withDockerTlsVerify(true)
                .withDockerCertPath("C:\\Users\\Administrator\\Desktop\\docker\\136").withDockerHost("tcp://1.1.1.1:2376").build();
        DockerClient dockerClient = DockerClientBuilder.getInstance(dockerClientConfig).build();
        Info exec = dockerClient.infoCmd().exec();
        System.out.println(exec);
        dockerClient.close();
    }
}
