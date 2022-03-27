package commands;

import catalog.Catalog;
import custom_exceptions.CustomException;
import freemarker.template.Configuration;
import freemarker.template.Template;

import javax.swing.text.View;
import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class ReportCommand extends Command{

    public ReportCommand(){
        this.name = "Report command";
        this.description = "creates (and opens) an HTML report representing the content of the catalog.";
    }

    @Override
    public void getInfo() {
        System.out.println(name + " " + description);
    }

    public void report(Catalog catalog){

        try{
            if( catalog == null )
                throw new CustomException("Catalog is null!");
            if( catalog.getCatalog().isEmpty())
                throw new CustomException("Catalog array is empty!");

            Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
            cfg.setClassForTemplateLoading(ReportCommand.class, "/");
            cfg.setDefaultEncoding("UTF-8");
            cfg.setDirectoryForTemplateLoading(new File("target/template"));

            Template template = cfg.getTemplate("template.ftl");
            Map<String,Object> templateInfo = new HashMap<>();
            templateInfo.put("catalog_name",catalog.getName());
            templateInfo.put("catalog",catalog.getCatalog());

            StringWriter out = new StringWriter();
            template.process(templateInfo, out);
            FileWriter fileWriter = new FileWriter("target/template/report.html");
            fileWriter.write(out.getBuffer().toString());
            fileWriter.close();
            out.flush();

            ViewCommand view = new ViewCommand();
            view.view("target/template/report.html");
        }
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
