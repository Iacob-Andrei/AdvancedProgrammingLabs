package commands;

import client.ClientState;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateHTMLCommand implements ExecuteCommand{

    /**
     * using a template located in resources/template/template.ftl
     * creates an HTML document containing the social network representation
     */
    private void createHtml() {

        try {
            File f = new File("src/main/resources/social.html");
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));

            Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
            cfg.setDirectoryForTemplateLoading(new File("src/main/resources/template/"));

            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            cfg.setLogTemplateExceptions(false);
            cfg.setWrapUncheckedExceptions(true);
            cfg.setFallbackOnNullLoopVariable(false);

            Map<String, Object> root = new HashMap<>();
            root.put("image_source", "./social.svg");

            Template template = cfg.getTemplate("template.ftl");
            template.process(root, bw);

            Desktop.getDesktop().browse(f.toURI());
        }catch (TemplateException | IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public String executeCommand(List<String> args, ClientState clientState) {

        createHtml();
        return "HTML representation ";
    }
}
