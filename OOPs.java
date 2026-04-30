import javax.print.DocFlavor.STRING;



// praactice QUestion 
    // Q1





public class OOPs {





    
    public static void main (String args[]){

        // practice q1 =-

        System.out.println(" ");
        complex c= new complex(4,5 );
        complex d= new complex(9, 4);
        complex e= complex.add(c, d);
        e.printcomplex();








// inheritance
        // fish shark = new fish();
        // shark.eat();

        // dog dobby = new dog();
        // dobby.legs = 4;
        // System.out.println(dobby.legs);

        // // mtd overrinding
        // deer d = new deer();
        // d.eat();

        // creating a constructor 
        // student s1=new student();
        // System.out.println(s1.name);

        // types of constructor 
        // parameterized constructor 
        // student s2= new student("anmol");
        // student s3 = new student(1232);

        // copy constructor
        // student s1=new student();
        // s1.name = "anmol";
        // s1.roll = 123;
        // s1.password = "absd";

        // student s2 = new student(s1);
        // s2.password = "absd";

// class 1 -----
//         Pen p1 = new Pen(); //constructor
//         p1.setcolor("blue");
//         System.out.println(p1.color);
//         p1.settip(55);
//         System.out.println(p1.tip);
//         p1.setcolor("yellow");
//         System.out.println(p1.color);
//         p1.color = "red";
//         System.out.println(p1.color);

        // // access modifier
        // bankaccount myacc= new bankaccount();
        // myacc.username = "anmol";
        // myacc.setpassword("abcdefg");

        // // getter and setter
        // Pen p1 = new Pen();
        // p1.setcolor("bule");
        // System.out.println(p1.getcolor());
        // p1.setcolor("yellow");
        // System.out.println(p1.getcolor());
        // p1.settip(5);
        // System.out.println(p1.getTip());

        // encapsulation
        // Constructor - initialisation 
        // Student s1= new Student("anmol");
        // Student s1= new Student();
        // System.out.println(s1.name);

        // // types of constructor
        // Student s1= new Student();
        // Student s2= new Student("anmol");
        // Student s3= new Student(123);

        // // // types of constructor
        // Student s1= new Student();
        // s1.name= "aman";
        // s1.roll=123;
        // s1.password = "abcd";
        // s1.marks[0] = 89;
        // s1.marks[2] = 82;
        // s1.marks[1] = 81;

        // Student s2 = new Student(s1);
        // s2.password = "xyz";

        
        // for(int i =0;i<3;i++){
        //     System.out.println(s2.marks[i]);
        // }
        //         // deep and shallow copy constructor 
        // //     // after changing value of s1 ,s2 changes as s2 is using  
        // //     // reference of s1 array in class Student();
        // s1.marks[1] = 93;
        // for(int i =0;i<3;i++){
        //     System.out.println(s2.marks[i]);
        // }

                // inheritance 
        // fish shark = new fish();
        // // shark.eat();
        // dog dobby = new dog();
        // dobby.eat();
        // dobby.legs = 4;
        // System.out.println(dobby.legs);
            // hierarchial inheritance 


                // method overloading
        // calculator calc = new calculator();
        // System.out.println(calc.sum(1,2));
        // System.out.println(calc.sum(1,2,3));
        // System.out.println(calc.sum((float)1.4,(float)2.2));


        // method overriding
        // deer d = new deer();
        // d.eat();

        // horse h = new horse();
        // h.eat();
        // h.walk();
        // chicken c = new chicken();
        // c.eat();
        // c.walk();
// also can't create obj of animal becoz of abstraction
//      but can create constructor


        // abstract class
        // mustang myhorse = new mustang();
        // animal ->horse -> mustang

        //      super keyword
        // horse h =new horse();
        

    }}


// //  1st class and getter and setters
//     class Pen {
//         private String color;
//         private int tip;

//         String getcolor(){
//             return this.color;
//         }

        
//         int getTip(){
//             return this.tip;
//         }

//         void setcolor(String newcolor){
//             color = newcolor;
//         }

//         void settip(int newtip){
//             tip =newtip;
//         }
//     }



    // access modifier
    // class bankaccount {
    //     public String username;
    //     private String password;

    //     public void setpassword(String pw){
    //         password = pw;
    //     }
        
    // }

    // class Student {
        
    //     String1 name;
    //     int roll;
    //     int marks[];
    //     String1 password ;

                    // constructor 
        // Student(){ //String name
        //     // this.name = name;
        //     System.out.println(("constructor is called"));
        // }

                    // types of constructor
        //  non parameterized constructor
        // Student(){

        //     System.out.println("constructor is called");
        //     marks = new int[3];
        // }

    //     student(String name){
    //         this.name = name;
    //         // System.out.println("constructor is called");
    //     }

    //     student(int roll){
    //         this.roll =roll ;
    //     }

                // copy constructor

        // // copy constructor of s2 
        // Student(Student s1){
        //     marks = new int[3];
        //     this.name =s1.name;
        //     this.roll = s1.roll;
        //     this.marks = s1.marks; // this is reference to array 
            // rather than value , and thus s2 will change with s1 
        // }


                // deep copy constructor
                
//                 Student(Student s1){
//                         marks = new int[3];
//                         this.name =s1.name;
//                         this.roll = s1.roll;
//                         for(int i =0;i<marks.length;i++){
//                             this.marks[i] = s1.marks[i];
//                         }
// }




    // }


    //    

    // }

    // super keyword

// method overriding
// class deer extends animal {
//     void eat(){
//         System.out.println("eats grass");
//     }

// }



//                 // Inheritance
// class animal{ // parent
//     String color;
//     void eat(){
//         System.out.println("eats anything");
//     }
//     void breathe(){
//         System.out.println("brathes");
//     }
// }

// // derived
// class fish extends animal{
//     int fins;
//     void swim(){
//         System.out.println("swim");
//     }
// }

// // multi level inheritance
//  class mammal extends animal{
//     int legs;
//     //  hierarchial inheritance 
//     void walks (){
//         System.err.println("walks");
//     }
//  }
// //  level 2
//  class dog extends mammal{
//     String breed;
//  }

// //  hierarchial inheritance 
// class fishes extends animal {
//     void swim (){
//         System.out.print("swims ");
//     }
// }

//                 // hybrid inheritance 
//     class sharks extends fish {
//         void carnivore(){
//             System.out.print("eats living fish");
//         }
//     }

                // polymorphism 


// //          function overloading
//     class calculator {
//         int sum(int a ,int b){
//             return a +b ;
//         }
        
//             int sum(int a ,int b , int c){
//                 return a +b +c;
//             }

//         float sum (float a ,float b){
//             return a+b;
//         }
        
//     }

    // class animal {
    //     void eat(){
    //         System.out.println("eats anything");
    //     }
    // }

    
    // class deer extends animal {
    //     void eat(){
    //         System.out.println("eats grass");
    //     }
    // }

    // // abstraction
    // abstract class animal{
    //     String color;
    //     void eat(){
    //         System.out.print("eats");
    //     }
    //     animal (){
    //         color = "brown";
    //         System.out.println("animal constrcutro called");
    //     }
    //     abstract void walk();
        


    // }

    // class horse extends animal{
    //     horse (){
    //         System.out.println("horse constrcutro called");
    //     }
    //     void changecolor(){
    //         color = "dark";
    //     }
    //     void walk(){
    //         System.out.println("walks on 4 legs");
    //     }
    // }

    // class mustang extends horse {
    //     mustang (){
    //         System.out.println("mustangconstrcutro called");
    //     }
    // }

    // class chicken extends animal{
    //     void changecolor(){
    //         color = "yellow";
    //     }
    //     void walk(){
    //         System.out.println("walks on 2legs");
    //     }
    // }

                // interface\
        // interface herbivore{}
        // interface carnivore{}
                
        // class bear implements herbivore, carnivore{
        //     void eats (){
        //         // eats both
        //     }
        // }

// static keyword
// super keyword
class animal{
    animal(){
        System.out.println("constructor caleex");
    }
}
class horse extends animal{
    horse(){
        super();
        System.out.println("horse called");
    }
}


class complex{
    int real;
    int imag;
    public complex(int i, int r){
        this.imag= i;
        this.real= r;
    }

public static complex add(complex a, complex b){
    return new complex((a.real+b.real),(a.imag+b.imag));
}

    public void printcomplex(){
        if(real == 0 && imag !=0){
            System.out.println(imag +"i");
        }
        else if(imag == 0&& real !=0){
            System.out.println(real +"");
        }
        else System.out.println(real + " +"+ imag+"i");
    }


}

