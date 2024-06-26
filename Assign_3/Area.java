import java.util.Scanner;
/**
 * This class will give you the area of some popular closed figure.
 */
public class Area {

    /**
     * If a arithmatic error occurs, such as overflow , an AtithmeticException it will throw an error
     * This method is used to calculate triangle Area  
     * @param width The Width of the Triangle or can be consider as base of the triangle
     * @param height The height of the triangle . Must be greater then zero
     * @return The area of triangle as a double
     */
    static double triangleArea(double width,double height){
        if(width<=0||height<=0){
            throw new IllegalArgumentException("Base and height must be greater then zero");
        }
       try {
        return (width*height)/2;
       } catch (ArithmeticException e) {
        throw new ArithmeticException("Arithmetic error occures while calculating the area");
       } 
    }
    /**
     * If a arithmatic error occurs, such as overflow , an AtithmeticException it will throw an error 
     * @param width The Width of the Rectangle. Must be greater then zero
     * @param height The height of the Rectangle . Must be greater then zero
     * @return The area of Rectangle as a double
     */
    static double rectangleArea(double width, double height){
        if(width<=0||height<=0){
            throw new IllegalArgumentException("Base and height must be greater then zero");
        }
       try {
        return width*height;
       } catch (ArithmeticException e) {
        throw new ArithmeticException("Arithmetic error occures while calculating the area");
       } 
    }
    /**
     * If a arithmatic error occurs, such as overflow , an AtithmeticException it will throw an error 
     * @param width The Width of the Triangle or can be consider as base of the triangle
     * @param height The height of the triangle . Must be greater then zero
     * @return The area of triangle as a double
     */
    static double squareArea(double side){
        if(side<=0){
            throw new IllegalArgumentException("Base and height must be greater then zero");
        }
       try {
        return side*side;
       } catch (ArithmeticException e) {
        throw new ArithmeticException("Arithmetic error occures while calculating the area");
       } 
    }
    /**
     * If a arithmatic error occurs, such as overflow , an AtithmeticException throws an error accordingly   
     * @param width The Width of the Triangle or can be consider as base of the triangle
     * @param height The height of the triangle . Must be greater then zero
     * @return The area of triangle as a double
     */
    static double circleArea(double radius){
        if(radius<=0){
            throw new IllegalArgumentException("Base and height must be greater then zero");
        }
       try {
        return Math.PI*radius*radius;
       } catch (ArithmeticException e) {
        throw new ArithmeticException("Arithmetic error occures while calculating the area");
       } 
    }

    public static void main(String[] args) {
        while(true){
            System.out.println("You can Calculate the areas of following figures select One:");
            System.out.println("1 : Area Of Triangle");
            System.out.println("2 : Area Of Rectangle");
            System.out.println("3 : Area Of Square");
            System.out.println("4 : Area Of Circle ");
            System.out.println("5 : Exit");
            System.out.println("-----------------------------------------");

            System.out.print("Enter your choice : ");
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();

            switch (num) {
                //For Triangle Area
                case 1:
                    System.out.println("Enter the widhth of the Triangle");
                    double widthTriangle = scanner.nextDouble();
                    System.out.println("Enter the height of the Triangle");
                    double heightTriangle = scanner.nextDouble();
                    try {
                        double areaTriangle = triangleArea(widthTriangle, heightTriangle);
                        System.out.println("Area of the triangle is: "+areaTriangle);
                    } catch (ArithmeticException e) {
                        System.err.println("Error "+e.getMessage());
                    }  
                    
                    break;
                //For Rectangle Area
                case 2:
                    System.out.println("Enter the widhth of the Rectangle");
                    double widthReactangle = scanner.nextDouble();
                    System.out.println("Enter the height of the Triangle");
                    double heightRectangle = scanner.nextDouble();
                    double areaReactangle = rectangleArea(widthReactangle, heightRectangle);
                    System.out.println("Area of the triangle is: "+areaReactangle);
                    break;
                //For Square Area
                case 3:
                    System.out.println("Enter the Side of the Square");
                    double sideSquare = scanner.nextDouble();
                    double areaSquare = squareArea(sideSquare);
                    System.out.println("Area of the triangle is: "+areaSquare);
                    break;
                // For Circle Area
                case 4:
                    System.out.println("Enter the Radius  of the Circle");
                    double radiusCircle = scanner.nextDouble();
                    double areaCircle= circleArea(radiusCircle);
                    System.out.println("Area of the triangle is: "+areaCircle);
                    break;
                case 5:
                    System.exit(0);
                    scanner.close();
                    break;
                default:
                    System.out.println("Please enter a right choice");
                    break;
            }
        }
    }
}
