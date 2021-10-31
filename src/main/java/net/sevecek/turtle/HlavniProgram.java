package net.sevecek.turtle;

import net.sevecek.turtle.engine.*;

import java.awt.*;

public class HlavniProgram {
    Turtle zofka;

    public void main(String[] args) {
        zofka = new Turtle();
        Color colorDefault = zofka.getPenColor();
        int penWidthDefault = zofka.getPenWidth();

        // snehulak
        zofka.setLocation(400, 400);
        zofka.turnRight(90);
        circle(200);
        zofka.turnRight(180);
        circle(150);
        zofka.setLocation(400, 250);
        circle(120);
        zofka.turnLeft(90); // hlavou dolu
        zofka.setLocation(325, 325);
        circle(60);
        zofka.turnRight(180);
        zofka.setLocation(475, 325);
        circle(60);  //hlavou nahoru - vychozi smer

        //zmrzlina
        double sideOfTriangle = 300;
        double angleBetweenSameLengthSides = 30;

        zofka.setLocation(180, 300);
        zofka.turnRight(180);
        zofka.turnRight(angleBetweenSameLengthSides / 2);
        zofka.setPenWidth(5);
        zofka.setPenColor(Color.orange);
        triangleIsosceles(sideOfTriangle, angleBetweenSameLengthSides);
        zofka.setPenColor(new Color(102, 51, 0));
        circle(calculationDiameterFromSecularAndAngle(
                calcutation3rdSideLengthOfTriangleIsosceles(sideOfTriangle, angleBetweenSameLengthSides),
                180 - angleBetweenSameLengthSides)
        );
        zofka.turnLeft(angleBetweenSameLengthSides / 2);  //zofka hlavou dolu
        zofka.turnLeft(180); //zofka vychozi smer
        zofka.setPenWidth(penWidthDefault);

        //vlak
        zofka.setLocation(1000, 500);
        zofka.setPenColor(Color.RED);
        circle(250);
        rectangle(300, 250);
        zofka.turnLeft(90);
        rectangle(320, 150);
        zofka.setLocation(680, 400);
        zofka.turnLeft(90);
        triangleIsosceles(150, 90);
        zofka.turnLeft(90);
        zofka.setLocation(760, 500);
        circle(125);
        zofka.setLocation(910, 500);
        circle(125);
        zofka.turnLeft(90); //zofka hlavou nahoru
        zofka.setPenColor(colorDefault);

    }

    public void circle(double diameter) {
        for (int i = 0; i < 360; i++) {
            zofka.move(diameter * Math.PI / 360);
            zofka.turnRight(1);
        }
    }

    public void square(double sideLength) {
        for (int i = 0; i < 3; i++) {
            zofka.move(sideLength);
            zofka.turnRight(90);
        }
    }

    public void rectangle(double sideLengthA, double sideLengthB) {
        for (int i = 0; i < 2; i++) {
            zofka.move(sideLengthA);
            zofka.turnRight(90);
            zofka.move(sideLengthB);
            zofka.turnRight(90);
        }
    }

    public void triangleIsosceles(double lengthOf2SidesIsoscelesTriangle, double angleBetweenSameLengthSides) {
        double turningAngleAlfa = 180 - angleBetweenSameLengthSides;
        double turningAngleBeta = 90 + angleBetweenSameLengthSides / 2;
        zofka.move(lengthOf2SidesIsoscelesTriangle);
        zofka.turnRight(turningAngleAlfa);
        zofka.move(lengthOf2SidesIsoscelesTriangle);
        zofka.turnRight(turningAngleBeta);
        zofka.move(calcutation3rdSideLengthOfTriangleIsosceles(lengthOf2SidesIsoscelesTriangle, angleBetweenSameLengthSides));
        zofka.turnRight(turningAngleBeta);
    }

    public double calcutation3rdSideLengthOfTriangleIsosceles(double lengthOf2SidesIsoscelesTriangle, double angleBetweenSameLengthSides) {
        double thirdSideLength;
        thirdSideLength = Math.abs((lengthOf2SidesIsoscelesTriangle * Math.sin((angleBetweenSameLengthSides * Math.PI / 180) / 2)) * 2);
        return thirdSideLength;
    }

    public double calculationDiameterFromSecularAndAngle(double secularLength, double Angle) {
        double diameter;
        diameter = secularLength / Math.abs(Math.sin(Angle * Math.PI / (180 * 2)));
        return diameter;
    }


}
