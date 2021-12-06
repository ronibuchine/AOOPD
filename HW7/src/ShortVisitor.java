public class ShortVisitor implements FileVisitor {
    
    public void visit(DirectoryDetails dir) { 
        System.out.println(dir.getName());
    }
    
    public void visit(DocxFileDetails doc) {
        System.out.println(doc.getName());
    }
    
    public void visit(HtmlFileDetails html) {
        System.out.println(html.getName());
    }
    
    public void visit(JpgFileDetails jpg) {
        System.out.println(jpg.getName());
    }
    
    public void visit(Mp3FileDetails mp3) {
        System.out.println(mp3.getName());
    }
    
    public void visit(PptxFileDetails pptx) {
        System.out.println(pptx.getName());
    }
    
    public void visit(TxtFileDetails txt) {
        System.out.println(txt.getName());
    }
}
