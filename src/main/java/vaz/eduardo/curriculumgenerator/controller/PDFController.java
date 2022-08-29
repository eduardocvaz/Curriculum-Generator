package vaz.eduardo.curriculumgenerator.controller;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import vaz.eduardo.curriculumgenerator.domain.About;
import vaz.eduardo.curriculumgenerator.domain.Curriculum;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Controller
@RequestMapping("/api/curriculums")
public class PDFController {

    @Autowired
    ServletContext servletContext;

    private final TemplateEngine templateEngine;

    public PDFController(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @RequestMapping(path = "/")
    public String getCurriculumPage(Model model) {
        Curriculum curriculum = new Curriculum();
        About about = new About();
        about.setDescription("Mussum Ipsum, cacilds vidis litro abertis. Suco de cevadiss, é um leite divinis, qui tem lupuliz, matis, aguis e fermentis.Quem num gosta di mim que vai caçá sua turmis!Casamentiss faiz malandris se pirulitá.Vehicula non. Ut sed ex eros. Vivamus sit amet nibh non tellus tristique interdum.");
        curriculum.setAbout(about);
        model.addAttribute("curriculumEntry", curriculum);
        return "curriculum";
    }

    @RequestMapping(path = "/pdf")
    public ResponseEntity<?> getPDF(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Curriculum curriculum = new Curriculum();

        WebContext context = new WebContext(request, response, servletContext);
        context.setVariable("curriculumEntry", curriculum);
        String orderHtml = templateEngine.process("curriculum", context);

        /* Setup Source and target I/O streams */

        ByteArrayOutputStream target = new ByteArrayOutputStream();
        ConverterProperties converterProperties = new ConverterProperties();
        converterProperties.setBaseUri("http://localhost:8080");
        /* Call convert method */
        HtmlConverter.convertToPdf(orderHtml, target, converterProperties);

        /* extract output as bytes */
        byte[] bytes = target.toByteArray();


        /* Send the response as downloadable PDF */

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=order.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(bytes);
    }


}
