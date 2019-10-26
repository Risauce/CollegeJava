/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugofwar232;

import java.util.Scanner;

/**
 *
 * @author risau
 */
public class copied {
    
    int[] a;
    int n;
    boolean[] selected;
    boolean[] solution;
    int minDiff;
    
    copied(int child, int max)
    {
        n = child;
        
         minDiff = Integer.MAX_VALUE;
         solution = new boolean[n];
         selected = new boolean[n];
         
         a = new int[n];
    }
    
    public void readWeights(Scanner fin)
    {
        for (int i = 0; i < n; i++) {
            a[i] = fin.nextInt();
        }
    }
    
    
    public void solve(int currentIndex) {

  // get size of selected
  int selectedSize = 0;
  for (int i = 0; i < n; i++)
   if (selected[i])
    selectedSize++;

  if (selectedSize == n / 2) {
   // check if diff < minDiff, update solution
   int diff = getDiff();
   if (diff < minDiff) {
    minDiff = diff;
    updateSolution();
   }
  }

  // check if currentIndex == n and return
  if (currentIndex >= n)
   return;

  // add curindex to selected
  selected[currentIndex] = true;
  solve(currentIndex + 1);

  // remove curindex from selected
  selected[currentIndex] = false;
  solve(currentIndex + 1);
 }

 protected  void updateSolution() {
  for (int i = 0; i < n; i++) {
   solution[i] = selected[i];
  }
 }

 protected  void print() {
  for (int i = 0; i < n; i++) {
   if (solution[i]) {
    System.out.print(a[i]);
    System.out.print(",");
   }
  }
  System.out.println();
  for (int i = 0; i < n; i++) {
   if (!solution[i]) {
    System.out.print(a[i]);
    System.out.print(",");
   }
  }
  System.out.println();
 }

 protected  int getDiff() {

  int leftSum = 0;
  int rightSum = 0;

  for (int i = 0; i < n; i++) {
   if (selected[i])
    leftSum += a[i];
   else
    rightSum += a[i];
  }

  return Math.abs(rightSum - leftSum);
 }
    
    
    
    
}
