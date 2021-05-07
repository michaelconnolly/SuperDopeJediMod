package superdopesquad.superdopejedimod.weapon;

public enum PowerLevel {
    STANDARD(2.0F, 1.6D, 12.0D),
    RIFLE(4.0F, 1.6D, 12.0D),
    CANNON(6.0F, 1.6D, 12.0D),
    HEAVY(25.0F, 5.0D, 5.0D);

    private final float damageLevel;
    private final double velocity;
    private final double accuracy;

    public float damageLevel() { return damageLevel; }
    public double velocity() { return velocity; }
    public double accuracy() { return accuracy; }

    PowerLevel(float damageLevel, double velocity, double accuracy) {
        this.damageLevel = damageLevel;
        this.velocity = velocity;
        this.accuracy = accuracy;
    }
}
