package com.web.sparkjava;

import spark.Spark;

/**
 * @author Gary
 * @since 2019/12/13 09:10
 */
public class SparkServer {

    public static void main(String[] args) {
        Spark.get("hello", (req, res) -> "hello world");
    }

}
