public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV,
        double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double rSquare = Math.pow((p.xxPos - this.xxPos), 2) + Math.pow((p.yyPos - this.yyPos), 2);
        return Math.pow(rSquare, 0.5);
    }

    public double calcForceExertedBy(Planet p) {
        double r = calcDistance(p);
        double numerator = G * p.mass * this.mass;
        double force = numerator / (r * r);
        return force;
    }

    public double calcForceExertedByX(Planet p) {
        double f = calcForceExertedBy(p);
        double r = calcDistance(p);
        return f * (p.xxPos - this.xxPos) / r;
    }

    public double calcForceExertedByY(Planet p) {
        double f = calcForceExertedBy(p);
        double r = calcDistance(p);
        return f * (p.yyPos - this.yyPos) / r;
    }

    public double calcNetForceExertedByX(Planet[] allPlanets) {
        double netForceX = 0;
        for (Planet p: allPlanets) {
            if (!this.equals(p)) {
                netForceX += calcForceExertedByX(p);
            }
        }
        return netForceX;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets) {
        double netForceY = 0;
        for (Planet p: allPlanets) {
            if (!this.equals(p)) {
                netForceY += calcForceExertedByY(p);
            }
        }
        return netForceY;
    }

    public void update(double dt, double fX, double fY) {
        double aX = fX / this.mass;
        double aY = fY / this.mass;
        this.xxVel += dt * aX;
        this.yyVel += dt * aY;
        this.xxPos += dt * xxVel;
        this.yyPos += dt * yyVel;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}