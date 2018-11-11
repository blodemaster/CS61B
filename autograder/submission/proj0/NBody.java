import java.awt.*;

/**
 * Created by varad on 7/13/16.
 */
public class NBody {

    /** 
     * Read the radius of universe from txt file
     */
    public static double readRadius(String filePath) {
        In in = new In(filePath);
        int N = in.readInt();
        double R = in.readDouble();
        return R;   
    }

    public static Planet[] readPlanets(String filePath) {
        In in = new In(filePath);
        int N = in.readInt();
        double R = in.readDouble();
        Planet[] allPlanets = new Planet[N];
        for (int i = 0; i < N; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String img = in.readString();
            allPlanets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, img);
        }
        return allPlanets;
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Three command line arguments should be provided");
        } 
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filePath = args[2];

        double R = readRadius(filePath);
        Planet[] allPlanets = readPlanets(filePath);

        StdDraw.setScale(-R, R);
        StdDraw.enableDoubleBuffering();
       
        double runningTime = 0.0;
        int N = allPlanets.length;
        double[] xForces = new double[N];
        double[] yForces = new double[N];

        while (runningTime <= T) {
            for (int i = 0; i < N; i++) {
                xForces[i] = allPlanets[i].calcNetForceExertedByX(allPlanets);
                yForces[i] = allPlanets[i].calcNetForceExertedByY(allPlanets);
                allPlanets[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.clear();
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet p: allPlanets) {
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(5);
            runningTime += dt;
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                          planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                          planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }       
    }
}
