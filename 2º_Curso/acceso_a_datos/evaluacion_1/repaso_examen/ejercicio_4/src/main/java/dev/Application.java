
package dev;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;

public class Application {
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new FileReader(""))) {
    } catch (Exception e) {
      // TODO: handle exception
    }

    try (ObjectInputStream obi = new ObjectInputStream(new BufferedInputStream(new FileInputStream("null")))) {
      
    } catch (Exception e) {
      // TODO: handle exception
    }

    try (DataInputStream dti = new DataInputStream(new BufferedInputStream(new FileInputStream("null")))) {
      
    } catch (Exception e) {
      // TODO: handle exception
    }

    try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(""))) {
      
    } catch (Exception e) {
      // TODO: handle exception
    }

  }
}
