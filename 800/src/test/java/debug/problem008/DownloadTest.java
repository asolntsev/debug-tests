package debug.problem008;

import static com.codeborne.selenide.FileDownloadMode.PROXY;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Configuration;

public class DownloadTest {

  @BeforeEach
  void setUp() {
    Configuration.fileDownload = PROXY;
    Configuration.proxyEnabled = true;
    open("https://selenide.org/test-page/download.html");
  }

  @Test
  public void downloadTextFile() throws FileNotFoundException {
    File hello = $(byText("hello-world.txt")).download();
    assertThat(hello).content().isEqualTo("Hello, world!");
  }

  @Test
  public void downloadPdfFile() throws FileNotFoundException {
    File hello = $(byText("hello-world.pdf")).download();
    assertThat(hello).hasName("hello-world.pdf");
  }
}
