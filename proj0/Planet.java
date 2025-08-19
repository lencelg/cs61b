public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final double gravity=6.67e-11;
    public Planet(double xP, double yP, double xV,
              double yV, double m, String img){
        this.xxPos=xP;
        this.yyPos=yP;
        this.xxVel=xV;
        this.yyVel=yV;
        this.mass=m;
        this.imgFileName=img;
    } 
    public Planet(Planet P){
        this.xxPos=P.xxPos;
        this.yyPos=P.yyPos;
        this.xxVel=P.xxVel;
        this.yyVel=P.yyVel;
        this.mass=P.mass;
        this.imgFileName=P.imgFileName;
    }
    public double calcDistance(Planet other){
        double xdis=(this.xxPos-other.xxPos)*(this.xxPos-other.xxPos);
        double ydis=(this.yyPos-other.yyPos)*(this.yyPos-other.yyPos);
        return Math.sqrt(xdis+ydis);
    }
    public double calcForceExertedBy(Planet other){
        double dis=calcDistance(other);
        return (gravity*this.mass*other.mass)/(dis*dis);
    }
    public double calcForceExertedByX(Planet other) {
        double dis=calcDistance(other);
        double force=calcForceExertedBy(other);
        return force*(other.xxPos-this.xxPos)/dis;
    }
    public double calcForceExertedByY(Planet other) {
        double dis=calcDistance(other);
        double force=calcForceExertedBy(other);
        return force*(other.yyPos-this.yyPos)/dis;
    }
    public double calcNetForceExertedByX(Planet[] allPlanets){
        double ans=0;
        for(int i=0;i<allPlanets.length;i++){
            if (this.equals(allPlanets[i])) {
                continue; 
            }
            ans+=calcForceExertedByX(allPlanets[i]);
        }
        return ans;
    }
    public double calcNetForceExertedByY(Planet[] allPlanets){
        double ans=0;
        for(int i=0;i<allPlanets.length;i++){
            if (this.equals(allPlanets[i])) {
                continue; 
            }
            ans+=calcForceExertedByY(allPlanets[i]);
        }
        return ans;
    }
    public void update(double time,double xforce,double yforce){
        double newxVel=this.xxVel+(xforce/this.mass)*time;
        double newyVel=this.yyVel+(yforce/this.mass)*time;
        this.xxVel=newxVel;
        this.yyVel=newyVel;
        this.xxPos=this.xxPos+(this.xxVel)*time;
        this.yyPos=this.yyPos+(this.yyVel)*time;
    }
    public void draw(){
        StdDraw.picture(this.xxPos,this.yyPos,"images/"+this.imgFileName);
    }
}
