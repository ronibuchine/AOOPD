package HW7.src;

public interface FileVisitor {
    public void visit(DirectoryDetails dir);

    public void visit(DocxFileDetails docx);

    public void visit(HtmlFileDetails html);

    public void visit(JpgFileDetails jpg);

    public void visit(Mp3FileDetails mp3);

    public void visit(PptxFileDetails pptx);

    public void visit(TxtFileDetails txt);
}
