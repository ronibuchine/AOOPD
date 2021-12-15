package HW7.src;

public class SizeVisitor implements FileVisitor {
    private int byteSize = 0;

    public int getByteSize() {
        return byteSize;
    }

    public void visit(DirectoryDetails dir) {
    }

    public void visit(DocxFileDetails doc) {
        byteSize += doc.getSize();
    }

    public void visit(HtmlFileDetails html) {
        byteSize += html.getSize();
    }

    public void visit(JpgFileDetails jpg) {
        byteSize += jpg.getSize();
    }

    public void visit(Mp3FileDetails mp3) {
        byteSize += mp3.getSize();
    }

    public void visit(PptxFileDetails pptx) {
        byteSize += pptx.getSize();
    }

    public void visit(TxtFileDetails txt) {
        byteSize += txt.getSize();
    }
}
