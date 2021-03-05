package superdopesquad.superdopejedimod.weapon;

public enum PowerLevel {
    STANDARD(2.0D, 1.6D, 12.0D),
    RIFLE(4.0D, 1.6D, 12.0D),
    CANNON(6.0D, 1.6D, 12.0D),
    HEAVY(25.0D, 5.0D, 5.0D);

    private final double damage;
    private final double velocity;
    private final double accuracy;

    public double damage() { return damage; }
    public double velocity() { return velocity; }
    public double accuracy() { return accuracy; }

    PowerLevel(double damage, double velocity, double accuracy) {
        this.damage = damage;
        this.velocity = velocity;
        this.accuracy = accuracy;
    }
}
