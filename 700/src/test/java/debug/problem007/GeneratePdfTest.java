package debug.problem007;

import static com.codeborne.pdftest.assertj.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.codeborne.pdftest.PDF;

public class GeneratePdfTest {

  @Test
  public void helloWorldPdf() throws IOException {
    PDF pdf = new PDF(generatePdf("<div>Hello, world!</div>"));
    assertThat(pdf).containsExactText("Hello, world!");
  }

  @Test
  public void emptyPdf() throws IOException {
    PDF pdf = new PDF(generatePdf("<div></div>"));
    assertThat(pdf).containsExactText("");
  }

  @Test
  public void multilineText() throws IOException {
    PDF pdf = new PDF(generatePdf("<div><h1>Hello, world!</h1> Do you like PDF?</div>"));
    assertThat(pdf).containsExactText("""
      Hello, world!
      Do you like PDF?"""
    );
  }

  public byte[] generatePdf(String html) throws IOException {
    try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
      ITextRenderer renderer = new ITextRenderer();
      renderer.setDocumentFromString(html);
      renderer.layout();
      renderer.createPDF(out);
      return out.toByteArray();
    }
  }

}
