public class HamburgerFactory {
    
    public static Hamburger createHamburger(String code){
        switch (code) {
            case "cl":
                return new ClassicHamburger();
            case "sp":
                return new SpicyHamburger();
            case "la":
                return new LambHamburger();
            case "hm":
                return new HomemadeHamburger();
        }
        throw new RuntimeException("wrong Hamburger");
    }
}
