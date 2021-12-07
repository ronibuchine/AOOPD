public class ToppingsFactory {
    
    public static HamburgerDecorator addTopping(String code, Hamburger hamburger) {
        switch (code) {
            case "ch":
                return new Chips(hamburger);
            case "or":
                return new OnionRings(hamburger);
            case "sa":
                return new Salad(hamburger);
            case "fe":
                return new FriedEgg(hamburger);
        }
        throw new RuntimeException("Not a Topping");
    }
}
