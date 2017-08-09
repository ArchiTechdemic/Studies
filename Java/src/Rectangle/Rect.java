/*
 * The MIT License
 *
 * Copyright 2016 ArchiTechdemic <Techdemic.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */


package Rectangle;

/**
 * This case study provide the logic to find some properties for rectangles.
 * This exercise specifically provide analysis of a common question 
 * How to find out if 2 rectangles intersect?
 * This is a study using core Java, not depending on any other graphic packages.
 *
 * @author ArchiTechdemic <Techdemic.com>
 */
public class Rect {
    public int x1, y1, x2, y2;
    
    /* 
     * A rectangle is defined by 2 points
     * x1, y1 represent the lower left corner point
     * x2, y2 represent the upper right corner point
     */
    public Rect (int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    
    public int width() {
        return x2 - x1;
    }
    
    public int height() {
        return y2 - y1;
    }
    
    // area of a rectangle is width * height
    public int area() { 
        return (this.width() * this.height());
    }
    
    // to move the rectangle horizontally by deltax, and vertically by deltay
    public void move(int deltax, int deltay) { 
        x1 += deltax; x2 += deltax;
        y1 += deltay; y2 += deltay;
    }
    
    // a point is inside the rectangle if x is between x1 and x2
    // and y is between y1 and y2
    public boolean isInside(int x, int y) {
        return ( (x >= x1) && (x <= x2) && (y >= y1) && (y <= y2) );
    }
    
    // Return the union of this rectangle with another. The smallest 
    // rectangle that includes them both.
    public Rect union (Rect r) {   
        return new Rect ( (this.x1 < r.x1) ? this.x1 : r.x1,
                          (this.y1 < r.y1) ? this.y1 : r.y1,
                          (this.x2 > r.x2) ? this.x2 : r.x2,
                          (this.y2 > r.y2) ? this.y2 : r.y2 );                         
    }
    
    // Find the intersection area between 2 rectangle
    // and return the intersection rectangle
    public Rect intersection(Rect r) {
        Rect result = new Rect ( (this.x1 > r.x1) ? this.x1 : r.x1,
                                 (this.y1 > r.y1) ? this.y1 : r.y1,
                                 (this.x2 < r.x2) ? this.x2 : r.x2,
                                 (this.y2 < r.y2) ? this.y2 : r.y2 );
        
        // to be a valid rectangle x1 can not be greater than x2
        // and y1 can not be greater than y2.
        if (result.x1 > result.x2) { result.x1 = result.x2 = 0; }
        if (result.y1 > result.y2) { result.y1 = result.y2 = 0; }
        
        return result;
    }
    
    // case study 1: find the intersection area between the 2 rectangles
    // the 2 rectangle intersect if result is a valid rectangle, 
    // meaning it's area > 0,
    public boolean intersect1(Rect r) {
        // Method1 : First find the intersection 
        // if area of the intersection is greater than 0, they intersect.
        Rect i = this.intersection(r); 
        return i.area() > 0;
    }
    
    // case study 2: we can also find out when the rectangles do NOT intersect by
    // the following logic:
    //      if the lower left point of R1 is 
    //         greater than the upper right point of R2 
    //             or
    //      if the lower left point of R2 is 
    //         greater than the upper right point of R1
    // and just return the negative value to indicate if it intersect or vice versa.
    public boolean intersect2(Rect r) {  
        return !(this.x1 > r.x2 || this.y1 > r.y2 || r.x1 > this.x2 || r.y1 > this.y2); 
    }
    
    @Override
    public String toString() {
        return "[x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + 
                    ", width=" + this.width() + ", height=" + this.height() + 
                    ", area=" + this.area() + "]";
    } 
    
    public static void main(String[] args) {
        // A study to show how to determine if 2 rectangles intersect?
        // As well as to explore additional properties for rectangle.

        // Let's create a few rectangles
        Rect r1 = new Rect (2,0,9,6);
        Rect r2 = new Rect (5,3,13,7);
        Rect r3 = new Rect (-3,-3,4,1);
        Rect r4 = new Rect (6,8,10,11);
        Rect r5 = new Rect (-5,3,-1,6);
        Rect r6 = new Rect (2,-8,6,-4);

        System.out.println ("\nUse Case: Find out if two rectangles intersect each other?");
 
        System.out.println ("\n--- Test Case 1 ---");
        System.out.println ("r2 = " + r2);
        System.out.println ("r3 = " + r3);
        System.out.println ("r2 intersection r3 = " + r2.intersection(r3));
        System.out.println ("r2 intersect1 r3? " + r2.intersect1(r3));
        System.out.println ("r2 intersect2 r3? " + r2.intersect2(r3));

        System.out.println ("\n--- Test Case 2 ---");
        System.out.println ("r1 = " + r1);
        System.out.println ("r2 = " + r2);
        System.out.println ("r1 intersection r2 = " + r1.intersection(r2));
        System.out.println ("r1 intersect1 r2? " + r1.intersect1(r2));
        System.out.println ("r1 intersect2 r2? " + r1.intersect2(r2));

        System.out.println ("\n--- Test Case 3 ---");
        System.out.println ("r1 = " + r1);
        System.out.println ("r3 = " + r3);
        System.out.println ("r1 intersection r3 = " + r1.intersection(r3));
        System.out.println ("r1 intersect1 r3? " + r1.intersect1(r3));
        System.out.println ("r1 intersect2 r3? " + r1.intersect2(r3));

        System.out.println ("\n--- Test Case 4 ---");
        System.out.println ("r1 = " + r1);
        System.out.println ("r4 = " + r4);
        System.out.println ("r1 intersection r4 = " + r1.intersection(r4));
        System.out.println ("r1 intersect1 r4? " + r1.intersect1(r4));
        System.out.println ("r1 intersect2 r4? " + r1.intersect2(r4));

        System.out.println ("\n--- Test Case 5 ---");
        System.out.println ("r1 = " + r1);
        System.out.println ("r5 = " + r5);
        System.out.println ("r1 intersection r5 = " + r1.intersection(r5));
        System.out.println ("r1 intersect1 r5? " + r1.intersect1(r5));
        System.out.println ("r1 intersect2 r5? " + r1.intersect2(r5));

        System.out.println ("\n--- Test Case 6 ---");
        System.out.println ("r1 = " + r1);
        System.out.println ("r6 = " + r6);        
        System.out.println ("r1 intersection r6 = " + r1.intersection(r6));
        System.out.println ("r1 intersect1 r6? " + r1.intersect1(r6));
        System.out.println ("r1 intersect2 r6? " + r1.intersect2(r6));

        // if we move r6 up 5 space, it will intersect with r1
        System.out.println ("\n--- Test Case 7 ---");
        System.out.println ("r1 = " + r1);
        System.out.println ("r6 before move = " + r6);
        r6.move(0,5);
        System.out.println ("r6 after move (0,5) = " + r6);
        System.out.println ("r1 intersection r6 = " + r1.intersection(r6));
        System.out.println ("r1 intersect1 r6? " + r1.intersect1(r6));
        System.out.println ("r1 intersect2 r6? " + r1.intersect2(r6));

        // after the move of r6, it should intersect with r3 as well
        System.out.println ("\n--- Test Case 8 ---");
        System.out.println ("r3 = " + r3);
        System.out.println ("r6 = " + r6);
        System.out.println ("r3 intersection r6 = " + r3.intersection(r6));
        System.out.println ("r3 intersect1 r6? " + r3.intersect1(r6));
        System.out.println ("r3 intersect2 r6? " + r3.intersect2(r6));

        // intersection with the union of self and another rectangle,
        // will always be self
        System.out.println ("\n--- Test Case 9 ---");
        System.out.println ("r1 = " + r1);
        System.out.println ("r2 = " + r2);
        Rect u = r1.union(r2);
        System.out.println ("u = r1 union r2 = " + u);
        System.out.println ("r1 intersection u = " + r1.intersection(u));
        System.out.println ("r1 intersect1 u? " + r1.intersect1(u));
        System.out.println ("r1 intersect2 u? " + r1.intersect2(u));
        
        System.out.println ("\n--- Test cases completed ---");
    }
}
