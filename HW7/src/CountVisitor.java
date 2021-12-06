public class CountVisitor implements FileVisitor{
    
    public int numFiles = 0;
    
    public void visit(DirectoryDetails dir) { }

    public void visit(DocxFileDetails doc) {
        numFiles++;
    }

    public void visit(HtmlFileDetails html) {
        numFiles++;
    }
    
    public void visit(JpgFileDetails jpg) {
        numFiles++;
    }
    
    public void visit(Mp3FileDetails mp3) {
        numFiles++;
    }
    
    public void visit(PptxFileDetails pptx) {
        numFiles++;
    }
    
    public void visit(TxtFileDetails txt) {
        numFiles++;
    }
}
