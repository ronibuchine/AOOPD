public class StatVisitor implements FileVisitor {
    
    public void visit(DirectoryDetails dir) { 
        CountVisitor countVisitor = new CountVisitor();
        dir.accept(countVisitor);
        System.out.println("Directory " + dir.getName() + " has " + countVisitor.getNumFiles() + " files.");
    }
    
    public void visit(DocxFileDetails doc) {
        double average = (double)doc.getWords() / doc.getPages();
        System.out.println("The file " + doc.getName() + " has an average of " + average + " words per page.");
    }
    
    public void visit(HtmlFileDetails html) {
        System.out.println("The file " + html.getName() + " contains " + html.getLines() + " lines.");
    }
    
    public void visit(JpgFileDetails jpg) {
        double average = (double)jpg.getSize() / (jpg.getWidth() *jpg.getHeight());
        System.out.println("The picture " + jpg.getName() + " has an average of " + average + " bytes per pixel.");
    }
    
    public void visit(Mp3FileDetails mp3) {
        double bitrate = (double)mp3.getSize() / mp3.getLengthSec();
        System.out.println("The bitrate of " + mp3.getName() + " is " + bitrate + " bytes per second.");
    }
    
    public void visit(PptxFileDetails pptx) {
        double average = (double)pptx.getSize() / pptx.getSlides();
        System.out.println("The average slide size in Presentation " + pptx.getName() + " is " + average + ".");
    }
    
    public void visit(TxtFileDetails txt) {
        System.out.println("The file " + txt.getName() + " contains " + txt.getWords() + " words.");
    }
}
