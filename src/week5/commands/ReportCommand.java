package org.example.commands;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.example.Catalog;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class ReportCommand extends Command {
    private Catalog catalog;
    public ReportCommand(Catalog catalog){
        this.catalog = catalog;
    }
    @Override
    public void execute() {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);
        cfg.setClassForTemplateLoading(ReportCommand.class, "/templates");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        try {
            Template template = cfg.getTemplate("report.ftl");
            Map<String, Object> input = new HashMap<>();
            input.put("name", catalog.getName());
            input.put("documents", catalog.getDocuments());
            String path = System.getProperty("user.dir") + "/src/main/java/org/example/report.html";
            Writer out = new FileWriter(new File(path));
            template.process(input, out);
            out.close();
            Desktop.getDesktop().open(new File(path));
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

}
