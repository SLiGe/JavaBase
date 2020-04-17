package com.web.sparkjava;

import cn.hutool.core.io.FileUtil;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;
import spark.Spark;

import java.nio.charset.StandardCharsets;
import java.util.Collections;

/**
 * @author Gary
 * @since 2019/12/13 09:10
 */
public class SparkServer {

    public static void main(String[] args) {
        String content  = FileUtil.readString("C:\\Users\\Administrator\\Documents\\博客\\Docker\\Portainer监控Docker.md", StandardCharsets.UTF_8);
        String parse = parse(content);
        Spark.get("hello", (req, res) -> parse);

    }
    public static String parse(String content) {
        MutableDataSet options = new MutableDataSet();
        options.setFrom(ParserEmulationProfile.MARKDOWN); //enable table parse!
        options.set(Parser.EXTENSIONS, Collections.singletonList(TablesExtension.create()));
        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();
        Node document = parser.parse(content); return renderer.render(document);
    }
}
