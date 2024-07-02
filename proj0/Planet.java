public class Planet {
    public double xxPos,yyPos,xxVel,yyVel,mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV,double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet b) {
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }

    public double calcDistance(Planet goal) {
        double dx = this.xxPos - goal.xxPos;
        double dy = this.yyPos - goal.yyPos;
        double square_r = dx * dx + dy *dy;
        return Math.sqrt(square_r);
    }

    public double calcForceExertedBy(Planet goal) {
        double dist = this.calcDistance(goal);
        double gemma = 6.67e-11;
        double tempforce = gemma * this.mass * goal.mass;
        double force = tempforce / dist / dist;
        return force;
    }

    public double calcForceExertedByX(Planet goal) {
        double force = calcForceExertedBy(goal);
        double dist = this.calcDistance(goal);
        double dx = goal.xxPos - this.xxPos;
        return force * dx / dist;
    }

    public double calcForceExertedByY(Planet goal) {
        double force = calcForceExertedBy(goal);
        double dist = this.calcDistance(goal);
        double dy = goal.yyPos - this.yyPos;
        return force * dy / dist;
    }

    //calcNetForceExertedByX
    public double calcNetForceExertedByX(Planet[] allPlanets) {
        int length = allPlanets.length;
        double sum = 0;
        for (int i = 0; i < length; i++) {
            if (this.equals(allPlanets[i])) {
                continue;
            }
            sum = sum + calcForceExertedByX(allPlanets[i]);
            //System.out.println(sum);
        }
        return sum;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets) {
        int length = allPlanets.length;
        double sum = 0;
        for (int i = 0; i < length; i++) {
            if (this.equals(allPlanets[i])) {
                continue;
            }
            sum = sum + calcForceExertedByY(allPlanets[i]);
            //System.out.println(sum);
        }
        return sum;
    }
}