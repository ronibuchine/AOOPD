package HW7.src;

public class FriedEgg extends HamburgerDecorator {

    public FriedEgg(Hamburger hamburger) {
        super(hamburger);
    }

    @Override
    public String serve() {
        return super.serve() + " with fried egg";
    }
}
