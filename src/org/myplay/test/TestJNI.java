package org.myplay.test;

public class TestJNI {

   static {
     System.load("/Users/changpt/Documents/workspace/WarmanVehicle/build/libMidasBofs.so");
   }

   public static native int XSLogin();

   public static void main(String[] args) {
	   TestJNI t = new TestJNI();
      System.out.println(t.XSLogin());
   }

}
