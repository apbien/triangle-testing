import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest{

    triType test1type = triType.none;
    @Test
    public void typeTest1(){
        Triangle triangle1 = new Triangle(2,3,5);
        assertEquals(test1type, triangle1.classify());
        triangle1.setLength(3,5,2);
        assertEquals(test1type, triangle1.classify());
        triangle1.setLength(5,2,3);
        assertEquals(test1type, triangle1.classify());
    }

    triType test2type = triType.equilateral;
    double test2area = 0.0;
    @Test
    public void typeTest2(){
        Triangle triangle2 = new Triangle();
        assertEquals(test2type, triangle2.classify());
        assertEquals(test2area, triangle2.getArea());
    }

    triType test3type = triType.none;
    @Test
    public void typeTest3(){
        Triangle triangle3 = new Triangle(-5,1,1);
        assertEquals(test3type, triangle3.classify());
        triangle3.setLength(1,-5,3);
        assertEquals(test3type, triangle3.classify());
        triangle3.setLength(1,3,-5);
        assertEquals(test3type, triangle3.classify());
    }


    triType test4type = triType.scalene;
    @Test
    public void typeTest4(){
        Triangle triangle4 = new Triangle(2,3,4);
        assertEquals(test4type, triangle4.classify());
    }


    triType test5type = triType.isosceles;
    @Test
    public void typeTest5(){
        Triangle triangle5 = new Triangle(7,2,8,8,2,7);
        assertEquals(test5type, triangle5.classify());
    }

    triType test6type = triType.isosceles;
    @Test
    public void typeTest6(){
        Triangle triangle6 = new Triangle(5,4,5);
        assertEquals(test5type, triangle6.classify());
        triangle6.setLength(4,5,5);
        assertEquals(test5type, triangle6.classify());
    }

}