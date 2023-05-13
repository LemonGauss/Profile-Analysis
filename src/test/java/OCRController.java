import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class OCRController {
    @Test
    public void uploadPDF() throws TesseractException, IOException {



        String filePath = "E:\\实验5 数据库更新.pdf";
        // 2. 调用OCR识别方法，将识别结果存储到StringBuilder
        StringBuilder ocrResult = ocrRecognize(filePath);

        // 3. 打印识别结果
        System.out.println(ocrResult.toString());

    }

    private StringBuilder ocrRecognize(String filePath) throws IOException, TesseractException {
        // 创建临时目录来存储中间文件
        File tempDir = new File("path/to/temp/dir");
        if (!tempDir.exists()) {
            tempDir.mkdirs();
        }

        // 将PDF转换为图片
        List<String> imageFiles = convertPdfToImages(filePath, tempDir);

        // 使用Tesseract进行文字识别
        StringBuilder ocrResult = new StringBuilder();
        for (String imageFile : imageFiles) {
            String ocrText = recognizeText(imageFile);
            ocrResult.append(ocrText);
        }

        // 删除临时文件
        for (String imageFile : imageFiles) {
            new File(imageFile).delete();
        }
        tempDir.delete();

        return ocrResult;
    }

    private List<String> convertPdfToImages(String filePath, File outputDir) throws IOException {
        PDDocument document = PDDocument.load(new File(filePath));
        PDFRenderer renderer = new PDFRenderer(document);

        List<String> imageFiles = new ArrayList<>();

        for (int i = 0; i < document.getNumberOfPages(); i++) {
            BufferedImage image = renderer.renderImageWithDPI(i, 300);
            String imageFile = outputDir.getAbsolutePath() + "/page_" + (i + 1) + ".png";
            ImageIO.write(image, "png", new File(imageFile));
            imageFiles.add(imageFile);
        }

        document.close();

        return imageFiles;
    }

    private String recognizeText(String imagePath) throws TesseractException {
        File imageFile = new File(imagePath);
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("E:\\Program Files\\Tesseract-OCR\\tessdata");//语言库位置
        tesseract.setLanguage("eng+chi_sim");
        return tesseract.doOCR(imageFile);
    }
}
