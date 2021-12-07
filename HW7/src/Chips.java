public class Chips extends HamburgerDecorator {
    
    public Chips(Hamburger hamburger) {
        super(hamburger);
    }

    @Override
    public String serve() {
        return super.serve() + " with chips";
    }
}
