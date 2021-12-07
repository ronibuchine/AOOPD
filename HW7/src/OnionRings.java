public class OnionRings extends HamburgerDecorator {
    
    public OnionRings(Hamburger hamburger) {
        super(hamburger);
    }

    @Override
    public String serve() {
        return super.serve() + " with onion rings";
    }
}
