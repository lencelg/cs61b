public class NBody{
    public static double readRadius(String filename){
       In in=new In(filename);
       int first=in.readInt();
       return in.readDouble();
    }
    public static Planet[] readPlanets(String filename){
        In in=new In(filename);
        int size=in.readInt();
        Planet[] ans=new Planet[size];
        double useless=in.readDouble();
        for(int i=0;i<size;i++){
           double xPos=in.readDouble(); 
           double yPos=in.readDouble(); 
           double xVel=in.readDouble(); 
           double yVel=in.readDouble(); 
           double mass=in.readDouble();
           String name=in.readString();
           Planet cur=new Planet(xPos,yPos,xVel,yVel,mass,name);
           ans[i]=cur;
        }
        return ans;
    }
    public static void main(String[] args) {
        double T=Double.parseDouble(args[0]);
        double dt=Double.parseDouble(args[1]);
        String filename=args[2];
        double radius=readRadius(filename);
        StdDraw.setPenRadius(radius);
        StdDraw.setScale(-radius,radius);
        StdDraw.enableDoubleBuffering();
        StdDraw.picture(0,0,"images/starfield.jpg");
        Planet[] allplanets=readPlanets(filename);
        for(int i=0;i<allplanets.length;i++){
            allplanets[i].draw();
        }
        StdDraw.show();
        StdAudio.play("audio/2001.mid");
        double time=0;
        while(time<=T){
            double[] xForces=new double[allplanets.length];
            double[] yForces=new double[allplanets.length];
            for(int i=0;i<allplanets.length;i++){
                xForces[i]=allplanets[i].calcNetForceExertedByX(allplanets);
                yForces[i]=allplanets[i].calcNetForceExertedByY(allplanets);
            }
            StdDraw.enableDoubleBuffering();
            StdDraw.picture(0,0,"images/starfield.jpg");
            for(int i=0;i<allplanets.length;i++){
                allplanets[i].update(dt,xForces[i],yForces[i]);
                allplanets[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time+=dt;
        }
      StdOut.printf("%d\n", allplanets.length);
      StdOut.printf("%.2e\n", radius);
      for (int i = 0; i < allplanets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  allplanets[i].xxPos, allplanets[i].yyPos, allplanets[i].xxVel,
                  allplanets[i].yyVel, allplanets[i].mass, allplanets[i].imgFileName);   
}
    }
}
