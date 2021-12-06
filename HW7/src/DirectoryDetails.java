import java.util.ArrayList;

public class DirectoryDetails extends FileDetails {

    public ArrayList<FileDetails> contents = new ArrayList<>();

    public DirectoryDetails(String path, String name){
        super(path,name);
    }
    public void addFile(FileDetails fileDetails){
        contents.add(fileDetails);
    }
    public void accept(FileVisitor visitor){
        for (FileDetails file : contents) {
            file.accept(visitor);
        }
        visitor.visit(this);
    }
}