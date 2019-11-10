/*
Created by Alexander Bien
PeoplSoft ID: 1516996
Prof. Alipour
*/
import java.util.*;
//created an enum to better label the type of triangle
enum triType {
    equilateral, isosceles, scalene, right, none;
}

//Triangle Class
class Triangle extends Point{
    Point p1,p2,p3;
    int a,b,c;
    public Triangle(){a = 1; b = 1; c = 1;}
    public Triangle(int x, int y, int z){ a = x; b =y; c = z;}
    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3){
        p1 = new Point(x1,y1);
        p2 = new Point(x2,y2);
        p3 = new Point(x3,y3);
        a = p1.findLength(p2);
        b = p2.findLength(p3);
        c = p3.findLength(p1);
    }
    triType classify() {
        if (a <= 0 || b <= 0 || c <= 0) return triType.none;
        if (a == b && b == c) return triType.equilateral;
        if (a >= b+c || c >= b+a || b >= a+c) return triType.none;
        if (b==c || a==b || c==a) return triType.isosceles;
        return triType.scalene;
    }
    double getArea(){
        double s = (a+b+c)/2;
        double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        return area;
    }

    void setLength(int x, int y, int z){a = x; b = y; c = z;}

    public static void main(String[] args) {

    }
}

class Point{
    int x,y;
    Point(){x = 0; y = 0;}
    Point(int newX, int newY){x = newX; y = newY;}
    public int findLength(Point temp){
        int length = (int) Math.sqrt((Math.pow(temp.x-this.x,2)+Math.pow(temp.y-this.y,2)));
        return length;
    }
}
/*

import java.util.*;

//Created an enum to better categorize the type of triangle
enum triType
{
    equilateral, isosceles, scalene, right, none;
}

//Triangle Class
public class Triangle extends Point {
    Point pointA, pointB, pointC;
    int lengthA, lengthB, lengthC; //These variables represent each side
    triType type1, type2; //These variables represent the type of triangle (type2 denotes whether it is also a right triangle or none)

    //Overloaded Constructor that takes in 3 arguments and sets them to the corresponding side and sets the types to none
    Triangle(int lenA, int lenB, int lenC)
    {
        lengthA = lenA;
        lengthB = lenB;
        lengthC = lenC;
        type1 = triType.none;
        type2 = triType.none;

        checkType();
    }
    Triangle(int Ax, int Ay,int Bx, int By,int Cx, int Cy)
    {

        pointA = new Point(Ax,Ay);
        pointB = new Point(Bx,By);
        pointC = new Point(Cx,Cy);
        lengthA = pointA.findLength(pointB);
        lengthB = pointB.findLength(pointC);
        lengthC = pointC.findLength(pointA);
        type1 = triType.none;
        type2 = triType.none;

    }

    //Function that assigns type1 and type2 to the triangle types based on the sides
    public void checkType(){
        if(lengthA == lengthB && lengthB == lengthC) {
            type1 = triType.equilateral;
        }
        else if(lengthA == lengthB || lengthB == lengthC || lengthC == lengthA){
            type1 = triType.isosceles;
        }
        else{
            type1 = triType.scalene;
        }

        if(((Math.pow(lengthA,2) + Math.pow(lengthB,2)) == Math.pow(lengthC,2))||
                ((Math.pow(lengthB,2) + Math.pow(lengthC,2)) == Math.pow(lengthA,2))||
                ((Math.pow(lengthC,2) + Math.pow(lengthA,2)) == Math.pow(lengthB,2))){
            type2 = triType.right;

        }
    }

    //Function that can be called in main without a triangle object to see if the sides entered are legal
    public static boolean checkLegalSides(int lenA, int lenB, int lenC){
        boolean legal = true;
        if(lenA <= 0 || lenB <= 0 || lenC <= 0){ legal = false;}
        if((lenA+lenB) <= lenC){legal = false;}
        if((lenB+lenC) <= lenA){legal = false;}
        if((lenC+lenA) <= lenB){legal = false;}
        return legal;
    }

    //Function to print the type of triangle as output
    public void print() {
        if (type2 == triType.none) {
            System.out.println("You have a " + type1 + " triangle.");
        } else {
            System.out.println("You have a " + type2 + ", " + type1 + " triangle.");
        }
    }

    public int getSide(String side){
        if(side.equals("A")){return lengthA;}
        else if(side.equals("B")){return lengthB;}
        else{return lengthC;}
    }
    public double getArea(){
        double s = (lengthA+lengthB+lengthC)/2;
        s = s*(s-lengthA)*(s-lengthB)*(s-lengthC);
        double area = Math.sqrt(s);
        return area;
    }
    //main
    public static void main(String args[]) {
        while (true) {
            int lenA, lenB, lenC;
            int pointAx, pointAy, pointBx, pointBy, pointCx, pointCy;
            Triangle newTriangle = null;
            Scanner in = new Scanner(System.in);

            System.out.println("\n__________Triangle Input Program__________");
            System.out.println("1. Enter in Sides");
            System.out.println("2. Enter in Points");
            System.out.println("3. Quit");
            System.out.println("User Choice: ");
            String x = in.next();
            if(x.equals("3")){break;}

            else if(x.equals("1")) {
                System.out.println("Please enter an integer for Side A: ");
                lenA = in.nextInt();
                System.out.println("Please enter an integer for Side B: ");
                lenB = in.nextInt();
                System.out.println("Please enter an integer for Side C: ");
                lenC = in.nextInt();

                if (checkLegalSides(lenA, lenB, lenC)) {
                    newTriangle = new Triangle(lenA, lenB, lenC);
                    newTriangle.print();
                    System.out.println("Would you like to get the area?(y/n): ");
                    String choice;
                    choice = in.next();
                    if(choice.equals("y")){
                        System.out.println("Your triangle's area is: " + newTriangle.getArea());
                    }
                } else {
                    System.out.println("Sorry, but the sides you have entered created an invalid triangle.");
                }
            }else if(x.equals("2")){
                System.out.println("Please enter an x-coordinate for Point A: ");
                pointAx = in.nextInt();
                System.out.println("Please enter an y-coordinate for Point A: ");
                pointAy = in.nextInt();
                System.out.println("Please enter an x-coordinate for Point B: ");
                pointBx = in.nextInt();
                System.out.println("Please enter an y-coordinate for Point B: ");
                pointBy = in.nextInt();
                System.out.println("Please enter an x-coordinate for Point C: ");
                pointCx = in.nextInt();
                System.out.println("Please enter an y-coordinate for Point C: ");
                pointCy = in.nextInt();

                newTriangle = new Triangle(pointAx, pointAy, pointBx, pointBy, pointCx, pointCy);
                if (checkLegalSides(newTriangle.getSide("A"), newTriangle.getSide("B"), newTriangle.getSide("C"))) {
                    newTriangle.checkType();
                    newTriangle.print();
                } else {
                    System.out.println("Sorry, but the points you have entered created an invalid triangle.");
                }
                System.out.println("Would you like to get the area?(y/n): ");
                String choice;
                choice = in.next();
                if(choice.equals("y")){
                    System.out.println("Your triangle's area is: " + newTriangle.getArea());
                }
            }
            else if(!x.equals("1")||!x.equals("2")){
                System.out.println("Sorry, please try again.");
                continue;
            }
        }
    }
}

class Point{
    int x,y;
    Point(){x = 0; y = 0;}
    Point(int newX, int newY){x = newX; y = newY;}
    public int findLength(Point temp){
        int length = (int) Math.sqrt((Math.pow(temp.x-this.x,2)+Math.pow(temp.y-this.y,2)));
        return length;
    }
    public void setPoints(int newX, int newY){
        this.x = newX; this.y = newY;
    }
}
*/