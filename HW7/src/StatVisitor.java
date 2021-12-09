public class StatVisitor implements FileVisitor {
    
    public void visit(DirectoryDetails dir) { 
        
        //use CountVisitor to count the number of files in the directory
        CountVisitor countVisitor = new CountVisitor();
        dir.accept(countVisitor);
        
        System.out.println("Directory " + dir.getName() + " has " + countVisitor.getNumFiles() + " files.");
    }
    
    public void visit(DocxFileDetails doc) {
        double average = (double)doc.getWords() / doc.getPages();
        System.out.printf("The file " + doc.getName() + " has an average of %.6f words per page.\n", average);
    }
    
    public void visit(HtmlFileDetails html) {
        System.out.println("The file " + html.getName() + " contains " + html.getLines() + " lines.");
    }
    
    public void visit(JpgFileDetails jpg) {
        double average = (double)jpg.getSize() / (jpg.getWidth() *jpg.getHeight());
        System.out.printf("The picture " + jpg.getName() + " has an average of %.6f bits per pixel.\n", average);
    }
    
    public void visit(Mp3FileDetails mp3) {
        double bitrate = (double)mp3.getSize() / mp3.getLengthSec();
        System.out.printf("The bitrate of " + mp3.getName() + " is %.6f bytes per second.\n", bitrate);
    }
    
    public void visit(PptxFileDetails pptx) {
        double average = (double)pptx.getSize() / pptx.getSlides();
        System.out.printf("The average slide size in Presentation " + pptx.getName() + " is %.6f.\n", average);
    }
    
    public void visit(TxtFileDetails txt) {
        System.out.println("The file " + txt.getName() + " contains " + txt.getWords() + " words.");
    }
}
